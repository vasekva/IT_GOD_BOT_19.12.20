package ru.sberbank.itgod.mechanics.state;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import ru.sberbank.itgod.enums.PlayerColor;

@Data
public class UnitState {

	private static int staticId = 1;

	@SerializedName("Id")
	private final int id;
	@SerializedName("PlayerColor")
	private PlayerColor playerColor;
	@SerializedName("CreepsCount")
	private int creepsCount;

	public UnitState(final int id) {
		this.id = id;
	}

	public UnitState() {
		id = staticId++;
	}
}
