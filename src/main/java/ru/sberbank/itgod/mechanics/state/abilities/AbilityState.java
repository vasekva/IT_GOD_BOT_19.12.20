package ru.sberbank.itgod.mechanics.state.abilities;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import ru.sberbank.itgod.enums.Abilities;
import ru.sberbank.itgod.enums.AbilityInputType;
import ru.sberbank.itgod.enums.PlayerColor;

@Data
public class AbilityState {

	// Идентификатор заклинания
	@SerializedName("Ability")
	private Abilities ability;

	// Тип применения заклинания
	@SerializedName("AbilityInputType")
	private AbilityInputType abilityInputType;

	// Цвет игрока, который произнес заклинание
	@SerializedName("OwnerColor")
	private PlayerColor ownerColor;

	// Номер тика, на котором заклинание было произнесено
	@SerializedName("InitialTick")
	private int initialTick;

	// Номер тика, на котором заклинание начало/начнет свое действие
	@SerializedName("StartTick")
	private int startTick;

	// Номер тика, на котором заклинание прекращает
	@SerializedName("EndTick")
	private int endTick;
}
