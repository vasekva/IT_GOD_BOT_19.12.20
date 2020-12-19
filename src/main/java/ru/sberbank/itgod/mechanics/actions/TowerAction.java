package ru.sberbank.itgod.mechanics.actions;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import ru.sberbank.itgod.enums.Action;
import ru.sberbank.itgod.enums.PlayerColor;
import ru.sberbank.itgod.mechanics.state.BuildingState;

@Data
public class TowerAction extends GameAction {
	@SerializedName("TowerId")
	private final int towerId;
	@SerializedName("CurrentBuild")
	private BuildingState currentBuild;
	@SerializedName("CurrentBuildId")
	private int currentBuildId;

	public TowerAction(final PlayerColor playerColor, final int towerId) {
		super(playerColor, Action.TOWER_ACTION);
		this.towerId = towerId;
	}
}
