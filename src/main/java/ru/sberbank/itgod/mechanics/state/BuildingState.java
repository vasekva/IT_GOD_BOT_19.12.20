package ru.sberbank.itgod.mechanics.state;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import ru.sberbank.itgod.enums.BuildingType;

@Data
public class BuildingState extends UnitState {
	@SerializedName("Type")
	private BuildingType buildingType;
	/**
	 * Текущий уровень строения
	 */
	@SerializedName("Level")
	private int level;

	/**
	 * Время создания крипов в данном строении
	 */
	@SerializedName("CreepCreationTime")
	private int creepCreationTime;

	/**
	 * Добавочный показатель защиты данного строения
	 */
	@SerializedName("DefenseBonus")
	private double defenseBonus;

	/**
	 * Маска, показывающая действие эффектов на данное строение
	 */
	@SerializedName("BuffMask")
	private int buffMask;

	public BuildingState(final int id) {
		super(id);
	}
}
