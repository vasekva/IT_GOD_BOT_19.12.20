package ru.sberbank.itgod.websocket.message.serializers;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import ru.sberbank.itgod.enums.ErrorCode;

import java.lang.reflect.Type;

public class ErrorCodeSerializer implements JsonSerializer<ErrorCode> {
    @Override
    public JsonElement serialize(ErrorCode src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.getCode());
    }
}
