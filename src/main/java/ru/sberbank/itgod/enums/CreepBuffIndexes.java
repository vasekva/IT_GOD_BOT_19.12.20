package ru.sberbank.itgod.enums;

import com.google.gson.annotations.SerializedName;

public enum CreepBuffIndexes {
    @SerializedName("0")
    BERSERK_BUFF(0),
    @SerializedName("1")
    PLAGUE_DEBUFF(1),
    @SerializedName("2")
    TREMORS_KILL(2);

    private final int value;

    CreepBuffIndexes(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
