package ru.sberbank.itgod.mechanics.state;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import ru.sberbank.itgod.mechanics.abilities.AbilityCooldownInfo;
import ru.sberbank.itgod.mechanics.state.abilities.AbilityState;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс состояния игры в определенный момент времени
 */
@Data
public class GameState {

	// Список состояний отрядов крипов на карте
	@SerializedName("squadStates")
	private List<SquadState> squadStates;

	// Список состояний строений на карте
	@SerializedName("buildingStates")
	private List<BuildingState> buildingStates;

	// Список состояний спеллов на карте
	@SerializedName("AbilityStates")
	private List<AbilityState> abilityStates;

	// Список состояний кулдаунов способностей. Если способности нет в списке, значит ее можно использовать
	@SerializedName("CooldownState")
	private List<AbilityCooldownInfo> cooldownState;

	// Номер текущего тика
	@SerializedName("Tick")
	private int tick;

	// Идентификатор команды-победителя. Если такой нет, то имеет значение null
	@SerializedName("WinnerTeamId")
	private String winnerTeamId;

	// Маска показывающая наличие/отсутствие действий глобальных эффектов
	@SerializedName("GlobalBuffsMask")
	private long globalBuffsMask;

	// Сообщение об ошибках
	@SerializedName("Error")
	private String error;

	private GameState(final List<SquadState> squadStates, final List<BuildingState> buildingStates) {
		this.squadStates = squadStates;
		this.buildingStates = buildingStates;
	}

	private GameState() {
		squadStates = new ArrayList<SquadState>();
		buildingStates = new ArrayList<BuildingState>();
		abilityStates = new ArrayList<AbilityState>();
		cooldownState = new ArrayList<AbilityCooldownInfo>();
	}
}

