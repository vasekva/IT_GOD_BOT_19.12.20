package ru.sberbank.itgod.mechanics.params.buildings;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Класс, описывающий настройки башни на карте
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TowersSettings extends BuildingsSettings {
	// Стоимость перехода на данный уровень башни в крипах
	@SerializedName("UpdateCoast")
	private int updateCoast = 0;

	// Дополнительная защита башни на данном уровне
	@SerializedName("DefenseBonus")
	private double defenseBonus = 0.0;

	// Задержка создания 1 крипа в башне данного уровня в тиках
	@SerializedName("CreepCreationTime")
	private int creepCreationTime = 0;
}
