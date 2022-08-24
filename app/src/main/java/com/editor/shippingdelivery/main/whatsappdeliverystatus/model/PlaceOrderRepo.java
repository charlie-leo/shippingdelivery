package com.editor.shippingdelivery.main.whatsappdeliverystatus.model;

import android.util.Log;

import com.editor.shippingdelivery.services.DisposableManager;
import com.editor.shippingdelivery.services.RetrofitClient;
import com.editor.shippingdelivery.services.RetrofitInterface;
import com.google.gson.Gson;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
/**
 * Created by A.Balachandar on 22/08/22.
 *
 * @author A.Balachandar
 */
public class PlaceOrderRepo {

    private static final String TAG = "PlaceOrderRepo";
    private final RetrofitInterface  service = RetrofitClient.getClient();


    public void placeOrderSendWhatsApp(PlaceOrderModel placeOrderModel){
        try {
            DisposableManager.add(service.placeOrderViaWaMessaging(placeOrderModel)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(placeOrderResponse -> {
                        if (placeOrderResponse != null){
                            placeOrderModel.setPlaceOrderResponse(placeOrderResponse);
                            Gson gson = new Gson();
                            String json = gson.toJson(placeOrderResponse);
                            Log.d(TAG, "getAvailableServices: " + json);
                        }
                    }, throwable -> {
                        Log.d(TAG, "getAvailableServices: " + throwable.getMessage());
                    }));
        }catch (Exception e){
            Log.d(TAG, "getAvailableServices: ");
        }
    }

}
