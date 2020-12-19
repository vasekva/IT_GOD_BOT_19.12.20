package ru.sberbank.itgod.mechanics.abilities;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.sberbank.itgod.enums.Abilities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static ru.sberbank.itgod.websocket.MessageConverter.GSON;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AbilitiesParameters implements Serializable {
	@SerializedName("abilities")
	private final List<Ability> abilities = new ArrayList<>();

	private HashMap<Abilities, AbilityData> abilityHashMap = new HashMap<>();

	public void setAbilityHashMap() {
		for (Ability ability: abilities) {
			abilityHashMap.put(ability.getId(), GSON.fromJson(ability.getAbilityData(), AbilityData.class));
		}
	}
}
