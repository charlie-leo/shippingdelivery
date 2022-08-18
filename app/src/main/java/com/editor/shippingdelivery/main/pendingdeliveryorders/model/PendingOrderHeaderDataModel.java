package com.editor.shippingdelivery.main.pendingdeliveryorders.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.editor.shippingdelivery.BR;

import java.util.List;

public class PendingOrderHeaderDataModel extends BaseObservable implements Parcelable
{


    /** distrCode. */
    private String distrCode;

    /** invoiceNo. */
    private String invoiceNo;

    /** invoiceDt. */
    private String invoiceDt;

    /** salesmanCode. */
    private String salesmanCode;

    /** salesmanName. */
    private String salesmanName;

    /** routeCode. */
    private String routeCode;

    /** routeName. */
    private String routeName;

    /** customerCode. */
    private String customerCode;

    /** customerName. */
    private String customerName;

    /** mobileNo. */
    private String mobileNo;

    /** fssaiNo. */
    private String fssaiNo;

    /** gstTinNo. */
    private String gstTinNo;

    /** customerShipAddr. */
    private String customerShipAddr;

    /** totGrossAmt. */
    private Double totGrossAmt;

    /** totCashDiscAmt. */
    private Double totCashDiscAmt;

    /** totDBDiscAmt. */
    private Double totDBDiscAmt;

    /** totSchDiscAmt. */
    private Double totSchDiscAmt;

    /** totTaxAmt. */
    private Double totTaxAmt;

    /** totNetAmt. */
    private Double totNetAmt;

    /** roundOffAmt. */
    private Double roundOffAmt;

    /** totCrNoteAmt. */
    private Double totCrNoteAmt;

    /** remarks. */
    private String remarks;

    /** liquidation. */
    private String liquidation;

    /** billDetailsEntityList. */
    private List<PendingOrderDetailDataModel> pendingOrderDetailDataModelList;

    protected PendingOrderHeaderDataModel(Parcel in) {
        distrCode = in.readString();
        invoiceNo = in.readString();
        invoiceDt = in.readString();
        salesmanCode = in.readString();
        salesmanName = in.readString();
        routeCode = in.readString();
        routeName = in.readString();
        customerCode = in.readString();
        customerName = in.readString();
        mobileNo = in.readString();
        fssaiNo = in.readString();
        gstTinNo = in.readString();
        customerShipAddr = in.readString();
        if (in.readByte() == 0) {
            totGrossAmt = null;
        } else {
            totGrossAmt = in.readDouble();
        }
        if (in.readByte() == 0) {
            totCashDiscAmt = null;
        } else {
            totCashDiscAmt = in.readDouble();
        }
        if (in.readByte() == 0) {
            totDBDiscAmt = null;
        } else {
            totDBDiscAmt = in.readDouble();
        }
        if (in.readByte() == 0) {
            totSchDiscAmt = null;
        } else {
            totSchDiscAmt = in.readDouble();
        }
        if (in.readByte() == 0) {
            totTaxAmt = null;
        } else {
            totTaxAmt = in.readDouble();
        }
        if (in.readByte() == 0) {
            totNetAmt = null;
        } else {
            totNetAmt = in.readDouble();
        }
        if (in.readByte() == 0) {
            roundOffAmt = null;
        } else {
            roundOffAmt = in.readDouble();
        }
        if (in.readByte() == 0) {
            totCrNoteAmt = null;
        } else {
            totCrNoteAmt = in.readDouble();
        }
        remarks = in.readString();
        liquidation = in.readString();
    }

    public static final Creator<PendingOrderHeaderDataModel> CREATOR = new Creator<PendingOrderHeaderDataModel>() {
        @Override
        public PendingOrderHeaderDataModel createFromParcel(Parcel in) {
            return new PendingOrderHeaderDataModel(in);
        }

        @Override
        public PendingOrderHeaderDataModel[] newArray(int size) {
            return new PendingOrderHeaderDataModel[size];
        }
    };

    @Bindable
    public String getDistrCode() {
        return distrCode;
    }

