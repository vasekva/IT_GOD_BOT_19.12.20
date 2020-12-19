package ru.sberbank.itgod.enums;

import com.google.gson.annotations.SerializedName;

public enum Action {
    @SerializedName("0")
    NONE(0),
    @SerializedName("1")
    MOVE_ACTION(1),
    @SerializedName("2")
    BUFF_ACTION(2),
    @SerializedName("3")
    ERROR_ACTION(3),
    @SerializedName("4")
    TOWER_ACTION(4);

    private final int value;

    Action(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
