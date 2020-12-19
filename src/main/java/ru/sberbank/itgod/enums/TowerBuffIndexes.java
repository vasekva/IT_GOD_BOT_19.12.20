package ru.sberbank.itgod.enums;

import com.google.gson.annotations.SerializedName;

public enum TowerBuffIndexes {
    @SerializedName("0")
    ARMOR_BUFF(0),
    @SerializedName("1")
    GROWL_DEBUFF(1),
    @SerializedName("2")
    PLAGUE_DEBUFF(2),
    @SerializedName("3")
    EXCHANGE(3),
    @SerializedName("4")
    INVISION(4);

    private final int value;

    TowerBuffIndexes(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
