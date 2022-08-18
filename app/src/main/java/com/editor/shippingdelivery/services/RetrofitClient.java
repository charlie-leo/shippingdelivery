package com.editor.shippingdelivery.services;

/*
 * Created by Charles Raj I on 14/08/2022.
 *  @author Charles Raj I
 */

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    /* Add you base URL here !! */
//    public static String BASE_URL="https://apiv2.shiprocket.in/v1/external/";
    public static String BASE_URL="https://botreeuat.csngsfa.com/api/v1/";

    /*Initialize the retrofit*/
    public static RetrofitInterface getClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.readTimeout(60, TimeUnit.SECONDS);
        httpClient.connectTimeout(60, TimeUnit.SECONDS);
        httpClient.writeTimeout(60, TimeUnit.SECONDS);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient.build())
                .build();
        return retrofit.create(RetrofitInterface.class);
    }
}
