package ru.sberbank.itgod.mechanics.state.abilities;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class TwoTowersAbilityState extends AbilityState {

	// ID первого строения, на которое произнесено заклинание
	@SerializedName("FirstTargetTowerId")
	private int firstTargetTowerId;

	// ID второго строения, на которое произнесено заклинание
	@SerializedName("SecondTargetTowerId")
	private int secondTargetTowerId;
}
