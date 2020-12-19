package ru.sberbank.itgod.mechanics.params.buildings;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Базовый класс для всех строений на карте
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BuildingsSettings implements Serializable {
	// Количество крипов в строении в начале битвы, если оно принадлежит команде игрока
	@SerializedName("DefaultPlayerCount")
	private int defaultPlayerCount = 10;

	// Количество крипов в строении в начале битвы, если оно принадлежит нейтральной команде
	@SerializedName("DefaultNeutralCount")
	private int defaultNeutralCount = 5;

	// Максимальное количество крипов в строении, если оно принадлежит команде игрока
	@SerializedName("PlayerMaxCount")
	private int playerMaxCount = 20;

	// Максимальное количество крипов в строении, если оно принадлежит нейтральной команде
	@SerializedName("NeutralMaxCount")
	private int neutralMaxCount = 20;
}
