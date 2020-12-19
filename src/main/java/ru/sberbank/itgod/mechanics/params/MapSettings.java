package ru.sberbank.itgod.mechanics.params;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import ru.sberbank.itgod.enums.PlayerColor;
import ru.sberbank.itgod.mechanics.Link;
import ru.sberbank.itgod.mechanics.MapUnity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

@Data
public class MapSettings implements Serializable {

	// Параметры карты для Unity
	@SerializedName("MapUnity")
	private MapUnity mapUnity = new MapUnity();

	// Список команд, которые принимают участие в сражении на карте
	@SerializedName("PlayerColors")
	private List<PlayerColor> playerColors;

	// Соответствие цвета команды к списку, содержащему ID башен команды
	@SerializedName("Towers")
	private HashMap<PlayerColor, List<Integer>> towers = new HashMap<>();

	// Соответствие цвета команды к списку, содержащему ID кузниц команды
	@SerializedName("Forges")
	private HashMap<PlayerColor, List<Integer>> forges = new HashMap<>();

	// Связи между башнями
	@SerializedName("Links")
	private List<Link> links;

	// Соответствия айди башни и уровня
	@SerializedName("Levels")
	private HashMap<Integer, Integer> levels = new HashMap<>();
}
