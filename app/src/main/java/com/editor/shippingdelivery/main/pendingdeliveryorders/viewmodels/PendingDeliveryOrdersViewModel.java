package com.editor.shippingdelivery.main.pendingdeliveryorders.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.editor.shippingdelivery.main.pendingdeliveryorders.respository.PendingDeliveryOrderRepo;
import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingOrderHeaderDataModel;

import java.util.List;

public class PendingDeliveryOrdersViewModel extends AndroidViewModel {

    public MutableLiveData<List<PendingOrderHeaderDataModel>> pendingOrderHeaderDataModel;
    public MutableLiveData<Boolean> isProgress;

    private final PendingDeliveryOrderRepo pendingDeliveryOrderRepo;

    public PendingDeliveryOrdersViewModel(@NonNull Application application) {
        super(application);
        pendingDeliveryOrderRepo = new PendingDeliveryOrderRepo();
        isProgress = pendingDeliveryOrderRepo.getprogressLiveData();
    }

    public MutableLiveData<List<PendingOrderHeaderDataModel>> getPendingDeliveryOrders() {
        return pendingOrderHeaderDataModel = pendingDeliveryOrderRepo.getPendingDeliveryOrdersList();
    }
}
