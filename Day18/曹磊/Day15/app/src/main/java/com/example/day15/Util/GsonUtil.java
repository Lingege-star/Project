package com.example.day15.Util;

import com.google.gson.Gson;

public class GsonUtil {
    private static Gson mGson=null;
    static {
        mGson = new Gson();
    }

    public static<T> T str2Beas(String jsonStr,Class<T> clazz){
       return mGson.fromJson(jsonStr,clazz);
    }


}
