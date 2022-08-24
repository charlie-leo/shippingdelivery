package com.editor.shippingdelivery.main.tracking;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.editor.shippingdelivery.main.pickup.model.DeliveryOrdersRequest;
import com.editor.shippingdelivery.main.pickup.model.DeliveryOrdesrHeaderDataModel;
import com.editor.shippingdelivery.main.tracking.model.TrackingDeliveryOrdersRequest;
import com.editor.shippingdelivery.main.tracking.model.TrackingDeliveryOrdesrHeaderDataModel;
import com.editor.shippingdelivery.services.DisposableManager;
import com.editor.shippingdelivery.services.RetrofitClient;
import com.editor.shippingdelivery.services.RetrofitInterface;
import com.editor.shippingdelivery.utils.AppUtils;

import org.json.JSONObject;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TrackingDeliveryOrdersRepo {

    public MutableLiveData<List<TrackingDeliveryOrdesrHeaderDataModel>> deliveryOrdersLiveData;
    public MutableLiveData<Boolean> isProgress;

    public TrackingDeliveryOrdersRepo() {
        deliveryOrdersLiveData = new MutableLiveData<>();
        isProgress = new MutableLiveData<>(false);
    }

    public MutableLiveData<Boolean> getprogressLiveData() {
        return isProgress;
    }

    public MutableLiveData<List<TrackingDeliveryOrdesrHeaderDataModel>> getDeliveryOrdersLiveData() {
        isProgress.setValue(true);
        RetrofitInterface service = RetrofitClient.getClient();
        TrackingDeliveryOrdersRequest deliveryOrdersRequest = new TrackingDeliveryOrdersRequest();
        DisposableManager.add(service.getDeliveryOrderList(deliveryOrdersRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseBodyResponse -> {
                    if (responseBodyResponse.isSuccessful()) {
                        if (responseBodyResponse.body() != null) {
                            String resbody = responseBodyResponse.body().string();
                            JSONObject jsonObject = new JSONObject(resbody);
                            String response = AppUtils.getInstance().decompressGZIP(jsonObject.getString("pendingDeliveryOrder"));
                            List<TrackingDeliveryOrdesrHeaderDataModel> deliveryOrdesrHeaderDataModelList = AppUtils.getInstance().getConvertedList(response, TrackingDeliveryOrdesrHeaderDataModel.class);
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
