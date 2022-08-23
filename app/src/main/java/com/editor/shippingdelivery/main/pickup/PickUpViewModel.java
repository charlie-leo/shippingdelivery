package com.editor.shippingdelivery.main.pickup;

import static android.text.Html.fromHtml;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.editor.shippingdelivery.R;
import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingOrderHeaderDataModel;
import com.editor.shippingdelivery.main.pendingdeliveryorders.respository.PendingDeliveryOrderRepo;
import com.editor.shippingdelivery.main.pickup.model.DeliveryOrdesrHeaderDataModel;

import java.util.List;

public class PickUpViewModel extends AndroidViewModel {
    public MutableLiveData<List<DeliveryOrdesrHeaderDataModel>> deliveryOrdersList;
    public MutableLiveData<Boolean> isProgress;

    private final DeliveryOrdersRepo deliveryOrdersRepo;

    public PickUpViewModel(@NonNull Application application) {
        super(application);
        deliveryOrdersRepo = new DeliveryOrdersRepo();
        isProgress = deliveryOrdersRepo.getprogressLiveData();
    }

    public MutableLiveData<List<DeliveryOrdesrHeaderDataModel>> getPendingDeliveryOrders() {
        return deliveryOrdersList = deliveryOrdersRepo.getDeliveryOrdersLiveData();
    }
}
