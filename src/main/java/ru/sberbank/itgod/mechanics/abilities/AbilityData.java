package ru.sberbank.itgod.mechanics.abilities;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
public class AbilityData {
    @SerializedName("SpeedModifier")
    private Double speedModifier;
    @SerializedName("AttackModifier")
    private Double attackModifier;
    @SerializedName("UnitRunPercent")
    private Double unitRunPercent;
    @SerializedName("UnitRunPercentWithShield")
    private Double unitRunPercentWithShield;
    @SerializedName("UnitKillPercentWithShield")
    private Double unitKillPercentWithShield;
    @SerializedName("MinimumDamage")
    private Integer minimumDamage;
    @SerializedName("MaximumDamage")
    private Integer maximumDamage;
    @SerializedName("DamagePerTick")
    private Double damagePerTick;
    @SerializedName("DamagePerTickWithShield")
    private Double damagePerTickWithShield;
    @SerializedName("TickDelay")
    private Integer tickDelay;
    @SerializedName("DefenceBonus")
    private Double defenceBonus;
    @SerializedName("TowersDeadZoneRadius")
    private Double towersDeadZoneRadius;
    @SerializedName("SpeedBuffPercent")
    private Double speedBuffPercent;
    @SerializedName("UnitKillPercent")
    private Double unitKillPercent;
}
