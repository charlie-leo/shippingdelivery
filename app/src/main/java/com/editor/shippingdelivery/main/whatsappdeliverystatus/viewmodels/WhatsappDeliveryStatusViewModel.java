package com.editor.shippingdelivery.main.whatsappdeliverystatus.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.editor.shippingdelivery.main.whatsappdeliverystatus.WhatsappDeliveryStatusRepo;
import com.editor.shippingdelivery.main.whatsappdeliverystatus.model.WhatsappStatusHeaderDataModel;

import java.util.List;

public class WhatsappDeliveryStatusViewModel extends AndroidViewModel {

    public MutableLiveData<List<WhatsappStatusHeaderDataModel>> whatsappStatusHeaderDataModel;
    public MutableLiveData<Boolean> isProgress;

    private final WhatsappDeliveryStatusRepo whatsappDeliveryStatusRepo;

    public WhatsappDeliveryStatusViewModel(@NonNull Application application) {
        super(application);
        whatsappDeliveryStatusRepo = new WhatsappDeliveryStatusRepo();
        whatsappStatusHeaderDataModel = whatsappDeliveryStatusRepo.getWhatsappOrderLiveDate();
        isProgress = whatsappDeliveryStatusRepo.getprogressLiveData();
    }

    public void hitApi() {
        whatsappDeliveryStatusRepo.getShippingOrderList();
    }
}
