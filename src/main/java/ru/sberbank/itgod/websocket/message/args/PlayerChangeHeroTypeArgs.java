package ru.sberbank.itgod.websocket.message.args;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import ru.sberbank.itgod.enums.HeroType;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PlayerChangeHeroTypeArgs {
    @SerializedName("PlayerId")
    private String playerId;
    @SerializedName("HeroType")
    private HeroType heroType;
}
