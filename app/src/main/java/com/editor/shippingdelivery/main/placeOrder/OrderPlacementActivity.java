package com.editor.shippingdelivery.main.placeOrder;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.editor.shippingdelivery.R;
import com.editor.shippingdelivery.databinding.ActivityPlaceDeliveryOrderBinding;
import com.editor.shippingdelivery.databinding.BottomSheetAddressDetailsBinding;
import com.editor.shippingdelivery.databinding.OrderPlacmentBinding;
import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingOrderHeaderDataModel;
import com.editor.shippingdelivery.main.pendingdeliveryorders.viewmodels.InfoBottomSheetViewModel;
import com.editor.shippingdelivery.main.placeOrder.bottomsheet.AddressDetailsBottomSheetViewModel;
import com.editor.shippingdelivery.main.placeOrder.model.CreateOrderRequest;
import com.google.android.material.bottomsheet.BottomSheetDialog;

/**
 * Created by Charles Raj I on 15/08/22.
 *
 * @author Charles Raj I
 */
public class OrderPlacementActivity extends AppCompatActivity implements LifecycleOwner {

    private Activity activity;
    private OrderPlacementRepo orderPlacementRepo;
    private OrderPlacementViewModel orderPlacementViewModel;

    private BottomSheetAddressDetailsBinding bottomSheetAddressDetailsBinding;
    private AddressDetailsBottomSheetViewModel addressDetailsBottomSheetViewModel;

    private PlaceDeliveryOrderViewModel placeDeliveryOrderViewModel;
    private ActivityPlaceDeliveryOrderBinding activityPlaceDeliveryOrderBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = OrderPlacementActivity.this;
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        activityPlaceDeliveryOrderBinding = DataBindingUtil.setContentView(activity, R.layout.activity_place_delivery_order);
//        orderPlacementViewModel = new ViewModelProvider(this).get(OrderPlacementViewModel.class);

        orderPlacementViewModel = new OrderPlacementViewModel();
        orderPlacementViewModel.setActivity(activity);
        orderPlacementViewModel.setFragmentManager(getSupportFragmentManager());
        orderPlacementViewModel.setCreateOrderRequest(new CreateOrderRequest());
//        orderPlacementViewModel.setOrderPlacementViewModel(orderPlacementViewModel);
        activityPlaceDeliveryOrderBinding.setOrderPlacementViewModel(orderPlacementViewModel);

        if (getIntent() != null) {
            orderPlacementViewModel.setOrderData(getIntent().getParcelableExtra("orderData"));
        }

        activityPlaceDeliveryOrderBinding.constraintLayoutBillingDetails.setOnClickListener(view -> {
            showAddressDetailsBottomSheetDialog("Billing Address");
        });

        activityPlaceDeliveryOrderBinding.constraintLayoutShippingDetails.setOnClickListener(view -> {
            showAddressDetailsBottomSheetDialog("Shipping Address");
        });

/*
        initDataBinding();

        activityPlaceDeliveryOrderBinding.constraintLayoutBillingDetails.setOnClickListener(view ->
        {
            showAddressDetailsBottomSheetDialog("Billing Address");
        });

        activityPlaceDeliveryOrderBinding.constraintLayoutShippingDetails.setOnClickListener(view -> {
            showAddressDetailsBottomSheetDialog("Shipping Address");
        });

        activityPlaceDeliveryOrderBinding.tvPlaceOrder.setOnClickListener(view -> {
            placeDeliveryOrderViewModel.validate();
        });*/

    }

   /* private void initDataBinding() {
        activityPlaceDeliveryOrderBinding = DataBindingUtil.setContentView(activity, R.layout.activity_place_delivery_order);
        placeDeliveryOrderViewModel = new ViewModelProvider(this).get(PlaceDeliveryOrderViewModel.class);
        activityPlaceDeliveryOrderBinding.setPlaceDeliverOrderVm(placeDeliveryOrderViewModel);
    }*/

    private void showAddressDetailsBottomSheetDialog(String headerName) {
        bottomSheetAddressDetailsBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.bottom_sheet_address_details, null, false);
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(bottomSheetAddressDetailsBinding.getRoot());
        bottomSheetDialog.setOwnerActivity(this);
        bottomSheetDialog.setDismissWithAnimation(true);


        addressDetailsBottomSheetViewModel = new ViewModelProvider(this).get(AddressDetailsBottomSheetViewModel.class);
        bottomSheetAddressDetailsBinding.setBottomSheetvm(addressDetailsBottomSheetViewModel);

        addressDetailsBottomSheetViewModel.setBottomSheetHeader(headerName);

        addressDetailsBottomSheetViewModel.getErrorMsg().observe(this, s -> {
            addressDetailsBottomSheetViewModel.setErrorEt(bottomSheetAddressDetailsBinding.mainConstraintLayout, s);
        });

        bottomSheetDialog.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
