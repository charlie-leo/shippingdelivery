package com.editor.shippingdelivery.main.tracking;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.editor.shippingdelivery.main.pickup.DeliveryOrdersRepo;
import com.editor.shippingdelivery.main.pickup.model.DeliveryOrdesrHeaderDataModel;
import com.editor.shippingdelivery.main.tracking.model.TrackingDeliveryOrdesrHeaderDataModel;

import java.util.List;

public class TrackingDelveryViewModel extends AndroidViewModel {
    public MutableLiveData<List<TrackingDeliveryOrdesrHeaderDataModel>> deliveryOrdersList;
    public MutableLiveData<Boolean> isProgress;

    private final TrackingDeliveryOrdersRepo deliveryOrdersRepo;

    public TrackingDelveryViewModel(@NonNull Application application) {
        super(application);
        deliveryOrdersRepo = new TrackingDeliveryOrdersRepo();
        isProgress = deliveryOrdersRepo.getprogressLiveData();
    }

    public MutableLiveData<List<TrackingDeliveryOrdesrHeaderDataModel>> getPendingDeliveryOrders() {
        return deliveryOrdersList = deliveryOrdersRepo.getDeliveryOrdersLiveData();
    }
}
