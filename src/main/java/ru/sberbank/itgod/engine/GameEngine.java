package ru.sberbank.itgod.engine;

import lombok.extern.slf4j.Slf4j;
import ru.sberbank.itgod.bot.Bot;
import ru.sberbank.itgod.bot.api.BotApi;
import ru.sberbank.itgod.bot.heroes.BlackSmith;
import ru.sberbank.itgod.bot.heroes.Hero;
import ru.sberbank.itgod.bot.heroes.Mage;
import ru.sberbank.itgod.bot.heroes.Warrior;
import ru.sberbank.itgod.enums.HeroType;
import ru.sberbank.itgod.enums.MsgType;
import ru.sberbank.itgod.enums.PlayerColor;
import ru.sberbank.itgod.mechanics.LinksStorage;
import ru.sberbank.itgod.mechanics.Team;
import ru.sberbank.itgod.mechanics.TeamPlayer;
import ru.sberbank.itgod.mechanics.params.GameParameters;
import ru.sberbank.itgod.mechanics.params.MapSettings;
import ru.sberbank.itgod.websocket.AsyncListener;
import ru.sberbank.itgod.websocket.AsyncSender;
import ru.sberbank.itgod.websocket.MessageConverter;
import ru.sberbank.itgod.websocket.WebSocket;
import ru.sberbank.itgod.websocket.message.Message;
import ru.sberbank.itgod.websocket.message.args.ResponseGameParametersArgs;
import ru.sberbank.itgod.websocket.message.model.EndPoint;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

import static ru.sberbank.itgod.enums.MsgType.*;
import static ru.sberbank.itgod.websocket.MessageConverter.GSON;

@Slf4j
public class GameEngine {

    private static final AsyncListener asyncListener = AsyncListener.getInstance();

    public static void start(final Bot bot, final String userId, final String botId, final String gameId, final WebSocket webSocket) throws Exception {
//        asyncListener.setGameId(options.getGame());

        log.info("Bot {} request game", botId);
        final String requestGameParameters = MessageConverter.getRequestGameParameters(userId,
                gameId, botId);
        webSocket.sendMessage(requestGameParameters);

        final Message responseGameParameters = asyncListener.getMessage(MsgType.PLAYER_RESPONSE_GAME_PARAMETERS);

        final String responseGameId = responseGameParameters.getGameId();
//        if (asyncListener.getGameId() == null)
//            asyncListener.setGameId(gameId);
        final ResponseGameParametersArgs gameParametersArgs = responseGameParameters.getResponseGameParametersArgs();
        final MapSettings gameMap = GSON.fromJson(gameParametersArgs.getMap(), MapSettings.class);
        final LinksStorage storage = new LinksStorage();
        storage.addAllLinksToStorage(gameMap.getLinks());
        final GameParameters gameParameters = GSON.fromJson(gameParametersArgs.getParameters(), GameParameters.class);
        final EndPoint gameServer = gameParametersArgs.getGameServer();

        gameParameters.getAbilitiesParameters().setAbilityHashMap();

        AsyncSender.initSender(webSocket, responseGameId, gameServer);

        log.info("Connect bot {} to game {}", botId, responseGameId);
        final String requestPlayerConnect = MessageConverter.getRequestPlayerConnect(responseGameId, botId, gameServer);
        webSocket.sendMessage(requestPlayerConnect);

        log.info("Select hero type");
        final String heroTypeMessage = MessageConverter.getRequestPlayerChangeHero(gameServer, responseGameId, botId, gameParametersArgs.getHeroType());
        webSocket.sendMessage(heroTypeMessage);

        /**
         * Если среди присланных игроков ни у одного id не совпадает с id нашего бота, мы занимаем первый свободный слот игрока (у которого id == null).
         * В таком случае, мы отправляем на сервер сообщение с новым цветом команды нашего бота.
         */
        if (Stream.of(gameParametersArgs.getTeamPlayers())
                .noneMatch(x -> botId.equals(x.getPlayerId()))) {
            final Optional<TeamPlayer> freeTeam = Stream.of(gameParametersArgs.getTeamPlayers()).filter(x -> x.getPlayerId() == null).findFirst();
            final PlayerColor playerColor = freeTeam.orElseThrow(() -> new NoSuchElementException()).getPlayerColor();
            log.info("Selected bot {} color: {}", botId, playerColor);
            final String playerColorMessage = MessageConverter.getPlayerChangeColor(gameServer, responseGameId, botId, playerColor);
            webSocket.sendMessage(playerColorMessage);
        }

        final Message allConnectedResponse = asyncListener.getMessage(GAME_ALL_PLAYERS_CONNECTED);

        log.info("All players connected. Preparing bot {}", botId);
        final String playerPrepared = MessageConverter.getPlayerPrepared(gameServer, responseGameId, botId);
        webSocket.sendMessage(playerPrepared);

        asyncListener.getMessage(GAME_ALL_PLAYERS_PREPARED);

        log.info("All players prepared. Bot {} is ready", botId);
        final String playerReady = MessageConverter.getPlayerReady(gameServer, responseGameId, botId);
        webSocket.sendMessage(playerReady);

        asyncListener.getMessage(GAME_ALL_PLAYERS_READY);
        final List<Team> teams = Arrays.asList(allConnectedResponse.getAllPlayersConnectedArgs().teams);
        final Optional<Team> optionalTeam = teams.stream().filter(team -> team.getPlayers().stream()
                .anyMatch(teamPlayer -> botId.equals(teamPlayer.getPlayerId()))).findFirst();
        final Team ourTeam = optionalTeam.orElseThrow(NoSuchElementException::new);
        final TeamPlayer player = ourTeam.getPlayers().stream().filter(teamPlayer -> botId.equals(teamPlayer.getPlayerId()))
                .findFirst().orElseThrow(NoSuchElementException::new);

        final Hero hero = createHero(player.getHeroType(), player.getPlayerColor(), ourTeam);
        if (hero == null) {
            final String cancelMessage = MessageConverter.getCancelMessage(responseGameId, botId, "Не задан тип героя бота", gameServer);
            webSocket.sendMessage(cancelMessage);
            return;
        }
        final BotApi botApi = new BotApi(teams, gameMap, gameParameters, hero, storage);
        final Thread botThread = new Thread(() -> {
            try {
                bot.play(botApi);
            } catch (final Exception e) {
                log.error(e.getMessage(), e);
            }
        });
        botThread.start();
    }

    private static Hero createHero(final HeroType heroType, final PlayerColor color, final Team team) {
        switch (heroType) {
            case MAGE:
                return new Mage(color, team);
            case BLACKSMITH:
                return new BlackSmith(color, team);
            case WARRIOR:
                return new Warrior(color, team);
            default: {
                log.error("Cancel game. Bot doesn't have any type");
                return null;
            }
        }
    }

}
