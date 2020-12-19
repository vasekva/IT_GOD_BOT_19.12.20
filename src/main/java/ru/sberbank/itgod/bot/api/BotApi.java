package ru.sberbank.itgod.bot.api;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import ru.sberbank.itgod.bot.heroes.Hero;
import ru.sberbank.itgod.enums.Abilities;
import ru.sberbank.itgod.enums.MsgType;
import ru.sberbank.itgod.enums.PlayerColor;
import ru.sberbank.itgod.exceptions.IntegrationException;
import ru.sberbank.itgod.mechanics.LinksStorage;
import ru.sberbank.itgod.mechanics.MapUtility;
import ru.sberbank.itgod.mechanics.Team;
import ru.sberbank.itgod.mechanics.Vector3;
import ru.sberbank.itgod.mechanics.actions.ErrorAction;
import ru.sberbank.itgod.mechanics.params.GameParameters;
import ru.sberbank.itgod.mechanics.params.MapSettings;
import ru.sberbank.itgod.mechanics.state.BuildingState;
import ru.sberbank.itgod.mechanics.state.GameState;
import ru.sberbank.itgod.mechanics.state.SquadState;
import ru.sberbank.itgod.websocket.AsyncListener;
import ru.sberbank.itgod.websocket.AsyncSender;
import ru.sberbank.itgod.websocket.message.Message;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Data
public class BotApi {

	private final AsyncListener listener = AsyncListener.getInstance();
	private final AsyncSender sender = AsyncSender.getInstance();

	private final List<Team> enemyTeams;
	private final MapSettings map;
	private final GameParameters parameters;
	private final Hero hero;
	private final LinksStorage linksStorage;

	public BotApi(final List<Team> teams, final MapSettings map, final GameParameters parameters, final Hero hero, LinksStorage storage) {
		final String myTeam = hero.getTeam().getTeamId();
		this.enemyTeams = teams.stream().filter(x -> !x.getTeamId().equals(myTeam)).collect(Collectors.toList());
		log.debug("My team: {}", myTeam);
		log.debug("List of enemy teams: {}", enemyTeams);
		this.map = map;
		this.parameters = parameters;
		this.hero = hero;
		this.linksStorage = storage;
	}

	public GameState getGameState() throws IntegrationException {
		final Message gameStateMessage = listener.getMessage(MsgType.GAME_STATE);
		return gameStateMessage.getGameStateArgs().getState();
	}

	public List<BuildingState> getBuildings(final GameState state, final PlayerColor color) {
		return state.getBuildingStates().stream().filter(x -> x.getPlayerColor() == color).collect(Collectors.toList());
	}

	public List<SquadState> getSquads(final GameState state, final PlayerColor color) {
		return state.getSquadStates().stream().filter(x -> x.getPlayerColor() == color).collect(Collectors.toList());
	}

	public List<Abilities> getAbilitiesOnCooldown(final GameState state, final PlayerColor color) {
		return state.getCooldownState().stream()
				.filter(x -> x.getPlayerColor() == color)
				.map(x -> x.getAbility())
				.collect(Collectors.toList());
	}

	public Vector3 getSquadPosition(final SquadState squadState) {
		return MapUtility.getSquadCenterPosition(squadState, linksStorage);
	}

	public void sendError(final String error) {
		final ErrorAction errorAction = new ErrorAction(hero.getPlayerColor(), error);
		sender.put(errorAction);
	}

	public List<BuildingState> getEnemyBuildings(final GameState gameState, final PlayerColor myColor) {
		return gameState.getBuildingStates().stream().filter(x -> x.getPlayerColor() != myColor).collect(Collectors.toList());
	}

	public List<SquadState> getEnemySquads(final GameState gameState, final PlayerColor myColor) {
		return gameState.getSquadStates().stream().filter(x -> x.getPlayerColor() != myColor).collect(Collectors.toList());
	}

	public List<SquadState> getMovingSquads(final List<SquadState> squads) {
		return squads.stream().filter(x -> x.getFromId() != 0 && x.getToId() != 0).collect(Collectors.toList());
	}


}
