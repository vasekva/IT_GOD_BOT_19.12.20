package ru.sberbank.itgod.websocket.message.serializers;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import ru.sberbank.itgod.enums.HeroType;

import java.lang.reflect.Type;

public class HeroTypeSerializer implements JsonSerializer<HeroType> {
    @Override
    public JsonElement serialize(HeroType src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.getValue());
    }
}
