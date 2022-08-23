package com.editor.shippingdelivery.main.pickup;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingDeliveryOrdersRequest;
import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingOrderHeaderDataModel;
import com.editor.shippingdelivery.main.pickup.model.DeliveryOrdersRequest;
import com.editor.shippingdelivery.main.pickup.model.DeliveryOrdesrHeaderDataModel;
import com.editor.shippingdelivery.services.DisposableManager;
import com.editor.shippingdelivery.services.RetrofitClient;
import com.editor.shippingdelivery.services.RetrofitInterface;
import com.editor.shippingdelivery.utils.AppUtils;

import org.json.JSONObject;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DeliveryOrdersRepo {

    public MutableLiveData<List<DeliveryOrdesrHeaderDataModel>> deliveryOrdersLiveData;
    public MutableLiveData<Boolean> isProgress;

    public DeliveryOrdersRepo() {
        deliveryOrdersLiveData = new MutableLiveData<>();
        isProgress = new MutableLiveData<>(false);
    }

    public MutableLiveData<Boolean> getprogressLiveData() {
        return isProgress;
    }

    public MutableLiveData<List<DeliveryOrdesrHeaderDataModel>> getDeliveryOrdersLiveData() {
        isProgress.setValue(true);
        RetrofitInterface service = RetrofitClient.getClient();
        DeliveryOrdersRequest deliveryOrdersRequest = new DeliveryOrdersRequest();
        DisposableManager.add(service.getDeliveryOrderList(deliveryOrdersRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseBodyResponse -> {
                    if (responseBodyResponse.isSuccessful()) {
                        if (responseBodyResponse.body() != null) {
                            String resbody = responseBodyResponse.body().string();
                            JSONObject jsonObject = new JSONObject(resbody);
                            String response = AppUtils.getInstance().decompressGZIP(jsonObject.getString("pendingDeliveryOrder"));
                            List<DeliveryOrdesrHeaderDataModel> deliveryOrdesrHeaderDataModelList = AppUtils.getInstance().getConvertedList(response, DeliveryOrdesrHeaderDataModel.class);
                            deliveryOrdersLiveData.setValue(deliveryOrdesrHeaderDataModelList);
                            isProgress.setValue(false);
                        }
                    }
                }, throwable -> {
                    Log.d("TAG", "getShippingOrderList: " + throwable.getMessage());
                }));
        return deliveryOrdersLiveData;
    }


}
