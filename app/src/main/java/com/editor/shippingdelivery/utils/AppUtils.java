package com.editor.shippingdelivery.utils;

import android.util.Base64;

import androidx.annotation.Nullable;

import com.google.gson.Gson;

import org.json.JSONArray;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

public class AppUtils {
    private static AppUtils appUtilsInstance;

    public static AppUtils getInstance() {
        if (appUtilsInstance == null) {
            appUtilsInstance = new AppUtils();
        }
        return appUtilsInstance;
    }

    /**
     * Method to decompress Data
     *
     * @param input Gzip compressed input string
     * @return decompressed Gzip output string
     */
    public String decompressGZIP(String input) {
        StringBuilder string = new StringBuilder();
        try {
            final int BUFFER_SIZE = 32;
            ByteArrayInputStream is = new ByteArrayInputStream(decodeBase64(input));
            GZIPInputStream gis = new GZIPInputStream(is);

            byte[] data = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = gis.read(data)) != -1) {
                string.append(new String(data, 0, bytesRead));
            }
            gis.close();
            is.close();
        } catch (Exception e) {
            return "";
        }
        return string.toString();
    }

    /**
     * @param input Gzip compressed input string
     * @return GZIP byte[]
     */
    private byte[] decodeBase64(String input) {
        return Base64.decode(input, Base64.NO_WRAP);
    }

    public static <T> ArrayList<T> getConvertedList(String responseString, Class<T> type) {
        JSONArray jsonArray;
        ArrayList<T> list = new ArrayList<>();
        try {
            jsonArray = new JSONArray(responseString);
            list = AppUtils.getInstance().getConvertedListFromJson(jsonArray, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * used to convert Json To Model Class by using GSON & Genrics
     *
     * @param <T>       Gloabal Model Declaration
     * @param jsonArray json array for conversion
     * @param type      selected Model Class to Covert Json
     * @return list of custom Object
     */
    @Nullable
    public <T> ArrayList<T> getConvertedListFromJson(JSONArray jsonArray, Class<T> type) {
        ArrayList<T> list = new ArrayList<>();
        try {
            Gson gson = new Gson();
            return gson.fromJson(jsonArray.toString(), new ListOf<>(type));
        } catch (OutOfMemoryError e) {
            return list;
        }

    }
}

