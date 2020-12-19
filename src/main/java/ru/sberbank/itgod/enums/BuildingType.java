package ru.sberbank.itgod.enums;

import com.google.gson.annotations.SerializedName;

public enum BuildingType {
    @SerializedName("0")
    NONE(0),
    @SerializedName("1")
    TOWER(1),
    @SerializedName("2")
    FORGE(2);

    private final int value;

    BuildingType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
