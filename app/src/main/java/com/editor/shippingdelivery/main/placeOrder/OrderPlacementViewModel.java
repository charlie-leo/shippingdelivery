package com.editor.shippingdelivery.main.placeOrder;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.fragment.app.FragmentManager;

import com.editor.shippingdelivery.BR;
import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingOrderHeaderDataModel;
import com.editor.shippingdelivery.main.placeOrder.model.CreateOrderRequest;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

/**
 * Created by Charles Raj I on 18/08/22.
 *
 * @author Charles Raj I
 */
public class OrderPlacementViewModel extends  BaseObservable {

    private Activity activity;
    private FragmentManager fragmentManager;
    private PendingOrderHeaderDataModel orderData;
    private CreateOrderRequest createOrderRequest;
    private OrderPlacementRepo orderPlacementRepo;


    public void setActivity(Activity activity) {
        this.activity = activity;
        orderPlacementRepo = new OrderPlacementRepo();
    }

    @Bindable
    public FragmentManager getFragmentManager() {
        return fragmentManager;
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
        notifyPropertyChanged(BR.fragmentManager);
    }
    @Bindable
    public PendingOrderHeaderDataModel getOrderData() {
        return orderData;
    }

    public void setOrderData(PendingOrderHeaderDataModel orderData) {
        this.orderData = orderData;
        notifyPropertyChanged(BR.orderData);
    }
    @Bindable
    public CreateOrderRequest getCreateOrderRequest() {
        return createOrderRequest;
    }

    public void setCreateOrderRequest(CreateOrderRequest createOrderRequest) {
        this.createOrderRequest = createOrderRequest;
        notifyPropertyChanged(BR.createOrderRequest);
    }
    @Bindable
    public OrderPlacementRepo getOrderPlacementViewModel() {
        return orderPlacementRepo;
    }

    public void setOrderPlacementViewModel(OrderPlacementRepo orderPlacementRepo) {
        this.orderPlacementRepo = orderPlacementRepo;
        notifyPropertyChanged(BR.orderPlacementViewModel);
    }

    public void setPendingDeliveryToCreateOrder(PendingOrderHeaderDataModel orderData){
//        createOrderRequest.setOrderId(orderData.code);
    }

    public void selectStartDate(View view){
        MaterialDatePicker.Builder materialDateBuilder = MaterialDatePicker.Builder.datePicker();
        materialDateBuilder.setTitleText("SELECT A DATE");
        final MaterialDatePicker materialDatePicker = materialDateBuilder.build();
        materialDatePicker.show(fragmentManager, "MATERIAL_DATE_PICKER");
        materialDatePicker.addOnPositiveButtonClickListener(
                new MaterialPickerOnPositiveButtonClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onPositiveButtonClick(Object selection) {
                        createOrderRequest.setOrderDate(materialDatePicker.getHeaderText());
                        ((TextView)view).setText(materialDatePicker.getHeaderText());
                    }
                });
    }

    public void placeOrder(View view){
        orderPlacementRepo.createShippingOrder(activity,createOrderRequest);
    }
}
