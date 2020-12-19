package ru.sberbank.itgod.enums;

import com.google.gson.annotations.SerializedName;

public enum AbilityInputType {
    @SerializedName("0")
    COMMON_ABILITY(0),
    @SerializedName("1")
    AREA_ABILITY(1),
    @SerializedName("2")
    ONE_TOWER_ABILITY(2),
    @SerializedName("3")
    TWO_TOWER_ABILITY(3);

    private final int value;

    AbilityInputType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
