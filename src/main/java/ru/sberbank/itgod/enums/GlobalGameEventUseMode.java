package ru.sberbank.itgod.enums;

import com.google.gson.annotations.SerializedName;

public enum GlobalGameEventUseMode {
    @SerializedName("0")
    PLAYER_DIRECTLY(0),
    @SerializedName("1")
    ALL_PLAYERS(1);

    private final int value;

    GlobalGameEventUseMode(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
