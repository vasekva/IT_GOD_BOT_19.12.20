package ru.sberbank.itgod.websocket.message.args;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import ru.sberbank.itgod.enums.HeroType;
import ru.sberbank.itgod.mechanics.TeamPlayer;
import ru.sberbank.itgod.websocket.message.model.EndPoint;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseGameParametersArgs {
    @SerializedName("Map")
    private String map;
    @SerializedName("Parameters")
    private String parameters;
    @SerializedName("GameServer")
    private EndPoint gameServer;
    @SerializedName("HeroType")
    private HeroType heroType;
    @SerializedName("TeamPlayers")
    private TeamPlayer[] teamPlayers;
}
