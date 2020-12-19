package ru.sberbank.itgod.websocket.message.args;


import com.google.gson.annotations.SerializedName;
import lombok.*;
import ru.sberbank.itgod.mechanics.Team;
import ru.sberbank.itgod.websocket.message.model.EndPoint;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllPlayersConnectedArgs {
    @SerializedName("Subscribers")
    private EndPoint[] subscribers;
    @SerializedName("Teams")
    public Team[] teams;
}
