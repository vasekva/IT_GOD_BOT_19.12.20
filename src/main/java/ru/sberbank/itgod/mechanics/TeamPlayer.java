package ru.sberbank.itgod.mechanics;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import ru.sberbank.itgod.enums.HeroType;
import ru.sberbank.itgod.enums.PlayerColor;

@Data
public class TeamPlayer {

	public TeamPlayer(String gamePlayerId, boolean isBot, String playerId, PlayerColor playerColor, HeroType heroType) {
		this.gamePlayerId = gamePlayerId;
		this.isBot = isBot;
		this.playerId = playerId;
		this.playerColor = playerColor;
		this.heroType = heroType;
	}

	@SerializedName("GamePlayerId")
	private String gamePlayerId;
	@SerializedName("IsBot")
	private boolean isBot;
	@SerializedName("PlayerId")
	private String playerId;
	@SerializedName("PlayerColor")
	private PlayerColor playerColor;
	@SerializedName("HeroType")
	private HeroType heroType;
	@SerializedName("Connected")
	private boolean connected;
	@SerializedName("Prepared")
	private boolean prepared;
	@SerializedName("Ready")
	private boolean ready;
}
