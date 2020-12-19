package ru.sberbank.itgod.mechanics.actions;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.sberbank.itgod.enums.Action;
import ru.sberbank.itgod.enums.PlayerColor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameAction {

	@SerializedName("PlayerColor")
	public PlayerColor playerColor;
	@SerializedName("Type")
	public Action action;
}
