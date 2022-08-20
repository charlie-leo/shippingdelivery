package com.editor.shippingdelivery.main.whatsappdeliverystatus;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.editor.shippingdelivery.main.whatsappdeliverystatus.model.WhatsappDeliveryStatusRequest;
import com.editor.shippingdelivery.main.whatsappdeliverystatus.model.WhatsappStatusHeaderDataModel;
import com.editor.shippingdelivery.services.DisposableManager;
import com.editor.shippingdelivery.services.RetrofitClient;
import com.editor.shippingdelivery.services.RetrofitInterface;
import com.editor.shippingdelivery.utils.AppUtils;

import org.json.JSONObject;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class WhatsappDeliveryStatusRepo {

    public MutableLiveData<List<WhatsappStatusHeaderDataModel>> whatsappOrderLiveData;
    public MutableLiveData<Boolean> isProgress;

    public WhatsappDeliveryStatusRepo() {
        whatsappOrderLiveData = new MutableLiveData<>();
        isProgress = new MutableLiveData<>(true);
    }

    public MutableLiveData<List<WhatsappStatusHeaderDataModel>> getWhatsappOrderLiveDate() {
        return whatsappOrderLiveData;
    }

    public MutableLiveData<Boolean> getprogressLiveData() {
        return isProgress;
    }

    public void getShippingOrderList() {
        RetrofitInterface service = RetrofitClient.getClient();
        WhatsappDeliveryStatusRequest whatsappDeliveryStatusRequest = new WhatsappDeliveryStatusRequest();
        DisposableManager.add(service.getWhatsappOrderList(whatsappDeliveryStatusRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseBodyResponse -> {
                    if (responseBodyResponse.isSuccessful()) {
                        if (responseBodyResponse.body() != null) {
                            String resbody = responseBodyResponse.body().string();
                            JSONObject jsonObject = new JSONObject(resbody);
                            String response = AppUtils.getInstance().decompressGZIP(jsonObject.getString("pendingDeliveryOrder"));
                            List<WhatsappStatusHeaderDataModel> whatsappStatusHeaderDataModelList = AppUtils.getInstance().getConvertedList(response, WhatsappStatusHeaderDataModel.class);
                            whatsappOrderLiveData.setValue(whatsappStatusHeaderDataModelList);
                            isProgress.setValue(false);
                        }
                    }
                }, throwable -> {
                    Log.d("TAG", "getShippingOrderList: " + throwable.getMessage());
                }));
    }


}
