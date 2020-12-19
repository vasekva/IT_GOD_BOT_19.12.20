package ru.sberbank.itgod.websocket.message.model;

import lombok.Data;
import ru.sberbank.itgod.mechanics.Team;
import ru.sberbank.itgod.mechanics.state.GameState;

import java.util.List;

@Data
public class GameEx {
	private EndPoint botServer;
	private Iterable<Subscriber> subscribers;

	private String wsIp;

	private boolean isMatch;
	private int currentTick;

	private String gameId;

	private EndPoint gameServer;

	private String map;

	private List<Team> teams;
	private Integer awaitConnectingPlayersTimeout;
	private String parameters;

	private GameState state;

	private boolean waitForCompleteConnection;
	private String ownerPlayerId;

	public GameEx(
			final String gameId,
			final EndPoint gameServer,
			final EndPoint botServer,
			final String map,
			final String parameters,
			final Iterable<Subscriber> subscribers,
			final List<Team> teams,
			final Integer awaitConnectingPlayersTimeout,
			final boolean isMatch,
			final boolean waitForCompleteConnection,
			final String ownerPlayerId,
			final String wsIp) {
		if (ownerPlayerId == null) {
			throw new IllegalArgumentException("OwnerPlayerId is null");
		}
		if (wsIp == null) {
			throw new IllegalArgumentException("WsIp is null");
		}
		this.gameId = gameId;
		this.gameServer = gameServer;
		this.map = map;
		this.parameters = parameters;
		this.teams = teams;
		this.awaitConnectingPlayersTimeout = awaitConnectingPlayersTimeout;
		this.currentTick = 0;
		this.botServer = botServer;
		this.subscribers = subscribers;
		this.isMatch = isMatch;
		this.waitForCompleteConnection = waitForCompleteConnection;
		this.ownerPlayerId = ownerPlayerId;
		this.wsIp = wsIp;
	}
}
