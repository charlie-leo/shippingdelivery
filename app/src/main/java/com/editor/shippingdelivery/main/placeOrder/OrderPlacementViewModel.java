package com.editor.shippingdelivery.main.placeOrder;

import android.app.Activity;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;

import com.editor.shippingdelivery.BR;
import com.editor.shippingdelivery.R;
import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingOrderDetailDataModel;
import com.editor.shippingdelivery.main.pendingdeliveryorders.model.PendingOrderHeaderDataModel;
import com.editor.shippingdelivery.main.placeOrder.model.CreateOrderRequest;
import com.editor.shippingdelivery.main.placeOrder.model.OrderItemsItem;
import com.editor.shippingdelivery.utils.topsnackbar.TSnackbar;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputLayout;

/**
 * Created by Charles Raj I on 18/08/22.
 *
 * @author Charles Raj I
 */
public class OrderPlacementViewModel extends BaseObservable {

    private Activity activity;
    private FragmentManager fragmentManager;
    private PendingOrderHeaderDataModel orderData;
    private CreateOrderRequest createOrderRequest;
    private OrderPlacementRepo orderPlacementRepo;
    private String errorMessage = "";

    public void setActivity(Activity activity) {
        this.activity = activity;
        orderPlacementRepo = new OrderPlacementRepo();
    }

    @Bindable
    public FragmentManager getFragmentManager() {
        return fragmentManager;
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
        notifyPropertyChanged(BR.fragmentManager);
    }

    @Bindable
    public PendingOrderHeaderDataModel getOrderData() {
        return orderData;
    }

    public void setOrderData(PendingOrderHeaderDataModel orderData) {
        this.orderData = orderData;
        setPendingDeliveryToCreateOrder(orderData);
        notifyPropertyChanged(BR.orderData);
    }

    @Bindable
    public CreateOrderRequest getCreateOrderRequest() {
        return createOrderRequest;
    }

    public void setCreateOrderRequest(CreateOrderRequest createOrderRequest) {
        this.createOrderRequest = createOrderRequest;
        notifyPropertyChanged(BR.createOrderRequest);
    }

    @Bindable
    public OrderPlacementRepo getOrderPlacementViewModel() {
        return orderPlacementRepo;
    }

    public void setOrderPlacementViewModel(OrderPlacementRepo orderPlacementRepo) {
        this.orderPlacementRepo = orderPlacementRepo;
        notifyPropertyChanged(BR.orderPlacementViewModel);
    }

    public void setPendingDeliveryToCreateOrder(PendingOrderHeaderDataModel orderData) {
        if (orderData != null) {
            createOrderRequest.setOrderId(orderData.getInvoiceNo());
            createOrderRequest.setSubTotal(orderData.getTotNetAmt());
            createOrderRequest.setShippingCustomerName(orderData.getCustomerName());
            createOrderRequest.setShippingPhone(orderData.getMobileNo());

            if (!orderData.getPendingOrderDetailDataModelList().isEmpty()) {
                for (PendingOrderDetailDataModel item : orderData.getPendingOrderDetailDataModelList()) {
                    OrderItemsItem orderItemsItem = new OrderItemsItem();
                    orderItemsItem.setName(item.getProdName());
                    orderItemsItem.setSellingPrice(String.valueOf(item.getSellRate()));
                    orderItemsItem.setUnits(item.getTotalInvoiceQty());
                    orderItemsItem.setTax(String.valueOf(item.getTaxAmt()));
                    orderItemsItem.setDiscount("0");
                    orderItemsItem.setSku(item.getProdCode());
                    createOrderRequest.getOrderItems().add(orderItemsItem);
                }
            }
        }
        notifyPropertyChanged(BR.createOrderRequest);
    }

