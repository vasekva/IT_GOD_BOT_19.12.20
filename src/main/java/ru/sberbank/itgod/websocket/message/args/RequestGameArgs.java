package ru.sberbank.itgod.websocket.message.args;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RequestGameArgs {
    @SerializedName("UserId")
    private String userId;
    @SerializedName("BotId")
    private String botId;
    @SerializedName("GameId")
    private String gameId;
}
