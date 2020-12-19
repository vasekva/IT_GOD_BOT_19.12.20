package ru.sberbank.itgod.mechanics.actions;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import ru.sberbank.itgod.enums.Action;
import ru.sberbank.itgod.enums.PlayerColor;

@Data
public class MoveAction extends GameAction {

	@SerializedName("FromId")
	private final int fromId;
	@SerializedName("ToId")
	private final int toId;
	/**
	 * Часть крипов, которая посылается из строения. Лежит в диапазоне [0; 1]
	 */
	@SerializedName("Part")
	private final double part;

	public MoveAction(final PlayerColor playerColor, final int fromId, final int toId, final double part) {
		super(playerColor, Action.MOVE_ACTION);
		this.fromId = fromId;
		this.toId = toId;
		this.part = part;
	}
}
