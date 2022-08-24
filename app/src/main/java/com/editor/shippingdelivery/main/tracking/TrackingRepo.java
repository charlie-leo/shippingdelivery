package com.editor.shippingdelivery.main.tracking;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingDeliveryOrdersRequest;
import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingOrderHeaderDataModel;
import com.editor.shippingdelivery.services.DisposableManager;
import com.editor.shippingdelivery.services.RetrofitClient;
import com.editor.shippingdelivery.services.RetrofitInterface;
import com.editor.shippingdelivery.utils.AppUtils;

import org.json.JSONObject;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TrackingRepo {

    private static final String TAG = "trackingRepo";

    public void getTrackingDetailList(TrackingViewModel trackingViewModel){
        RetrofitInterface service = RetrofitClient.getClient();
        PendingDeliveryOrdersRequest pendingDeliveryOrdersRequest = new PendingDeliveryOrdersRequest();
        try {
            DisposableManager.add(service.getTrackingOrderList(pendingDeliveryOrdersRequest)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(responseBodyResponse -> {
                        if (responseBodyResponse.isSuccessful()) {
                            if (responseBodyResponse.body() != null) {
                                String resbody = responseBodyResponse.body().string();
                                JSONObject jsonObject = new JSONObject(resbody);
                                String response = AppUtils.getInstance().decompressGZIP(jsonObject.getString("pendingDeliveryOrder"));
                                List<PendingOrderHeaderDataModel> pendingOrderHeaderDataModelList = AppUtils.getInstance().getConvertedList(response, PendingOrderHeaderDataModel.class);
                                trackingViewModel.setTrackingListData(pendingOrderHeaderDataModelList);
                            }
                        }
                    }, throwable -> {
                        Log.d("TAG", "getShippingOrderList: " + throwable.getMessage());
                    }));
        }catch (Exception e){
            Log.d(TAG, "getTrackingDetailList: " + e.getMessage());
        }
    }
}
