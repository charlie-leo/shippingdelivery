package com.editor.shippingdelivery.main.pendingdeliveryorders;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingDeliveryOrdersRequest;
import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingOrderHeaderDataModel;
import com.editor.shippingdelivery.services.DisposableManager;
import com.editor.shippingdelivery.services.RetrofitClient;
import com.editor.shippingdelivery.services.RetrofitInterface;
import com.editor.shippingdelivery.utils.AppUtils;
import com.editor.shippingdelivery.utils.ListOf;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.GZIPInputStream;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PendingDeliveryOrderRepo {

    public MutableLiveData<List<PendingOrderHeaderDataModel>> pendingOrderLiveDate;

    public PendingDeliveryOrderRepo() {
        pendingOrderLiveDate=new MutableLiveData<>();
    }

    public MutableLiveData<List<PendingOrderHeaderDataModel>> getPendingOrderLiveDate() {
        return pendingOrderLiveDate;
    }

    public void getShippingOrderList() {
        RetrofitInterface service = RetrofitClient.getClient();
        PendingDeliveryOrdersRequest pendingDeliveryOrdersRequest = new PendingDeliveryOrdersRequest();
        DisposableManager.add(service.getShippingOrderList(pendingDeliveryOrdersRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseBodyResponse -> {
                    if (responseBodyResponse.isSuccessful()) {
                        if (responseBodyResponse.body() != null) {
                            String resbody = responseBodyResponse.body().string();
                            JSONObject jsonObject=new JSONObject(resbody);
                            String response = AppUtils.getInstance().decompressGZIP(jsonObject.getString("pendingDeliveryOrder"));
                            List<PendingOrderHeaderDataModel> pendingOrderHeaderDataModelList = AppUtils.getInstance().getConvertedList(response, PendingOrderHeaderDataModel.class);
                            pendingOrderLiveDate.setValue(pendingOrderHeaderDataModelList);
                        }
                    }
                }, throwable -> {
                    Log.d("TAG", "getShippingOrderList: " + throwable.getMessage());
                }));
    }


}
