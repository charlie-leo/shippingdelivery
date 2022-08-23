package com.editor.shippingdelivery.main.placeOrder;

import android.app.Application;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import com.editor.shippingdelivery.main.placeOrder.model.CreateOrderRequest;

public class PlaceDeliveryOrderViewModel extends AndroidViewModel {
    public MutableLiveData<CreateOrderRequest> createOrderRequest;

    public PlaceDeliveryOrderViewModel(@NonNull Application application) {
        super(application);
        createOrderRequest = new MutableLiveData<>();
    }

/*    @Bindable
    public CreateOrderRequest getCreateOrderRequest() {
        return createOrderRequest;
    }

    @Bindable
    public void setCreateOrderRequest(CreateOrderRequest createOrderRequest) {
        this.createOrderRequest = createOrderRequest;
    }*/

    public void validate() {
        System.out.println("************************** " + createOrderRequest.getValue().getBreadth() + " " + createOrderRequest.getValue().getLength());
    }


}
