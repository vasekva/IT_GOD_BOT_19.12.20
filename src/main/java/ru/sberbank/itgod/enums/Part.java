package ru.sberbank.itgod.enums;

import com.google.gson.annotations.SerializedName;

public enum Part {

    @SerializedName("25")
    TWENTY_FIFTH(25),
    @SerializedName("50")
    FIFTHIETH(50),
    @SerializedName("75")
    SEVENTY_FIFTH(75),
    @SerializedName("100")
    All(100);

    private static final Part[] ALL_VALUES = values();
    private int code;

    Part(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static Part getByCode(final int code) {
        for (final Part part : ALL_VALUES) {
            if (part.code == code)
                return part;
        }
        return null;
    }
}
