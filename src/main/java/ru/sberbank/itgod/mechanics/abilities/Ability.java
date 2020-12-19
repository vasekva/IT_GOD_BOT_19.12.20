package ru.sberbank.itgod.mechanics.abilities;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import ru.sberbank.itgod.enums.Abilities;
import ru.sberbank.itgod.enums.AbilityInputType;

@Data
public class Ability {
	@SerializedName("Id")
	private Abilities id;
	@SerializedName("InputType")
	private AbilityInputType inputType;
	@SerializedName("Duration")
	private int duration;
	@SerializedName("Cooldown")
	private int cooldown;
	@SerializedName("CastTime")
	private int castTime;
	@SerializedName("Radius")
	private float radius;
	@SerializedName("AbilityData")
	private String abilityData;
}
