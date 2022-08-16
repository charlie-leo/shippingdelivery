package com.editor.shippingdelivery.main.pendingdeliveryorders;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import com.editor.shippingdelivery.R;
import com.editor.shippingdelivery.databinding.ActivityPendingDeliveryOrdersBinding;
import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingOrderHeaderDataModel;
import com.editor.shippingdelivery.main.pendingdeliveryorders.viewmodels.PendingDeliveryOrdersViewModel;
import java.util.List;

public class PendingDeliveryOrdersActivity extends AppCompatActivity implements LifecycleOwner {

    private ActivityPendingDeliveryOrdersBinding activityPendingDeliveryOrdersBinding;
    private PendingDeliveryOrdersViewModel pendingDeliveryOrdersViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();

        pendingDeliveryOrdersViewModel.getPendingOrderHeadLiveData().observe(this,pendingOrderHeadLiveData);
    }

    Observer<List<PendingOrderHeaderDataModel>> pendingOrderHeadLiveData = pendingOrderHeaderDataModels -> {

    };

    private void initDataBinding() {
        activityPendingDeliveryOrdersBinding = DataBindingUtil.setContentView(this, R.layout.activity_pending_delivery_orders);
        pendingDeliveryOrdersViewModel = new ViewModelProvider(this).get(PendingDeliveryOrdersViewModel.class);
        activityPendingDeliveryOrdersBinding.setPendingDeliveryOrdersViewModel(pendingDeliveryOrdersViewModel);
    }


}