    public void setDistrCode(String distrCode) {
        this.distrCode = distrCode;
        notifyPropertyChanged(BR.distrCode);
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getInvoiceDt() {
        return invoiceDt;
    }

    public void setInvoiceDt(String invoiceDt) {
        this.invoiceDt = invoiceDt;
    }

    public String getSalesmanCode() {
        return salesmanCode;
    }

    public void setSalesmanCode(String salesmanCode) {
        this.salesmanCode = salesmanCode;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getFssaiNo() {
        return fssaiNo;
    }

    public void setFssaiNo(String fssaiNo) {
        this.fssaiNo = fssaiNo;
    }

    public String getGstTinNo() {
        return gstTinNo;
    }

    public void setGstTinNo(String gstTinNo) {
        this.gstTinNo = gstTinNo;
    }

    public String getCustomerShipAddr() {
        return customerShipAddr;
    }

    public void setCustomerShipAddr(String customerShipAddr) {
        this.customerShipAddr = customerShipAddr;
    }

    public Double getTotGrossAmt() {
        return totGrossAmt;
    }

    public void setTotGrossAmt(Double totGrossAmt) {
        this.totGrossAmt = totGrossAmt;
    }

    public Double getTotCashDiscAmt() {
        return totCashDiscAmt;
    }

    public void setTotCashDiscAmt(Double totCashDiscAmt) {
        this.totCashDiscAmt = totCashDiscAmt;
    }

    public Double getTotDBDiscAmt() {
        return totDBDiscAmt;
    }

    public void setTotDBDiscAmt(Double totDBDiscAmt) {
        this.totDBDiscAmt = totDBDiscAmt;
    }

    public Double getTotSchDiscAmt() {
        return totSchDiscAmt;
    }

    public void setTotSchDiscAmt(Double totSchDiscAmt) {
        this.totSchDiscAmt = totSchDiscAmt;
    }

    public Double getTotTaxAmt() {
        return totTaxAmt;
    }

    public void setTotTaxAmt(Double totTaxAmt) {
        this.totTaxAmt = totTaxAmt;
    }

    public Double getTotNetAmt() {
        return totNetAmt;
    }

    public void setTotNetAmt(Double totNetAmt) {
        this.totNetAmt = totNetAmt;
    }

    public Double getRoundOffAmt() {
        return roundOffAmt;
    }

    public void setRoundOffAmt(Double roundOffAmt) {
        this.roundOffAmt = roundOffAmt;
    }

    public Double getTotCrNoteAmt() {
        return totCrNoteAmt;
    }

    public void setTotCrNoteAmt(Double totCrNoteAmt) {
        this.totCrNoteAmt = totCrNoteAmt;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getLiquidation() {
        return liquidation;
    }

    public void setLiquidation(String liquidation) {
        this.liquidation = liquidation;
    }

    public List<PendingOrderDetailDataModel> getPendingOrderDetailDataModelList() {
        return pendingOrderDetailDataModelList;
    }

    public void setPendingOrderDetailDataModelList(List<PendingOrderDetailDataModel> pendingOrderDetailDataModelList) {
        this.pendingOrderDetailDataModelList = pendingOrderDetailDataModelList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(distrCode);
        parcel.writeString(invoiceNo);
        parcel.writeString(invoiceDt);
        parcel.writeString(salesmanCode);
        parcel.writeString(salesmanName);
        parcel.writeString(routeCode);
        parcel.writeString(routeName);
        parcel.writeString(customerCode);
        parcel.writeString(customerName);
        parcel.writeString(mobileNo);
        parcel.writeString(fssaiNo);
        parcel.writeString(gstTinNo);
        parcel.writeString(customerShipAddr);
        if (totGrossAmt == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(totGrossAmt);
        }
        if (totCashDiscAmt == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(totCashDiscAmt);
        }
        if (totDBDiscAmt == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(totDBDiscAmt);
        }
        if (totSchDiscAmt == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(totSchDiscAmt);
        }
        if (totTaxAmt == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(totTaxAmt);
        }
        if (totNetAmt == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(totNetAmt);
        }
        if (roundOffAmt == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(roundOffAmt);
        }
        if (totCrNoteAmt == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(totCrNoteAmt);
        }
        parcel.writeString(remarks);
        parcel.writeString(liquidation);
    }
}
