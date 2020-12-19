package ru.sberbank.itgod.enums;

import com.google.gson.annotations.SerializedName;

public enum HeroType {
    @SerializedName("0")
    NONE(0),
    @SerializedName("1")
    WARRIOR(1),
    @SerializedName("2")
    BLACKSMITH(2),
    @SerializedName("3")
    MAGE(3);

    private final int value;

    HeroType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
