package ru.sberbank.itgod.mechanics.actions;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import ru.sberbank.itgod.enums.Abilities;
import ru.sberbank.itgod.enums.Action;
import ru.sberbank.itgod.enums.PlayerColor;

@Data
public class BuffAction extends GameAction {

	@SerializedName("X")
	private double x;
	@SerializedName("Y")
	private double y;
	@SerializedName("FirstTowerId")
	private int firstTowerId;
	@SerializedName("SecondTowerId")
	private int secondTowerId;
	@SerializedName("AbilityId")
	private final Abilities abilityId;

	public BuffAction(final PlayerColor playerColor, final double x, final double y, final Abilities abilityId) {
		super(playerColor, Action.BUFF_ACTION);
		this.x = x;
		this.y = y;
		this.abilityId = abilityId;
	}

	public BuffAction(final PlayerColor playerColor, final int fistTowerId, final int secondTowerId, final Abilities abilityId) {
		super(playerColor, Action.BUFF_ACTION);
		this.firstTowerId = fistTowerId;
		this.secondTowerId = secondTowerId;
		this.abilityId = abilityId;
	}

	public BuffAction(final PlayerColor playerColor, final int towerId, final Abilities abilityId) {
		super(playerColor, Action.BUFF_ACTION);
		this.firstTowerId = towerId;
		this.abilityId = abilityId;
	}
}
