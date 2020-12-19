package ru.sberbank.itgod.websocket.message.args;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameCancelArgs {
    @SerializedName("PlayerId")
    private String playerId;
    @SerializedName("Reason")
    private String reason;
}
