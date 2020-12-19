package ru.sberbank.itgod.websocket.message.serializers;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import ru.sberbank.itgod.enums.AbilityInputType;

import java.lang.reflect.Type;

public class AbilityInputTypeSerializer implements JsonSerializer<AbilityInputType> {
    @Override
    public JsonElement serialize(AbilityInputType src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.getValue());
    }
}
