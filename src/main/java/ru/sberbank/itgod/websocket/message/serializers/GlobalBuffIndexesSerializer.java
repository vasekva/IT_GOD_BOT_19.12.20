package ru.sberbank.itgod.websocket.message.serializers;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import ru.sberbank.itgod.enums.GlobalBuffIndexes;

import java.lang.reflect.Type;

public class GlobalBuffIndexesSerializer implements JsonSerializer<GlobalBuffIndexes> {
    @Override
    public JsonElement serialize(GlobalBuffIndexes src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.getValue());
    }
}
