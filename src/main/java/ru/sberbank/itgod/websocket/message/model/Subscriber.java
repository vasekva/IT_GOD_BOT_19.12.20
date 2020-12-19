package ru.sberbank.itgod.websocket.message.model;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Subscriber {
    @SerializedName("PlayerId")
    private String playerId;
    @SerializedName("EndPoint")
    private EndPoint endPoint;
}
