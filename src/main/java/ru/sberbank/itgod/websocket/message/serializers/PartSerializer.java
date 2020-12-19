package ru.sberbank.itgod.websocket.message.serializers;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import ru.sberbank.itgod.enums.Part;

import java.lang.reflect.Type;

public class PartSerializer implements JsonSerializer<Part> {
    @Override
    public JsonElement serialize(Part src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.getCode());
    }
}
