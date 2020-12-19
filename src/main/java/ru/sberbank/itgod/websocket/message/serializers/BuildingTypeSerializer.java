package ru.sberbank.itgod.websocket.message.serializers;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import ru.sberbank.itgod.enums.BuildingType;

import java.lang.reflect.Type;

public class BuildingTypeSerializer implements JsonSerializer<BuildingType> {
    @Override
    public JsonElement serialize(BuildingType src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.getValue());
    }
}
