package ru.sberbank.itgod.mechanics.state;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class SquadState extends UnitState {

	public class Way {
		// Часть пути, которое прошли крипы в текущий момент в абсолютных значениях
		@SerializedName("Traveled")
		private Double traveled;

		// Длина пути данного отряда крипов в абсолютных значениях
		@SerializedName("Total")
		private Double total;

		public Double getTraveled() {
			return traveled;
		}

		public Double getTotal() {
			return total;
		}
	}

	// Информация о пути отряда в абсолютных значениях
	@SerializedName("Way")
	private Way way;

	// ID строения, из которого были посланы крипы
	@SerializedName("FromId")
	private Integer fromId;

	// ID строения, в которое были посланы крипы
	@SerializedName("ToId")
	private Integer toId;

	// Начальное количество крипов в юните
	@SerializedName("StartCreepsCount")
	private Integer startCreepsCount;

	// Маска расположения текущих крипов внутри юнита
	@SerializedName("PlaceMask")
	private Integer placeMask;

	// Маска бафов/дебафов каждого крипа
	// Энный байт содержит данные об энном крипе
	// Энный бит в байте содержит данные об энном бафе/дебафе крипа
	// Сопоставление бафов/дебафов и порядкового номера крипа лежит в перечислении CreepBuffIndexes
	@SerializedName("BuffMask")
	private Long BuffMask;

	// Расстояние, которое проходит данный отряд крипов за 1 тик
	@SerializedName("Speed")
	private Double speed;

	public Double getTraveled() {
		return (Math.abs(way.total) > Math.ulp(1d)) ? way.traveled / way.total : 0;
	}

	public SquadState(final Way way) {
		this.way = way;
	}

	public SquadState(final int id) {
		super(id);
	}

}
