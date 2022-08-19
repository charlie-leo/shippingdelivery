package com.editor.shippingdelivery.main.serviceablity;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.editor.shippingdelivery.services.DisposableManager;
import com.editor.shippingdelivery.services.RetrofitClient;
import com.editor.shippingdelivery.services.RetrofitInterface;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by Charles Raj I on 19/08/22.
 *
 * @author Charles Raj I
 */
public class SelectServiceabilityRepo  {

    private static final String TAG = "SelectServiceabilityRepo";
    private RetrofitInterface service = service = RetrofitClient.getClient();


    public void getAvailableServices(SelectServiceabilityViewModel selectServiceabilityViewModel, String orderId){
        try {
            DisposableManager.add(service.getAvailableServices(orderId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(serviceabilityResponse -> {
                        if (serviceabilityResponse.getStatus() == 200){
                            selectServiceabilityViewModel.setServiceabilityResponse(serviceabilityResponse);
                        }
                    }, throwable -> {

                    }));
        }catch (Exception e){
            Log.d(TAG, "getAvailableServices: ");
        }
    }

}
