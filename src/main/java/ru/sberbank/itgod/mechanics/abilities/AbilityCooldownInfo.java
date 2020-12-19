package ru.sberbank.itgod.mechanics.abilities;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import ru.sberbank.itgod.enums.Abilities;
import ru.sberbank.itgod.enums.PlayerColor;

@Data
public class AbilityCooldownInfo {
    // Цвет владельца заклинания
    @SerializedName("PlayerColor")
    private PlayerColor playerColor;

    // Идентификатор заклинания
    @SerializedName("Ability")
    private Abilities ability;

    // Оставшееся время в тиках до окончания задержки заклинания
    @SerializedName("TicksToCooldownEnd")
    private int ticksToCooldownEnd;
}
