package com.editor.shippingdelivery.main.whatsappdeliverystatus.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.editor.shippingdelivery.main.whatsappdeliverystatus.model.WhatsappInfoBottomSheetDetailsModel;
import com.editor.shippingdelivery.main.whatsappdeliverystatus.model.WhatsappStatusHeaderDataModel;

import java.util.ArrayList;
import java.util.List;

public class WhatsappInfoBottomSheetViewModel extends AndroidViewModel {
    public MutableLiveData<String> bottomSheetHeader = new MutableLiveData<>("Header");
    public MutableLiveData<List<WhatsappInfoBottomSheetDetailsModel>> infoDetailsList;

    public WhatsappInfoBottomSheetViewModel(@NonNull Application application) {
        super(application);
    }

    public void setBottomSheetHeader(String viewName) {
        bottomSheetHeader.setValue(viewName);
    }

    public MutableLiveData<List<WhatsappInfoBottomSheetDetailsModel>> getInfoBottomSheetList(String viewName, int position, WhatsappStatusHeaderDataModel whatsappStatusHeaderDataModel) {
        infoDetailsList = new MutableLiveData<>(new ArrayList<>());

        if (viewName.equalsIgnoreCase("Bill Info")) {
            getBillingInfo(whatsappStatusHeaderDataModel);
        } else if (viewName.equalsIgnoreCase("Customer Info")) {
            getCustomerInfo(whatsappStatusHeaderDataModel);
        } else if (viewName.equalsIgnoreCase("Route Info")) {
            getRouteInfo(whatsappStatusHeaderDataModel);
        }

        return infoDetailsList;
    }

    private void getRouteInfo(WhatsappStatusHeaderDataModel whatsappStatusHeaderDataModel) {
        List<WhatsappInfoBottomSheetDetailsModel> infoBottomSheetDetailsModels = new ArrayList<>();
        infoBottomSheetDetailsModels.add(new WhatsappInfoBottomSheetDetailsModel("Salesman Code", whatsappStatusHeaderDataModel.getSalesmanCode()));
        infoBottomSheetDetailsModels.add(new WhatsappInfoBottomSheetDetailsModel("Salesman Name", whatsappStatusHeaderDataModel.getSalesmanName()));
        infoBottomSheetDetailsModels.add(new WhatsappInfoBottomSheetDetailsModel("Route Code", whatsappStatusHeaderDataModel.getRouteCode()));
        infoBottomSheetDetailsModels.add(new WhatsappInfoBottomSheetDetailsModel("Route Name", whatsappStatusHeaderDataModel.getRouteName()));
        infoDetailsList.setValue(infoBottomSheetDetailsModels);
    }

    private void getCustomerInfo(WhatsappStatusHeaderDataModel whatsappStatusHeaderDataModel) {
        List<WhatsappInfoBottomSheetDetailsModel> infoBottomSheetDetailsModels = new ArrayList<>();
        infoBottomSheetDetailsModels.add(new WhatsappInfoBottomSheetDetailsModel("Customer Code", whatsappStatusHeaderDataModel.getCustomerCode()));
        infoBottomSheetDetailsModels.add(new WhatsappInfoBottomSheetDetailsModel("Customer Name", whatsappStatusHeaderDataModel.getCustomerName()));
        infoBottomSheetDetailsModels.add(new WhatsappInfoBottomSheetDetailsModel("Mobile No", whatsappStatusHeaderDataModel.getMobileNo()));
        infoBottomSheetDetailsModels.add(new WhatsappInfoBottomSheetDetailsModel("Customer Ship Addr", whatsappStatusHeaderDataModel.getCustomerShipAddr()));
        infoDetailsList.setValue(infoBottomSheetDetailsModels);
    }

    private void getBillingInfo(WhatsappStatusHeaderDataModel whatsappStatusHeaderDataModel) {
        List<WhatsappInfoBottomSheetDetailsModel> infoBottomSheetDetailsModels = new ArrayList<>();
        infoBottomSheetDetailsModels.add(new WhatsappInfoBottomSheetDetailsModel("Total Net Amt", getValueWithSymbol(whatsappStatusHeaderDataModel.getTotGrossAmt().toString())));
        infoBottomSheetDetailsModels.add(new WhatsappInfoBottomSheetDetailsModel("Total Disc Amt", getValueWithSymbol(whatsappStatusHeaderDataModel.getTotSchDiscAmt().toString())));
        infoBottomSheetDetailsModels.add(new WhatsappInfoBottomSheetDetailsModel("Total Tax Amt", getValueWithSymbol(whatsappStatusHeaderDataModel.getTotTaxAmt().toString())));
        infoBottomSheetDetailsModels.add(new WhatsappInfoBottomSheetDetailsModel("Total Round Off Amt", getValueWithSymbol(whatsappStatusHeaderDataModel.getRoundOffAmt().toString())));
        infoBottomSheetDetailsModels.add(new WhatsappInfoBottomSheetDetailsModel("Total Net Amt", getValueWithSymbol(whatsappStatusHeaderDataModel.getTotNetAmt().toString())));
        infoBottomSheetDetailsModels.add(new WhatsappInfoBottomSheetDetailsModel("Total Cr Note Amt", getValueWithSymbol(whatsappStatusHeaderDataModel.getTotCrNoteAmt().toString())));
        infoBottomSheetDetailsModels.add(new WhatsappInfoBottomSheetDetailsModel("Total Net Payable Amt", getValueWithSymbol(whatsappStatusHeaderDataModel.getTotNetAmt().toString())));
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
