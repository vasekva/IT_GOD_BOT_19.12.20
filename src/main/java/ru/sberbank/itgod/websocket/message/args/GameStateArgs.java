package ru.sberbank.itgod.websocket.message.args;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import ru.sberbank.itgod.mechanics.state.GameState;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class GameStateArgs {
    @SerializedName("Tick")
    private int tick;
    @SerializedName("State")
    private GameState state;
}
