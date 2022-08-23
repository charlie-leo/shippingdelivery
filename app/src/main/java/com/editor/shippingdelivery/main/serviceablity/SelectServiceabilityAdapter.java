package com.editor.shippingdelivery.main.serviceablity;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.editor.shippingdelivery.R;
import com.editor.shippingdelivery.common.DataInstance;
import com.editor.shippingdelivery.common.StaticVariables;
import com.editor.shippingdelivery.databinding.ServiceabilityItemBinding;
import com.editor.shippingdelivery.main.pickup.PickUpActivity;
import com.editor.shippingdelivery.main.serviceablity.model.AvailableCourierCompaniesItem;
import com.editor.shippingdelivery.main.serviceablity.model.Data;
import com.editor.shippingdelivery.services.DisposableManager;
import com.editor.shippingdelivery.services.RetrofitClient;
import com.editor.shippingdelivery.services.RetrofitInterface;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Charles Raj I on 19/08/22.
 *
 * @author Charles Raj I
 */
public class SelectServiceabilityAdapter extends RecyclerView.Adapter<SelectServiceabilityAdapter.SelectServiceabilityViewHolder> {

    private List<AvailableCourierCompaniesItem> availableCourierCompaniesItems;
    private SelectServiceabilityViewModel selectServiceabilityViewModel;
    private static final String TAG = "SelectServiceabilityAdapter";

    public SelectServiceabilityAdapter(List<AvailableCourierCompaniesItem> availableCourierCompaniesItems, SelectServiceabilityViewModel selectServiceabilityViewModel) {
        this.availableCourierCompaniesItems = availableCourierCompaniesItems;
        this.selectServiceabilityViewModel = selectServiceabilityViewModel;
    }

    @NonNull
    @Override
    public SelectServiceabilityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ServiceabilityItemBinding serviceabilityItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.serviceability_item, parent, false);
        return new SelectServiceabilityViewHolder(serviceabilityItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectServiceabilityViewHolder holder, int position) {
        AvailableCourierCompaniesItem courierCompaniesItem = availableCourierCompaniesItems.get(position);
        holder.onBind(courierCompaniesItem, selectServiceabilityViewModel);
    }

    @Override
    public int getItemCount() {
        return availableCourierCompaniesItems.size();
    }

    public static class SelectServiceabilityViewHolder extends RecyclerView.ViewHolder implements DataInstance {
        private ServiceabilityItemBinding itemView;
        public SelectServiceabilityViewHolder(@NonNull ServiceabilityItemBinding itemView) {
            super(itemView.getRoot());
            this.itemView = itemView;
        }
        public void onBind(AvailableCourierCompaniesItem courierCompaniesItem, SelectServiceabilityViewModel selectServiceabilityViewModel){
            itemView.setServiceableData(courierCompaniesItem);
            itemView.deliveryBase.setOnClickListener(view -> {
                RetrofitInterface service = RetrofitClient.getClient();
                int courierId = courierCompaniesItem.getCourierCompanyId();
                String invoiceId = getApplicationData(StaticVariables.INVOICE_ID);

                try {
                    DisposableManager.add(service.selectServiceApi(invoiceId, courierId)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(jsonObject -> {
                                if ((int)jsonObject.getAsJsonPrimitive("status_code").getAsInt() == 200){
                                    Intent intent = new Intent(itemView.getRoot().getContext(), PickUpActivity.class);
                                    itemView.getRoot().getContext().startActivity(intent);
                                }
                                selectServiceabilityViewModel.setErrorMessage(jsonObject.getAsJsonPrimitive("message").getAsString());
                            }));
                }catch (Exception e){
                    Log.d(TAG, "onBind: " + e.getMessage());
                }
            });
        }
    }
}
