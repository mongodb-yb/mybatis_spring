package com.yubo.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.FactoryBean;

import java.util.Calendar;
import java.util.Date;

/**
 * @author yubo
 * @version V1.0
 * @description 对json进行扩展
 * @date 2020/4/9 15:06
 */
public class GsonFactoryBean implements FactoryBean<Gson> {

    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public Gson getObject() throws Exception {

        return new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateTypeAdapter())
                .registerTypeHierarchyAdapter(Calendar.class, new CalendarTypeAdapter())
                .create();
    }

    @Override
    public Class<?> getObjectType() {
        return Gson.class;
    }
}
