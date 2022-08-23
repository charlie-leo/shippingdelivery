package com.editor.shippingdelivery.main.serviceablity;

import android.util.Log;

import com.editor.shippingdelivery.services.DisposableManager;
import com.editor.shippingdelivery.services.RetrofitClient;
import com.editor.shippingdelivery.services.RetrofitInterface;
import com.google.gson.Gson;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Charles Raj I on 19/08/22.
 *
 * @author Charles Raj I
 */
public class SelectServiceabilityRepo  {

    private static final String TAG = "SelectServiceabilityRepo";
    private final RetrofitInterface service  = RetrofitClient.getClient();


    public void getAvailableServices(SelectServiceabilityViewModel selectServiceabilityViewModel, String orderId){
        try {
            DisposableManager.add(service.getAvailableServices(orderId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(serviceabilityResponse -> {
                        if (serviceabilityResponse != null){
                            selectServiceabilityViewModel.setServiceabilityResponse(serviceabilityResponse);
                            Gson gson = new Gson();
                            String json = gson.toJson(serviceabilityResponse);
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
