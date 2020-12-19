package ru.sberbank.itgod.websocket.message.args;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.sberbank.itgod.mechanics.actions.GameAction;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameActionsArgs {
    @SerializedName("Action")
    private GameAction action;
}
