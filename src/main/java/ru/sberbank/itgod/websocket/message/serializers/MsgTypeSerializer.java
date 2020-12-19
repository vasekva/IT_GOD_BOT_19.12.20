package ru.sberbank.itgod.websocket.message.serializers;

import com.google.gson.*;
import ru.sberbank.itgod.enums.MsgType;

import java.lang.reflect.Type;

public class MsgTypeSerializer implements JsonSerializer<MsgType> {

    @Override
    public JsonElement serialize(MsgType src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.getValue());
    }
}
