package ru.sberbank.itgod.mechanics.params;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import ru.sberbank.itgod.enums.Abilities;
import ru.sberbank.itgod.enums.GlobalGameEventLoopMode;
import ru.sberbank.itgod.enums.GlobalGameEventUseMode;
import ru.sberbank.itgod.enums.PlayerColor;

/**
 * Класс предоставляющий параметры глобальных событий игры, которые передаются в игровых параметрах при
 * инициализации игры
 */
@Data
public class GameEventsParameters {

	@SerializedName("StartTick")
	private int startTick;
	@SerializedName("LoopInterval")
	private int loopInterval;
	@SerializedName("LoopMode")
	private GlobalGameEventLoopMode loopMode;
	@SerializedName("UseMode")
	private GlobalGameEventUseMode useMode;
	@SerializedName("Ability")
	private Abilities ability;
	@SerializedName("TargetColor")
	private PlayerColor targetColor;
}
