package ru.sberbank.itgod.websocket.message.args;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class GameOverArgs {
    @SerializedName("WinnerTeamId")
    private String winnerTeamId;
}
