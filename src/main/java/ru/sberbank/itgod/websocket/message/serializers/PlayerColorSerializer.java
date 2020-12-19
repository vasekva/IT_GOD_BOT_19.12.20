package ru.sberbank.itgod.websocket.message.serializers;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import ru.sberbank.itgod.enums.PlayerColor;

import java.lang.reflect.Type;

public class PlayerColorSerializer implements JsonSerializer<PlayerColor> {
    @Override
    public JsonElement serialize(PlayerColor src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.getValue());
    }
}
