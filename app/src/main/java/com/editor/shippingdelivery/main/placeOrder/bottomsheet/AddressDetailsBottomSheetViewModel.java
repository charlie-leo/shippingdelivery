package com.editor.shippingdelivery.main.placeOrder.bottomsheet;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.editor.shippingdelivery.R;
import com.editor.shippingdelivery.utils.topsnackbar.TSnackbar;

public class AddressDetailsBottomSheetViewModel extends AndroidViewModel {
    private static Context application;
    public MutableLiveData<String> bottomSheetHeader = new MutableLiveData<>("Header");

    public MutableLiveData<String> customerName = new MutableLiveData<>("Test");
    public MutableLiveData<String> customerLastName = new MutableLiveData<>("One");

    private MutableLiveData<String> errorMsg = new MutableLiveData<>("");

    public AddressDetailsBottomSheetViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
    }

    public void setBottomSheetHeader(String viewName) {
        bottomSheetHeader.setValue(viewName);
    }

    public MutableLiveData<String> getErrorMsg() {
        return errorMsg;
    }

    public void validate(View view) {
        if (customerName.getValue().equalsIgnoreCase("")) {
            errorMsg.setValue("Kindly enter customer name");
        } else if (customerLastName.getValue().equalsIgnoreCase("")) {
            errorMsg.setValue("Kindly enter customer last name");
        }
    }

    public void setErrorEt(ConstraintLayout layout, String errorMessage) {
        if (!errorMessage.equalsIgnoreCase("")) {
//            Toast.makeText(application.getApplicationContext(), errorMessage, Toast.LENGTH_SHORT).show();
            TSnackbar snackbar = TSnackbar.make(layout, errorMessage, TSnackbar.LENGTH_SHORT);
            View snackbarView = snackbar.getView();
            snackbarView.setBackgroundColor(ContextCompat.getColor(layout.getContext(), R.color.primary_color));
            TextView textView = (TextView) snackbarView.findViewById(R.id.snackbar_text);
            textView.setTextColor(Color.WHITE);
            snackbar.show();
        }
    }

}
