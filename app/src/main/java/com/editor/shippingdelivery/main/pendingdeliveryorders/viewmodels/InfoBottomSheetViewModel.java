package com.editor.shippingdelivery.main.pendingdeliveryorders.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.editor.shippingdelivery.main.pendingdeliveryorders.model.InfoBottomSheetDetailsModel;
import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingOrderHeaderDataModel;

import java.util.ArrayList;
import java.util.List;

public class InfoBottomSheetViewModel extends AndroidViewModel {
    public MutableLiveData<String> bottomSheetHeader = new MutableLiveData<>("Header");
    public MutableLiveData<List<InfoBottomSheetDetailsModel>> infoDetailsList;

    public InfoBottomSheetViewModel(@NonNull Application application) {
        super(application);
    }

    public void setBottomSheetHeader(String viewName) {
        bottomSheetHeader.setValue(viewName);
    }

    public MutableLiveData<List<InfoBottomSheetDetailsModel>> getInfoBottomSheetList(String viewName, int position, PendingOrderHeaderDataModel pendingOrderHeaderDataModel) {
        infoDetailsList = new MutableLiveData<>(new ArrayList<>());

        if (viewName.equalsIgnoreCase("Bill Info")) {
            getBillingInfo(pendingOrderHeaderDataModel);
        } else if (viewName.equalsIgnoreCase("Customer Info")) {
            getCustomerInfo(pendingOrderHeaderDataModel);
        } else if (viewName.equalsIgnoreCase("Route Info")) {
            getRouteInfo(pendingOrderHeaderDataModel);
        }

        return infoDetailsList;
    }

    private void getRouteInfo(PendingOrderHeaderDataModel pendingOrderHeaderDataModel) {
        List<InfoBottomSheetDetailsModel> infoBottomSheetDetailsModels = new ArrayList<>();
        infoBottomSheetDetailsModels.add(new InfoBottomSheetDetailsModel("Salesman Code", pendingOrderHeaderDataModel.getSalesmanCode()));
        infoBottomSheetDetailsModels.add(new InfoBottomSheetDetailsModel("Salesman Name", pendingOrderHeaderDataModel.getSalesmanName()));
        infoBottomSheetDetailsModels.add(new InfoBottomSheetDetailsModel("Route Code", pendingOrderHeaderDataModel.getRouteCode()));
        infoBottomSheetDetailsModels.add(new InfoBottomSheetDetailsModel("Route Name", pendingOrderHeaderDataModel.getRouteName()));
        infoDetailsList.setValue(infoBottomSheetDetailsModels);
    }

    private void getCustomerInfo(PendingOrderHeaderDataModel pendingOrderHeaderDataModel) {
        List<InfoBottomSheetDetailsModel> infoBottomSheetDetailsModels = new ArrayList<>();
        infoBottomSheetDetailsModels.add(new InfoBottomSheetDetailsModel("Customer Code", pendingOrderHeaderDataModel.getCustomerCode()));
        infoBottomSheetDetailsModels.add(new InfoBottomSheetDetailsModel("Customer Name", pendingOrderHeaderDataModel.getCustomerName()));
        infoBottomSheetDetailsModels.add(new InfoBottomSheetDetailsModel("Mobile No", pendingOrderHeaderDataModel.getMobileNo()));
        infoBottomSheetDetailsModels.add(new InfoBottomSheetDetailsModel("Customer Ship Addr", pendingOrderHeaderDataModel.getCustomerShipAddr()));
        infoDetailsList.setValue(infoBottomSheetDetailsModels);
    }

    private void getBillingInfo(PendingOrderHeaderDataModel pendingOrderHeaderDataModel) {
        List<InfoBottomSheetDetailsModel> infoBottomSheetDetailsModels = new ArrayList<>();
        infoBottomSheetDetailsModels.add(new InfoBottomSheetDetailsModel("Total Net Amt", getValueWithSymbol(pendingOrderHeaderDataModel.getTotGrossAmt().toString())));
        infoBottomSheetDetailsModels.add(new InfoBottomSheetDetailsModel("Total Disc Amt", getValueWithSymbol(pendingOrderHeaderDataModel.getTotSchDiscAmt().toString())));
        infoBottomSheetDetailsModels.add(new InfoBottomSheetDetailsModel("Total Tax Amt", getValueWithSymbol(pendingOrderHeaderDataModel.getTotTaxAmt().toString())));
        infoBottomSheetDetailsModels.add(new InfoBottomSheetDetailsModel("Total Round Off Amt", getValueWithSymbol(pendingOrderHeaderDataModel.getRoundOffAmt().toString())));
        infoBottomSheetDetailsModels.add(new InfoBottomSheetDetailsModel("Total Net Amt", getValueWithSymbol(pendingOrderHeaderDataModel.getTotNetAmt().toString())));
        infoBottomSheetDetailsModels.add(new InfoBottomSheetDetailsModel("Total Cr Note Amt", getValueWithSymbol(pendingOrderHeaderDataModel.getTotCrNoteAmt().toString())));
        infoBottomSheetDetailsModels.add(new InfoBottomSheetDetailsModel("Total Net Payable Amt", getValueWithSymbol(pendingOrderHeaderDataModel.getTotNetAmt().toString())));
        infoDetailsList.setValue(infoBottomSheetDetailsModels);
    }

    private String getValueWithSymbol(String value) {
        if (value != null) {
            StringBuilder stringBuilder = new StringBuilder("₹");
            stringBuilder.append(String.format("%.02f", (Double.parseDouble(value))));
            return stringBuilder.toString();
        }
        return "";
    }
}
