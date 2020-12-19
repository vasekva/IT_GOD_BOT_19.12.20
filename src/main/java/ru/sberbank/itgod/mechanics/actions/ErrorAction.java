package ru.sberbank.itgod.mechanics.actions;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import ru.sberbank.itgod.enums.Action;
import ru.sberbank.itgod.enums.PlayerColor;

@Data
public class ErrorAction extends GameAction {

	@SerializedName("Message")
	private final String message;

	public ErrorAction(final PlayerColor playerColor, final String message) {
		super(playerColor, Action.ERROR_ACTION);
		this.message = message;
	}
}
