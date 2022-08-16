package com.editor.shippingdelivery.main.pendingdeliveryorders;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingOrderHeaderDataModel;
import com.editor.shippingdelivery.services.DisposableManager;
import com.editor.shippingdelivery.services.RetrofitClient;
import com.editor.shippingdelivery.services.RetrofitInterface;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PendingDeliveryOrderRepo {

    public MutableLiveData<List<PendingOrderHeaderDataModel>> pendingOrderLiveDate = new MutableLiveData<>();

    public MutableLiveData<List<PendingOrderHeaderDataModel>> getPendingOrderLiveDate() {
        return pendingOrderLiveDate;
    }

    public void getShippingOrderList(){

        RetrofitInterface service = RetrofitClient.getClient();

        DisposableManager.add(service.getShippingOrderList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listResponse -> {
                    if (listResponse.isSuccessful()){
                        pendingOrderLiveDate.setValue(listResponse.body());
                    }
                }, throwable -> {
                    Log.d("TAG", "getShippingOrderList: " + throwable.getMessage());
                }));
    }
}
