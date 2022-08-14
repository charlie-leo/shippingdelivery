package com.editor.shippingdelivery.common;

/*
 * Created by Charles Raj I on 14/08/2022.
 *  @author Charles Raj I
 */

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private final SharedPreferences sharedPreferences;
    private final SharedPreferences.Editor editor;

    public SessionManager(Context context) {
        sharedPreferences = context.getSharedPreferences("Shipping", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    public  void setString(String key, String value){
        editor.putString(key,value);
        editor.commit();
    }
    public String getString(String key){
        return sharedPreferences.getString(key,"");
    }
    public void setInt(String key, int value){
        editor.putInt(key,value);
        editor.commit();
    }
    public int getInt(String key){
        return sharedPreferences.getInt(key,0);
    }
    public long getLong(String key){
        return sharedPreferences.getLong(key,0);
    }
    public void setLong(String key, long value){
        editor.putLong(key,value);
        editor.commit();
    }
    public void setBoolean(String key, boolean value){
        editor.putBoolean(key,value);
        editor.commit();
    }
    public boolean getBoolean(String key){
        return sharedPreferences.getBoolean(key,false);
    }

}
