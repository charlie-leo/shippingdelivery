package com.editor.shippingdelivery.main.serviceablity;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.editor.shippingdelivery.BR;
import com.editor.shippingdelivery.common.DataInstance;
import com.editor.shippingdelivery.main.serviceablity.model.ServiceabilityResponse;

/**
 * Created by Charles Raj I on 19/08/22.
 *
 * @author Charles Raj I
 */
public class SelectServiceabilityViewModel extends BaseObservable  {


    private ServiceabilityResponse serviceabilityResponse;
    private SelectServiceabilityRepo selectServiceabilityRepo;
    private String errorMessage;

    public SelectServiceabilityViewModel() {
        selectServiceabilityRepo = new SelectServiceabilityRepo();
    }

    @Bindable
    public ServiceabilityResponse getServiceabilityResponse() {
        return serviceabilityResponse;
    }

    public void setServiceabilityResponse(ServiceabilityResponse serviceabilityResponse) {
        this.serviceabilityResponse = serviceabilityResponse;
        notifyPropertyChanged(BR.serviceabilityResponse);
    }

    public void getServiceability(String invoiceId){
        selectServiceabilityRepo.getAvailableServices(this,invoiceId);
    }

    @Bindable
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        notifyPropertyChanged(BR.errorMessage);
    }

    @BindingAdapter( value = {"setServiceabilityAdapter", "setServiceAbilityViewModel"})
    public static void setServiceabilityAdapter(RecyclerView recyclerView, ServiceabilityResponse serviceabilityResponse, SelectServiceabilityViewModel selectServiceabilityViewModel){
        if (serviceabilityResponse != null && !serviceabilityResponse.getData().getAvailableCourierCompanies().isEmpty()) {
            SelectServiceabilityAdapter selectServiceabilityAdapter = new SelectServiceabilityAdapter(serviceabilityResponse.getData().getAvailableCourierCompanies(), selectServiceabilityViewModel);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            recyclerView.setAdapter(selectServiceabilityAdapter);
        }
    }
}
