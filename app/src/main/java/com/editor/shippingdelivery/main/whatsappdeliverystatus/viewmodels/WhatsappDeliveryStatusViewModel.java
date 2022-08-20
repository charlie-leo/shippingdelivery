package com.editor.shippingdelivery.main.whatsappdeliverystatus.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.editor.shippingdelivery.main.whatsappdeliverystatus.model.WhatsappStatusHeaderDataModel;
import com.editor.shippingdelivery.main.whatsappdeliverystatus.respository.WhatsappDeliveryStatusRepo;

import java.util.List;

public class WhatsappDeliveryStatusViewModel extends AndroidViewModel {

    public MutableLiveData<List<WhatsappStatusHeaderDataModel>> whatsappStatusHeaderDataModel;
    public MutableLiveData<Boolean> isProgress;

    private final WhatsappDeliveryStatusRepo whatsappDeliveryStatusRepo;

    public WhatsappDeliveryStatusViewModel(@NonNull Application application) {
        super(application);
        whatsappDeliveryStatusRepo = new WhatsappDeliveryStatusRepo();
        whatsappStatusHeaderDataModel = whatsappDeliveryStatusRepo.getPendingDeliveryOrdersList();
        isProgress = whatsappDeliveryStatusRepo.getprogressLiveData();
    }

    public MutableLiveData<List<WhatsappStatusHeaderDataModel>> getWhatsappStatusOrders() {
        return whatsappStatusHeaderDataModel = whatsappDeliveryStatusRepo.getPendingDeliveryOrdersList();
    }
}
