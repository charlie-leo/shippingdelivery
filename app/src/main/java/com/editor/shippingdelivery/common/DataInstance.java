package com.editor.shippingdelivery.common;

import android.util.Log;

import okio.Buffer;
import java.util.HashMap;

import okhttp3.ResponseBody;

/**
 * Created by Charles Raj I on 14/08/22.
 *
 * @author Charles Raj I
 */
public interface DataInstance {

    HashMap<String, String > applicationData = new HashMap<>();

    default void setApplicationData(String key, String value){
        applicationData.put(key, value);
    }
    default String getApplicationData(String key){
        if (applicationData.containsKey(key)){
            return applicationData.get(key);
        }
        return "";
    }

//    default String responseBodyToString(ResponseBody responseBody){
//        String responseString = "";
//        try{
//            Buffer buffer = new Buffer();
//            responseBody.
//        }catch (Exception e){
//            Log.d("TAG", "responseBodyToString: " + e.toString());
//        }
//        return responseString;
//    }
}
