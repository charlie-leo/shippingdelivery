package com.editor.shippingdelivery.main.pickup;

import static android.text.Html.fromHtml;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.editor.shippingdelivery.R;
import com.editor.shippingdelivery.databinding.ActivityPickupBinding;
import com.editor.shippingdelivery.databinding.BottomSheetBillInfoBinding;
import com.editor.shippingdelivery.main.pendingdeliveryorders.adapter.InfoBottomSheetDetailsAdapter;
import com.editor.shippingdelivery.main.pendingdeliveryorders.listeners.OnListItemClickListener;
import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingOrderHeaderDataModel;
import com.editor.shippingdelivery.main.pendingdeliveryorders.viewmodels.InfoBottomSheetViewModel;
import com.editor.shippingdelivery.main.pickup.adapter.DeliveryOrdersListAdapter;
import com.editor.shippingdelivery.main.pickup.model.DeliveryOrdesrHeaderDataModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class PickUpActivity extends AppCompatActivity {

    private PickUpViewModel pickUpViewModel;
    private ActivityPickupBinding activityPickupBinding;
    private DeliveryOrdersListAdapter deliveryOrdersListAdapter;

    private BottomSheetBillInfoBinding bottomSheetBillInfoBinding;
    private InfoBottomSheetDetailsAdapter infoBottomSheetDetailsAdapter;
    private InfoBottomSheetViewModel infoBottomSheetViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDataBinding();
        initRecyclerView();
        observerFun();

    }

    private void initDataBinding() {
        activityPickupBinding = DataBindingUtil.setContentView(this, R.layout.activity_pickup);
        pickUpViewModel = new ViewModelProvider(this).get(PickUpViewModel.class);
        activityPickupBinding.setPickupVm(pickUpViewModel);
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        activityPickupBinding.rvDeliveryList.setLayoutManager(layoutManager);
        activityPickupBinding.rvDeliveryList.setItemAnimator(new DefaultItemAnimator());
        deliveryOrdersListAdapter = new DeliveryOrdersListAdapter(this, new DeliveryOrdersListAdapter.OnClickDeliveryListener() {
            @Override
            public void onCancelDeliveryClick(int position, DeliveryOrdesrHeaderDataModel deliveryOrdesrHeaderDataModel) {
                showDialog("Cancel Delvery", "Are you sure, You want to cancel delivery", 0);
            }

            @Override
            public void onPickUpDeliveryClick(int position, DeliveryOrdesrHeaderDataModel deliveryOrdesrHeaderDataModel) {
                showDialog("Confirm Pickup", "Are you sure, You want to confirm delivery pickup", 1);

            }
        });
        activityPickupBinding.rvDeliveryList.setAdapter(deliveryOrdersListAdapter);
    }

    private void observerFun() {
        pickUpViewModel.getPendingDeliveryOrders().observe(this, deliveryOrdesrHeaderDataModels ->
                deliveryOrdersListAdapter.setDeliveryOrdersList(deliveryOrdesrHeaderDataModels));

        pickUpViewModel.isProgress.observe(this, aBoolean -> {
            if (aBoolean) {
                activityPickupBinding.progressHorizontal.setVisibility(View.VISIBLE);
            } else {
                activityPickupBinding.progressHorizontal.setVisibility(View.GONE);
            }
        });
    }

    private void showInfoBottomSheetDialog(int position, String viewName, DeliveryOrdesrHeaderDataModel deliveryOrdesrHeaderDataModel) {
      /*  bottomSheetBillInfoBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.bottom_sheet_bill_info, null, false);
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(bottomSheetBillInfoBinding.getRoot());

        infoBottomSheetViewModel = new ViewModelProvider(this).get(InfoBottomSheetViewModel.class);
        bottomSheetBillInfoBinding.setBottomSheetvm(infoBottomSheetViewModel);

        initInfoBottomSheetRecyclerView();

        infoBottomSheetViewModel.setBottomSheetHeader(viewName);

        infoBottomSheetViewModel.getInfoBottomSheetList(viewName, position, deliveryOrdesrHeaderDataModel).observe(this, infoBottomSheetDetailsModelList ->
                infoBottomSheetDetailsAdapter.setPendingDeliveryOrderList(infoBottomSheetDetailsModelList));

        bottomSheetDialog.show();*/
    }

    private void initInfoBottomSheetRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        bottomSheetBillInfoBinding.rvInfoDetails.setLayoutManager(layoutManager);
        bottomSheetBillInfoBinding.rvInfoDetails.setItemAnimator(new DefaultItemAnimator());
        infoBottomSheetDetailsAdapter = new InfoBottomSheetDetailsAdapter(this);
        bottomSheetBillInfoBinding.rvInfoDetails.setAdapter(infoBottomSheetDetailsAdapter);
    }

    public void showDialog(String title, String msg,
                           int type) {

        Dialog Dialog = new Dialog(this, R.style.ThemeDialogCustom);
        Dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Dialog.setCanceledOnTouchOutside(false);
        Dialog.setCancelable(false);
        Dialog.setContentView(R.layout.msg_dialog);
        TextView txtMsg = Dialog.findViewById(R.id.alert_msg);
        TextView txtTitle = Dialog.findViewById(R.id.alert_title);

        final Button ok = Dialog.findViewById(R.id.alert_ok_btn);
        final Button cancel = Dialog.findViewById(R.id.alert_cancel_btn);

        txtTitle.setText(title);

        if (msg.startsWith("<font")) {
            txtMsg.setText(fromHtml(msg));
        } else {
            txtMsg.setText(msg);
        }

        ok.setOnClickListener(v -> {
            Dialog.dismiss();
            if (type == 1) {

            } else {

            }
        });

        cancel.setOnClickListener(v -> {
            Dialog.dismiss();
            if (type == 1) {

            } else {

            }
        });

        if (!Dialog.isShowing())
            Dialog.show();
    }

    public void back(View view) {
        finish();
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
    protected void onDestroy() {
        super.onDestroy();
    }
}
