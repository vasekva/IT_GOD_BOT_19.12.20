package ru.sberbank.itgod.mechanics.params.buildings;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Класс, описывающий настройки кузницы на карте
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForgesSettings extends BuildingsSettings {
	// Прибавка к множителю защиты для комнады, владеющей кузницей
	@SerializedName("DefenseBonus")
	private double defenseBonus = 0.2;
}
