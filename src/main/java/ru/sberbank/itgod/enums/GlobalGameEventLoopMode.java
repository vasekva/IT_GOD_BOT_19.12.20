package ru.sberbank.itgod.enums;

import com.google.gson.annotations.SerializedName;

public enum GlobalGameEventLoopMode {
    @SerializedName("0")
    NONE(0),
    @SerializedName("1")
    LOOP(1);

    private final int value;

    GlobalGameEventLoopMode(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
