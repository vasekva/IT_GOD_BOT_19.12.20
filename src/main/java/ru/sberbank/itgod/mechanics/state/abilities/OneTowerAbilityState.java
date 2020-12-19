package ru.sberbank.itgod.mechanics.state.abilities;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class OneTowerAbilityState extends AbilityState {

	// ID строения, на которое произнесено заклинание
	@SerializedName("TargetTowerId")
	private int targetTowerId;
}
