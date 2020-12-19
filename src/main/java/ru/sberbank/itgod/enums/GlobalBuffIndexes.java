package ru.sberbank.itgod.enums;

import com.google.gson.annotations.SerializedName;

public enum GlobalBuffIndexes {
    @SerializedName("0")
    SPEED_UP_BUFF(0),
    @SerializedName("1")
    AREA_DAMAGE_BUFF(1),
    @SerializedName("2")
    TREMORS_DEBUFF(2),
    @SerializedName("3")
    FAIR_WIND_BUFF(3);

    private final int value;

    GlobalBuffIndexes(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
