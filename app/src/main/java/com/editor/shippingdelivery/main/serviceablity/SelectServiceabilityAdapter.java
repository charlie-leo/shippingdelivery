package com.editor.shippingdelivery.main.serviceablity;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.editor.shippingdelivery.R;
import com.editor.shippingdelivery.databinding.ServiceabilityItemBinding;
import com.editor.shippingdelivery.main.serviceablity.model.AvailableCourierCompaniesItem;

import java.util.List;

/**
 * Created by Charles Raj I on 19/08/22.
 *
 * @author Charles Raj I
 */
public class SelectServiceabilityAdapter extends RecyclerView.Adapter<SelectServiceabilityAdapter.SelectServiceabilityViewHolder> {

    private List<AvailableCourierCompaniesItem> availableCourierCompaniesItems;

    public SelectServiceabilityAdapter(List<AvailableCourierCompaniesItem> availableCourierCompaniesItems) {
        this.availableCourierCompaniesItems = availableCourierCompaniesItems;
    }

    @NonNull
    @Override
    public SelectServiceabilityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ServiceabilityItemBinding serviceabilityItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_service_availabilty_list, parent, false);
        return new SelectServiceabilityViewHolder(serviceabilityItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectServiceabilityViewHolder holder, int position) {
        AvailableCourierCompaniesItem courierCompaniesItem = availableCourierCompaniesItems.get(position);
        holder.onBind(courierCompaniesItem);
    }

    @Override
    public int getItemCount() {
        return availableCourierCompaniesItems.size();
    }

    public static class SelectServiceabilityViewHolder extends RecyclerView.ViewHolder {
        private ServiceabilityItemBinding itemView;

        public SelectServiceabilityViewHolder(@NonNull ServiceabilityItemBinding itemView) {
            super(itemView.getRoot());
            this.itemView = itemView;
        }

        public void onBind(AvailableCourierCompaniesItem courierCompaniesItem) {
            itemView.setServiceableData(courierCompaniesItem);
        }
    }
}
