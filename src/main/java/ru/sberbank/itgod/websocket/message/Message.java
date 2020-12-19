package ru.sberbank.itgod.websocket.message;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.sberbank.itgod.enums.MsgType;
import ru.sberbank.itgod.websocket.message.args.*;
import ru.sberbank.itgod.websocket.message.model.EndPoint;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private Message(MsgType type) {
        msgType = type;
    }

    @SerializedName("MsgType")
    private MsgType msgType;
    @SerializedName("GameId")
    private String gameId;

    @SerializedName("Subscribers")
    private EndPoint[] subscribers;
    @SerializedName("Sender")
    private EndPoint sender;

    @SerializedName("KeyArgs")
    private KeyArgs keyArgs;
    @SerializedName("ResponseGameParametersArgs")
    private ResponseGameParametersArgs responseGameParametersArgs;
    @SerializedName("ResponseGamePlayersArgs")
    private ResponseGamePlayersArgs responseGamePlayersArgs;

    @SerializedName("RequestGameParametersArgs")
    private RequestGameArgs requestGameParametersArgs;
    @SerializedName("GameOverArgs")
    private GameOverArgs gameOverArgs;
    @SerializedName("GamePauseArgs")
    private GamePauseArgs gamePauseArgs;
    @SerializedName("GameActionsArgs")
    private GameActionsArgs gameActionsArgs;
    @SerializedName("GameStateArgs")
    private GameStateArgs gameStateArgs;
    @SerializedName("PlayerDisconnectArgs")
    private PlayerArgs playerDisconnectArgs;
    @SerializedName("PlayerConnectArgs")
    private PlayerConnectArgs playerConnectArgs;
    @SerializedName("GameCancelArgs")
    private GameCancelArgs gameCancelArgs;
    @SerializedName("PlayerPreparedArgs")
    private PlayerArgs playerPreparedArgs;
    @SerializedName("PlayerInitializedArgs")
    private PlayerArgs playerInitializedArgs;
    @SerializedName("PlayerReadyArgs")
    private PlayerArgs playerReadyArgs;
    @SerializedName("AllPlayersConnectedArgs")
    private AllPlayersConnectedArgs allPlayersConnectedArgs;
    @SerializedName("PlayerChangeHeroTypeArgs")
    private PlayerChangeHeroTypeArgs playerChangeHeroTypeArgs;
    @SerializedName("PlayerChangeColorArgs")
    private PlayerChangeColorArgs playerChangeColorArgs;
}
