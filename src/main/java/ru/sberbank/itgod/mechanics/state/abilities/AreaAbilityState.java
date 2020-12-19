package ru.sberbank.itgod.mechanics.state.abilities;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class AreaAbilityState extends AbilityState {

	// Х координата области действия заклинания
	@SerializedName("X")
	private double x;
	// Y координата области действия заклинания
	@SerializedName("Y")
	private double y;
}
