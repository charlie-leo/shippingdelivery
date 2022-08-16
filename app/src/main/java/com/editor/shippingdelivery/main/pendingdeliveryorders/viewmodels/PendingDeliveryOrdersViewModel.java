package com.editor.shippingdelivery.main.pendingdeliveryorders.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.editor.shippingdelivery.databinding.ListPendingDeliveryOrdersBinding;
import com.editor.shippingdelivery.main.pendingdeliveryorders.PendingDeliveryOrderRepo;
import com.editor.shippingdelivery.main.pendingdeliveryorders.adapter.PendingDeliveryOrdersAdapter;
import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingOrderHeaderDataModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;

public class PendingDeliveryOrdersViewModel extends AndroidViewModel {

    private PendingDeliveryOrderRepo pendingDeliveryOrderRepo;
    public PendingDeliveryOrdersViewModel(@NonNull Application application) {
        super(application);
        pendingDeliveryOrderRepo = new PendingDeliveryOrderRepo();
    }

    public MutableLiveData<List<PendingOrderHeaderDataModel>> getPendingOrderHeadLiveData(){
        return pendingDeliveryOrderRepo.getPendingOrderLiveDate();
    }


    @BindingAdapter("setPendingDeliveryAdapter")
    private static void initRecyclerView(RecyclerView recyclerView, List<PendingOrderHeaderDataModel> pendingOrderHeaderDataModelList) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        PendingDeliveryOrdersAdapter pendingDeliveryOrdersAdapter = new PendingDeliveryOrdersAdapter(recyclerView.getContext(), pendingOrderHeaderDataModelList);
        recyclerView.setAdapter(pendingDeliveryOrdersAdapter);
    }
}
