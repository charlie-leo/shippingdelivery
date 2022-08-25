package com.editor.shippingdelivery.main.whatsappdeliverystatus.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Observable;

public class BillPrintDetailList extends Observable implements Parcelable {


    private String totalInvoiceQty;

    protected BillPrintDetailList(Parcel in) {
        totalInvoiceQty = in.readString();
    }

    public static final Creator<BillPrintDetailList> CREATOR = new Creator<BillPrintDetailList>() {
        @Override
        public BillPrintDetailList createFromParcel(Parcel in) {
            return new BillPrintDetailList(in);
        }

        @Override
        public BillPrintDetailList[] newArray(int size) {
            return new BillPrintDetailList[size];
        }
    };

    public String getTotalInvoiceQty() {
        return totalInvoiceQty;
    }

    public void setTotalInvoiceQty(String totalInvoiceQty) {
        this.totalInvoiceQty = totalInvoiceQty;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(totalInvoiceQty);
    }
}
