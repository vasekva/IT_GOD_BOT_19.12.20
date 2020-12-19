package ru.sberbank.itgod.enums;

import com.google.gson.annotations.SerializedName;

public enum Abilities {

    @SerializedName("0")
    SPEED_UP(0), // Ускорение
    @SerializedName("1")
    VISION(1), // Видеть количество войск в башнях
    @SerializedName("2")
    BERSERK(2), // Усиление войск
    @SerializedName("3")
    GROWL(3), // Распугать войска в башне соперника
    @SerializedName("4")
    AREA_DAMAGE(4), // Урон по площади
    @SerializedName("5")
    PLAGUE(5), // Чума. Уменьшает количество войск в башне противника
    @SerializedName("6")
    BUILD_EXCHANGE(6), // Обмен башен
    @SerializedName("7")
    ARMOR(7), // Защита башни
    @SerializedName("8")
    TREMORS(8), // Дрожь земли. Червь
    @SerializedName("9")
    FAIR_WIND(9); // Ветер перемен. Ускорение всех войск

    private final int value;

    Abilities(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}