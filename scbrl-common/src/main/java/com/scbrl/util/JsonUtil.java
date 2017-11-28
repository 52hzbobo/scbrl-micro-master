package com.scbrl.util;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Bruce.Liu
 * 2017-07-04 01:30
 */
public class JsonUtil {
    static Gson gson = new Gson();

    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder().serializeNulls();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }

    public static List<LinkedHashMap> toLinkedMapList(String json){
        List<LinkedHashMap> linkedMapLs = gson.fromJson(json, new TypeToken<List<LinkedHashMap>>() {
        }.getType());
        return linkedMapLs ;
    }

}
