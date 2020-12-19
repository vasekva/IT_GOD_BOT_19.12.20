package ru.sberbank.itgod.mechanics.params;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.sberbank.itgod.mechanics.abilities.AbilitiesParameters;
import ru.sberbank.itgod.mechanics.params.buildings.ForgesSettings;
import ru.sberbank.itgod.mechanics.params.buildings.TowersSettings;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Класс, описывающий числовые параметры карты
 */

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameParameters implements Serializable {

	// Продолжительность битвы в тиках
	@SerializedName("Duration")
	private int duration = 150;

	// Стандартный множитель защиты здания при атаке вражеской команды
	// Должно равняться единице по документации, добавлено для дебага
	@SerializedName("DefaultDefenseParameter")
	private double defaultDefenseParameter = 1.2;

	// Настройки кузниц на карте
	@SerializedName("Forges")
	private ForgesSettings forges = new ForgesSettings();

	// Настройки башен на карте. Ключ - уровень башни
	@SerializedName("Towers")
	private HashMap<Integer, TowersSettings> towers = new HashMap<>();

	// Настройки крипов на карте
	@SerializedName("Creeps")
	private CreepsSettings creeps = new CreepsSettings();

	// Настройка абилок на карте
	@SerializedName("AbilitiesParameters")
	private AbilitiesParameters abilitiesParameters = new AbilitiesParameters();

	// Настройки глобальных событий
	@SerializedName("GameEventsParameters")
	private List<GameEventsParameters> gameEventsParameters = new ArrayList<>();
}