    @Bindable
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        notifyPropertyChanged(BR.errorMessage);
    }

    public void selectStartDate(View view) {
        MaterialDatePicker.Builder materialDateBuilder = MaterialDatePicker.Builder.datePicker();
        materialDateBuilder.setTitleText("SELECT A DATE");
        final MaterialDatePicker materialDatePicker = materialDateBuilder.build();
        materialDatePicker.show(fragmentManager, "MATERIAL_DATE_PICKER");
        materialDatePicker.addOnPositiveButtonClickListener(
                selection -> {
                    createOrderRequest.setOrderDate(materialDatePicker.getHeaderText());
                    ((TextView) view).setText(materialDatePicker.getHeaderText());
                });
    }

    public void placeOrder(View view) {
        if (validateOrder()) {
            orderPlacementRepo.createShippingOrder(view.getContext(), createOrderRequest, this);
        }
    }

    public boolean validateOrder() {
        if (createOrderRequest.getBillingCustomerName().equalsIgnoreCase("")) {
            setErrorMessage("Kindly Enter Billing Name");
            return false;
        } else if (createOrderRequest.getBillingLastName().equalsIgnoreCase("")) {
            setErrorMessage("Kindly Enter Last Name");
            return false;
        } else if (createOrderRequest.getBillingAddress().equalsIgnoreCase("")) {
            setErrorMessage("Kindly Enter Billing Address");
            return false;
        } else if (createOrderRequest.getBillingAddress2().equalsIgnoreCase("")) {
            setErrorMessage("Kindly Enter Billing Address 2");
            return false;
        } else if (createOrderRequest.getBillingCity().equalsIgnoreCase("")) {
            setErrorMessage("Kindly Enter Billing city");
            return false;
        } else if (createOrderRequest.getBillingState().equalsIgnoreCase("")) {
            setErrorMessage("Kindly Enter Billing State");
            return false;
        } else if (createOrderRequest.getBillingCountry().equalsIgnoreCase("")) {
            setErrorMessage("Kindly Enter Billing Country");
            return false;
        } else if (createOrderRequest.getBillingPincode().equalsIgnoreCase("")) {
            setErrorMessage("Kindly Enter Billing Pin Code");
            return false;
        } else if (createOrderRequest.getBillingEmail().equalsIgnoreCase("")) {
            setErrorMessage("Kindly Enter Billing Email");
            return false;
        } else if (createOrderRequest.getBillingPhone().equalsIgnoreCase("")) {
            setErrorMessage("Kindly Enter Billing Phone");
            return false;
        } else if (createOrderRequest.getShippingCustomerName().equalsIgnoreCase("")) {
            setErrorMessage("Kindly Enter Shipping Name");
            return false;
        } else if (createOrderRequest.getShippingLastName().equalsIgnoreCase("")) {
            setErrorMessage("Kindly Enter Last Name");
            return false;
        } else if (createOrderRequest.getShippingAddress().equalsIgnoreCase("")) {
            setErrorMessage("Kindly Enter Shipping Address");
            return false;
        } else if (createOrderRequest.getShippingAddress2().equalsIgnoreCase("")) {
            setErrorMessage("Kindly Enter Shipping Address 2");
            return false;
        } else if (createOrderRequest.getShippingCity().equalsIgnoreCase("")) {
            setErrorMessage("Kindly Enter Shipping city");
            return false;
        } else if (createOrderRequest.getShippingState().equalsIgnoreCase("")) {
            setErrorMessage("Kindly Enter Shipping State");
            return false;
        } else if (createOrderRequest.getShippingCountry().equalsIgnoreCase("")) {
            setErrorMessage("Kindly Enter Shipping Country");
            return false;
        } else if (createOrderRequest.getShippingPincode().equalsIgnoreCase("")) {
            setErrorMessage("Kindly Enter Shipping Pin Code");
            return false;
        } else if (createOrderRequest.getShippingEmail().equalsIgnoreCase("")) {
            setErrorMessage("Kindly Enter Shipping Email");
            return false;
        } else if (createOrderRequest.getShippingPhone().equalsIgnoreCase("")) {
            setErrorMessage("Kindly Enter Shipping Phone");
            return false;
        } else if (createOrderRequest.getLength() <= 0.5
                && createOrderRequest.getBreadth() <= 0.5
                && createOrderRequest.getHeight() <= 0.5
                && createOrderRequest.getWeight() <= 0.5
        ) {
            setErrorMessage("Package length, breath, height, weight must be equal or greater than 0.5.");
            return false;
        } else if (TextUtils.isEmpty(createOrderRequest.getOrderDate())){
            setErrorMessage("Order Date Mandatory");
            return false;
        } else if (createOrderRequest.getBillingPhone().length() != 10 && createOrderRequest.getShippingPhone().length() != 10){
            setErrorMessage("Billing Or Shipment Phone Number is not Valid !!");
            return false;
        }
        return true;
    }

    @BindingAdapter("error_et")
    public static void setErrorEditText(TextInputLayout textInputLayout, String errorMessage) {
        if (textInputLayout != null) {
            textInputLayout.setError(errorMessage);
        }

    }

    @BindingAdapter("snack_bar_error")
    public static void setErrorEditText(ConstraintLayout layout, String errorMessage) {
        if (!errorMessage.equalsIgnoreCase("")) {
            TSnackbar snackbar = TSnackbar.make(layout, errorMessage, TSnackbar.LENGTH_SHORT);
            View snackbarView = snackbar.getView();
            snackbarView.setBackgroundColor(ContextCompat.getColor(layout.getContext(), R.color.primary_color));
            TextView textView = (TextView) snackbarView.findViewById(R.id.snackbar_text);
            textView.setTextColor(Color.WHITE);
            snackbar.show();
        }
    }
}
