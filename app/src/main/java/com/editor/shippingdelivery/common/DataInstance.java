package com.editor.shippingdelivery.common;

import java.util.HashMap;

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
}
