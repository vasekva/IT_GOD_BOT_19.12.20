package ru.sberbank.itgod.mechanics;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Wave {
	@SerializedName("CurrentCreepCount")
	private int currentCreepCount;
	@SerializedName("Part")
	private double part;
	@SerializedName("FromId")
	private int fromId;
	@SerializedName("ToId")
	private int toId;
}