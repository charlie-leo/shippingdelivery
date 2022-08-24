package com.editor.shippingdelivery.main.tracking;

import android.app.Activity;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.editor.shippingdelivery.BR;
import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingOrderHeaderDataModel;

import java.util.List;

public class TrackingViewModel extends BaseObservable {


    private final TrackingRepo trackingRepo = new TrackingRepo();
    private Activity activity;
    private List<PendingOrderHeaderDataModel> trackingListData;

    public TrackingViewModel() {
        trackingRepo.getTrackingDetailList(this);
    }


    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Bindable
    public List<PendingOrderHeaderDataModel> getTrackingListData() {
        return trackingListData;
    }

    public void setTrackingListData(List<PendingOrderHeaderDataModel> trackingListData) {
        this.trackingListData = trackingListData;
        notifyPropertyChanged(BR.trackingListData);
    }


    @BindingAdapter("setTrackingAdapter")
    public static void setTrackingAdapter(RecyclerView recyclerView, List<PendingOrderHeaderDataModel> trackingListData){
        if (trackingListData != null && !trackingListData.isEmpty()) {
            TrackingAdapter trackingAdapter = new TrackingAdapter(recyclerView.getContext(), trackingListData);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(trackingAdapter);
        }
    }
}
