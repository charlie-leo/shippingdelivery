package com.editor.shippingdelivery.main.pendingdeliveryorders;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.editor.shippingdelivery.R;
import com.editor.shippingdelivery.databinding.ActivityPendingDeliveryOrdersBinding;
import com.editor.shippingdelivery.databinding.BottomSheetBillInfoBinding;
import com.editor.shippingdelivery.main.pendingdeliveryorders.adapter.InfoBottomSheetDetailsAdapter;
import com.editor.shippingdelivery.main.pendingdeliveryorders.adapter.PendingDeliveryOrdersAdapter;
import com.editor.shippingdelivery.main.pendingdeliveryorders.listeners.OnListItemClickListener;
import com.editor.shippingdelivery.main.pendingdeliveryorders.model.InfoBottomSheetDetailsModel;
import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingOrderHeaderDataModel;
import com.editor.shippingdelivery.main.pendingdeliveryorders.viewmodels.InfoBottomSheetViewModel;
import com.editor.shippingdelivery.main.pendingdeliveryorders.viewmodels.PendingDeliveryOrdersViewModel;
import com.editor.shippingdelivery.main.pickup.model.DeliveryOrdesrHeaderDataModel;
import com.editor.shippingdelivery.main.placeOrder.OrderPlacementActivity;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class PendingDeliveryOrdersActivity extends AppCompatActivity implements LifecycleOwner {

    private ActivityPendingDeliveryOrdersBinding activityPendingDeliveryOrdersBinding;
    private PendingDeliveryOrdersViewModel pendingDeliveryOrdersViewModel;
    private PendingDeliveryOrdersAdapter pendingDeliveryOrdersAdapter;
    private InfoBottomSheetViewModel infoBottomSheetViewModel;
    private BottomSheetBillInfoBinding bottomSheetBillInfoBinding;
    private InfoBottomSheetDetailsAdapter infoBottomSheetDetailsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        initRecyclerView();
        observerFun();
        Intent in = new Intent(this, OrderPlacementActivity.class);
        startActivity(in);
    }

    private void initDataBinding() {
        activityPendingDeliveryOrdersBinding = DataBindingUtil.setContentView(this, R.layout.activity_pending_delivery_orders);
        pendingDeliveryOrdersViewModel = new ViewModelProvider(this).get(PendingDeliveryOrdersViewModel.class);
        activityPendingDeliveryOrdersBinding.setPendingDeliveryOrdersViewModel(pendingDeliveryOrdersViewModel);
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        activityPendingDeliveryOrdersBinding.rvPendingDeliveryOrders.setLayoutManager(layoutManager);
        activityPendingDeliveryOrdersBinding.rvPendingDeliveryOrders.setItemAnimator(new DefaultItemAnimator());
        pendingDeliveryOrdersAdapter = new PendingDeliveryOrdersAdapter(this, new OnListItemClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onClickInfo(View view, String viewName, int position, PendingOrderHeaderDataModel pendingOrderHeaderDataModel) {
                showInfoBottomSheetDialog(position, viewName, pendingOrderHeaderDataModel);
            }

            @Override
            public void onClickInfo(View view, String viewName, int position, DeliveryOrdesrHeaderDataModel pendingOrderHeaderDataModel) {

            }
        });
        activityPendingDeliveryOrdersBinding.rvPendingDeliveryOrders.setAdapter(pendingDeliveryOrdersAdapter);
    }

    private void observerFun() {
        pendingDeliveryOrdersViewModel.getPendingDeliveryOrders().observe(this, pendingOrderHeaderDataModels ->
                pendingDeliveryOrdersAdapter.setPendingDeliveryOrderList(pendingOrderHeaderDataModels));

        pendingDeliveryOrdersViewModel.isProgress.observe(this, aBoolean -> {
            if (aBoolean) {
                activityPendingDeliveryOrdersBinding.progressHorizontal.setVisibility(View.VISIBLE);
            } else {
                activityPendingDeliveryOrdersBinding.progressHorizontal.setVisibility(View.GONE);
            }
        });
    }

    private void showInfoBottomSheetDialog(int position, String viewName, PendingOrderHeaderDataModel pendingOrderHeaderDataModel) {
        bottomSheetBillInfoBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.bottom_sheet_bill_info, null, false);
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(bottomSheetBillInfoBinding.getRoot());

        infoBottomSheetViewModel = new ViewModelProvider(this).get(InfoBottomSheetViewModel.class);
        bottomSheetBillInfoBinding.setBottomSheetvm(infoBottomSheetViewModel);

        initInfoBottomSheetRecyclerView();

        infoBottomSheetViewModel.setBottomSheetHeader(viewName);

        infoBottomSheetViewModel.getInfoBottomSheetList(viewName, position, pendingOrderHeaderDataModel).observe(this, infoBottomSheetDetailsModelList ->
                infoBottomSheetDetailsAdapter.setPendingDeliveryOrderList(infoBottomSheetDetailsModelList));

        bottomSheetDialog.show();
    }

    private void initInfoBottomSheetRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        bottomSheetBillInfoBinding.rvInfoDetails.setLayoutManager(layoutManager);
        bottomSheetBillInfoBinding.rvInfoDetails.setItemAnimator(new DefaultItemAnimator());
        infoBottomSheetDetailsAdapter = new InfoBottomSheetDetailsAdapter(this);
        bottomSheetBillInfoBinding.rvInfoDetails.setAdapter(infoBottomSheetDetailsAdapter);
    }

    public void back(View view) {
        finish();
    }

}