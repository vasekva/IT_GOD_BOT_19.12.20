package ru.sberbank.itgod.mechanics;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Класс, описывающий параметры карты, которые используются на уровне клиента Unity
 */
@Data
public class MapUnity implements Serializable {
	// Соответствие ID строения к позиции объекта в Unity
	@SerializedName("Positions")
	private HashMap<Integer, Vector3> positions;
}
