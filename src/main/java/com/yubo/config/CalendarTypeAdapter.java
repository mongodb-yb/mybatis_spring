package com.yubo.config;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.Calendar;

/**
 * Created by jacobdong on 16/1/12.
 */
public class CalendarTypeAdapter implements JsonSerializer<Calendar>, JsonDeserializer<Calendar> {

    @Override
    public Calendar deserialize(JsonElement json, Type arg1,
                                JsonDeserializationContext arg2) throws JsonParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(json.getAsJsonPrimitive().getAsLong());
        return calendar;
    }

    @Override
    public JsonElement serialize(Calendar calendar, Type arg1,
                                 JsonSerializationContext arg2) {
        return new JsonPrimitive(Long.valueOf(calendar.getTimeInMillis()));
    }


}
