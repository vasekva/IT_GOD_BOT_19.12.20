package ru.sberbank.itgod.websocket.message.args;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import ru.sberbank.itgod.mechanics.TeamPlayer;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ResponseGamePlayersArgs {
    @SerializedName("Players")
    private TeamPlayer[] players;
}
