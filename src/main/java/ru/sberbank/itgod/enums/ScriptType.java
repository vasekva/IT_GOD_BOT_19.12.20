package ru.sberbank.itgod.enums;

import com.google.gson.annotations.SerializedName;

public enum ScriptType {
    @SerializedName("0")
    CSHARP_FRAMEWORK(0),
    @SerializedName("1")
    LUA_FRAMEWORK(1),
    @SerializedName("2")
    CSHARP(2),
    @SerializedName("3")
    PYTHON(3),
    @SerializedName("4")
    JAVA(4);

    private final int value;

    ScriptType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
