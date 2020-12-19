package ru.sberbank.itgod.mechanics.params;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Класс, описывающий настройки крипов
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreepsSettings implements Serializable {
	// Скорость перемещения крипов
	@SerializedName("Speed")
	private double speed = 0.2;

	// Время между волнами крипов в тиках
	@SerializedName("WaveDelay")
	private int waveDelay = 2;

	// Максимальное кол-во крипов в 1 волне
	@SerializedName("MaxWaveCreepsCount")
	private int maxWaveCreepsCount = 4;

	/// Расстояние между крипами в 1 волне
	@SerializedName("CreepInWaveDistance")
	private double creepInWaveDistance = 0.2;
}
