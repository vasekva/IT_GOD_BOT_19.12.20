package ru.sberbank.itgod.enums;

import com.google.gson.annotations.SerializedName;

public enum PlayerColor {
    @SerializedName(value = "0", alternate = {"White"})
    WHITE(0),
    @SerializedName(value = "1", alternate = {"Red"})
    RED(1),
    @SerializedName(value = "2", alternate = {"Blue"})
    BLUE(2),
    @SerializedName(value = "3", alternate = {"Green"})
    GREEN(3),
    @SerializedName(value = "4", alternate = {"Yellow"})
    YELLOW(4);

    private final int value;

    PlayerColor(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
