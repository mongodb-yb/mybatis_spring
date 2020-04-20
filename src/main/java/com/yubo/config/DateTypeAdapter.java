package com.yubo.config;


import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * @author txsk
 * @date 2017/11/10
 */
public class DateTypeAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonElement json, Type arg1,
                            JsonDeserializationContext arg2) throws JsonParseException {
        return new Date(json.getAsJsonPrimitive().getAsLong());
    }

    @Override
    public JsonElement serialize(Date date, Type arg1,
                                 JsonSerializationContext arg2) {
        return new JsonPrimitive(date.getTime());
    }
}
