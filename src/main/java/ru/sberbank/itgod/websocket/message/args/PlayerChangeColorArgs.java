package ru.sberbank.itgod.websocket.message.args;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import ru.sberbank.itgod.enums.PlayerColor;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PlayerChangeColorArgs {
    @SerializedName("PlayerId")
    private String playerId;
    @SerializedName("PlayerColor")
    private PlayerColor playerColor;
}
