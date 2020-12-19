package ru.sberbank.itgod.websocket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import ru.sberbank.itgod.enums.*;
import ru.sberbank.itgod.mechanics.actions.GameAction;
import ru.sberbank.itgod.websocket.message.serializers.*;
import ru.sberbank.itgod.websocket.message.Message;

import ru.sberbank.itgod.websocket.message.model.EndPoint;


@Slf4j
public class MessageConverter {
    private static final GsonBuilder gsonBuilder = new GsonBuilder();
    public static final Gson GSON = gsonBuilder
            .registerTypeAdapter(MsgType.class, new MsgTypeSerializer())
            .registerTypeAdapter(HeroType.class, new HeroTypeSerializer())
            .registerTypeAdapter(PlayerColor.class, new PlayerColorSerializer())
            .registerTypeAdapter(Abilities.class, new AbilitiesSerializer())
            .registerTypeAdapter(AbilityInputType.class, new AbilityInputTypeSerializer())
            .registerTypeAdapter(Action.class, new ActionTypeSerializer())
            .registerTypeAdapter(BuildingType.class, new BuildingTypeSerializer())
            .registerTypeAdapter(CreepBuffIndexes.class, new CreepBuffIndexesSerializer())
            .registerTypeAdapter(ErrorCode.class, new ErrorCodeSerializer())
            .registerTypeAdapter(GlobalGameEventLoopMode.class, new GlobalGameEventLoopModeSerializer())
            .registerTypeAdapter(GlobalGameEventUseMode.class, new GlobalGameEventUseModeSerializer())
            .registerTypeAdapter(Part.class, new PartSerializer())
            .registerTypeAdapter(ScriptType.class, new ScriptTypeSerializer())
            .registerTypeAdapter(TowerBuffIndexes.class, new TowerBuffIndexesSerializer())
            .create();


    /**
     * Формирует объект класса Message из строки, присланной сервером
     */
    public static Message messageFromData(final String data) {
        return GSON.fromJson(data, Message.class);
    }

    /**
     * Формирует строку для отправки на сервер из объекта класса Message
     */
    public static String dataFromMessage(final Message message) {
        return GSON.toJson(message);
    }

    /**
     * Формирует строку для отправки на сервер из объекта класса GameAction
     */
    public static String dataFromAction(final GameAction action, final String game, final EndPoint server) {
        final String stringAction = GSON.toJson(action);
        final String json = new JSONObject()
                .put("MsgType", MsgType.GAME_ACTIONS.getValue())
                .put("GameId", game)
                .append("Subscribers", new JSONObject()
                        .put("Ip", server.getIp()).put("Port", server.getPort()))
                .put("GameActionsArgs", new JSONObject()
                        .put("Action", new JSONObject(stringAction)))
                .toString();
        log.debug("Json dataFromAction: {}", json);
        return json;
    }

    public static String getRequestGameParameters(final String user, final String game, final String bot) {
        final String json = new JSONObject()
                .put("MsgType", MsgType.PLAYER_REQUEST_GAME_PARAMETERS.getValue())
                .put("RequestGameParametersArgs", new JSONObject().
                        put("UserId", user).
                        put("GameId", game).
                        put("BotId", bot))
                .toString();
        log.debug("Sending getRequestGameParameters: {}", json);
        return json;
    }

    public static String getRequestPlayerConnect(final String game, final String bot, final EndPoint server) {
        final String json = new JSONObject()
                .put("MsgType", MsgType.PLAYER_CONNECT.getValue())
                .put("GameId", game)
                .append("Subscribers", new JSONObject()
                        .put("Ip", server.getIp()).put("Port", server.getPort()))
                .put("PlayerConnectArgs", new JSONObject()
                        .put("PlayerId", bot))
                .toString();

        log.debug("Sending getRequestPlayerConnect: {}", json);
        return json;
    }

    public static String getRequestPlayerChangeHero(final EndPoint server, final String game, final String bot, final HeroType heroType) {
        final String json = new JSONObject()
                .put("MsgType", MsgType.PLAYER_CHANGE_HERO_TYPE.getValue())
                .put("GameId", game)
                .append("Subscribers", new JSONObject()
                        .put("Ip", server.getIp()).put("Port", server.getPort()))
                .put("PlayerChangeHeroTypeArgs", new JSONObject()
                        .put("PlayerId", bot)
                        .put("HeroType", heroType))
                .toString();

        log.debug("Sending getRequestPlayerChangeHero: {}", json);
        return json;
    }

    public static String getPlayerChangeColor(final EndPoint server, final String game, final String bot, final PlayerColor playerColor) {
        final String json = new JSONObject()
                .put("MsgType", MsgType.PLAYER_CHANGE_COLOR.getValue())
                .put("GameId", game)
                .append("Subscribers", new JSONObject()
                        .put("Ip", server.getIp()).put("Port", server.getPort()))
                .put("PlayerChangeColorArgs", new JSONObject()
                        .put("PlayerId", bot)
                        .put("PlayerColor", playerColor))
                .toString();

        log.debug("Sending getPlayerChangeColor: {}", json);
        return json;
    }

    public static String getPlayerPrepared(final EndPoint server, final String game, final String bot) {
        final String json = new JSONObject()
                .put("MsgType", MsgType.PLAYER_PREPARED.getValue())
                .put("GameId", game)
                .append("Subscribers", new JSONObject()
                        .put("Ip", server.getIp()).put("Port", server.getPort()))
                .put("PlayerPreparedArgs", new JSONObject()
                        .put("PlayerId", bot))
                .toString();

        log.debug("Sending getPlayerPrepared: {}", json);
        return json;
    }

    public static String getPlayerReady(final EndPoint server, final String game, final String bot) {
        final String json = new JSONObject()
                .put("MsgType", MsgType.PLAYER_READY.getValue())
                .put("GameId", game)
                .append("Subscribers", new JSONObject()
                        .put("Ip", server.getIp()).put("Port", server.getPort()))
                .put("PlayerReadyArgs", new JSONObject()
                        .put("PlayerId", bot))
                .toString();

        log.debug("Sending getPlayerReady: {}", json);
        return json;
    }

    public static String getGameActions(final EndPoint server, final String game, final GameAction action) {
        final String json = new JSONObject()
                .put("MsgType", MsgType.GAME_ACTIONS.getValue())
                .put("GameId", game)
                .append("Subscribers", new JSONObject()
                        .put("Ip", server.getIp()).put("Port", server.getPort()))
                .put("GameActionsArgs", new JSONObject()
                        .put("Action", action))
                .toString();

        log.debug("Sending getGameActions: {}", json);
        return json;
    }

    public static String getCancelMessage(final String game, final String bot, final String reason, final EndPoint server) {
        final String json = new JSONObject()
                .put("MsgType", MsgType.GAME_CANCEL.getValue())
                .put("GameId", game)
                .append("Subscribers", new JSONObject()
                        .put("Ip", server.getIp()).put("Port", server.getPort()))
                .put("GameCancelArgs", new JSONObject()
                        .put("PlayerId", bot)
                        .put("Reason", reason))
                .toString();

        log.debug("Sending getCancelMessage: {}", json);
        return json;
    }


}
