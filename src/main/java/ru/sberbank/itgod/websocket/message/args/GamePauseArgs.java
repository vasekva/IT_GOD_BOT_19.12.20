package ru.sberbank.itgod.websocket.message.args;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class GamePauseArgs {
    @SerializedName("PlayerId")
    private String playerId;
    @SerializedName("Pause")
    private boolean pause;
}
