package ru.sberbank.itgod.websocket.message.serializers;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import ru.sberbank.itgod.enums.CreepBuffIndexes;

import java.lang.reflect.Type;

public class CreepBuffIndexesSerializer implements JsonSerializer<CreepBuffIndexes> {
    @Override
    public JsonElement serialize(CreepBuffIndexes src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.getValue());
    }
}
