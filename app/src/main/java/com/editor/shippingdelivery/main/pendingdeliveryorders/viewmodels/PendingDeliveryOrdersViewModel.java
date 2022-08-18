package com.editor.shippingdelivery.main.pendingdeliveryorders.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.editor.shippingdelivery.main.pendingdeliveryorders.PendingDeliveryOrderRepo;
import com.editor.shippingdelivery.main.pendingdeliveryorders.adapter.PendingDeliveryOrdersAdapter;
import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingDeliveryOrdersRequest;
import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingOrderHeaderDataModel;
import com.editor.shippingdelivery.services.RetrofitClient;
import com.editor.shippingdelivery.services.RetrofitInterface;
import com.editor.shippingdelivery.utils.AppUtils;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PendingDeliveryOrdersViewModel extends AndroidViewModel {

    public MutableLiveData<List<PendingOrderHeaderDataModel>> pendingOrderHeaderDataModel;
    public MutableLiveData<Boolean> isProgress;

    private final PendingDeliveryOrderRepo pendingDeliveryOrderRepo;

    public PendingDeliveryOrdersViewModel(@NonNull Application application) {
        super(application);
        pendingDeliveryOrderRepo = new PendingDeliveryOrderRepo();
        pendingOrderHeaderDataModel = pendingDeliveryOrderRepo.getPendingOrderLiveDate();
        isProgress = pendingDeliveryOrderRepo.getprogressLiveData();
    }

    public void hitApi() {
        pendingDeliveryOrderRepo.getShippingOrderList();
    }
}
