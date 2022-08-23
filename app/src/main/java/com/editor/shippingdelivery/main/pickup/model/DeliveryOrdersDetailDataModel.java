package com.editor.shippingdelivery.main.pickup.model;

import android.os.Parcel;
import android.os.Parcelable;

public class DeliveryOrdersDetailDataModel implements Parcelable {
    /**
     * distrCode.
     */
    private String distrCode;
    /**
     * invoiceNo.
     */
    private String invoiceNo;
    /**
     * prodCode.
     */
    private String prodCode;
    /**
     * hsnCode.
     */
    private String hsnCode;
    /**
     * prodShortName.
     */
    private String prodShortName;
    /**
     * prodName.
     */
    private String prodName;
    /**
     * prodBatchCode.
     */
    private String prodBatchCode;
    /**
     * totalInvoiceQty.
     */
    private Integer totalInvoiceQty;

    /**
     * invoiceQty1.
     */
    private Integer invoiceQty1;

    /**
     * uomCode1.
     */
    private String uomCode1;

    /**
     * inputStr.
     */
    private String inputStr;

    /**
     * freeQty.
     */
    private Integer freeQty;

    /**
     * mrp.
     */
    private Double mrp;

    /**
     * sellRate.
     */
    private Double sellRate;

    /**
     * actualSellRate.
     */
    private Double actualSellRate;

    /**
     * cashDiscAmt.
     */
    private Double cashDiscAmt;

    /**
     * dbDiscAmt.
     */
    private Double dbDiscAmt;

    /**
     * schDiscAmt.
     */
    private Double schDiscAmt;

    /**
     * grossAmt.
     */
    private Double grossAmt;

    /**
     * taxAmt.
     */
    private Double taxAmt;

    /**
     * cgstPerc.
     */
    private Double cgstPerc;

    /**
     * cgstAmt.
     */
    private Double cgstAmt;

    /**
     * sgstPerc.
     */
    private Double sgstPerc;

    /**
     * sgstAmt.
     */
    private Double sgstAmt;

    /**
     * utgstPerc.
     */
    private Double utgstPerc;

    /**
     * utgstAmt.
     */
    private Double utgstAmt;

    /**
     * igstPerc.
     */
    private Double igstPerc;

    /**
     * igstAmt.
     */
    private Double igstAmt;

    /**
     * cessPerc.
     */
    private Double cessPerc;

    /**
     * cessAmt.
     */
    private Double cessAmt;

    /**
     * netAmt.
     */
    private Double netAmt;

    protected DeliveryOrdersDetailDataModel(Parcel in) {
        distrCode = in.readString();
        invoiceNo = in.readString();
        prodCode = in.readString();
        hsnCode = in.readString();
        prodShortName = in.readString();
        prodName = in.readString();
        prodBatchCode = in.readString();
        if (in.readByte() == 0) {
            totalInvoiceQty = null;
        } else {
            totalInvoiceQty = in.readInt();
        }
        if (in.readByte() == 0) {
            invoiceQty1 = null;
        } else {
            invoiceQty1 = in.readInt();
        }
        uomCode1 = in.readString();
        inputStr = in.readString();
        if (in.readByte() == 0) {
            freeQty = null;
        } else {
            freeQty = in.readInt();
        }
        if (in.readByte() == 0) {
            mrp = null;
        } else {
            mrp = in.readDouble();
        }
        if (in.readByte() == 0) {
            sellRate = null;
        } else {
            sellRate = in.readDouble();
        }
        if (in.readByte() == 0) {
            actualSellRate = null;
        } else {
            actualSellRate = in.readDouble();
        }
        if (in.readByte() == 0) {
            cashDiscAmt = null;
        } else {
            cashDiscAmt = in.readDouble();
        }
        if (in.readByte() == 0) {
            dbDiscAmt = null;
        } else {
            dbDiscAmt = in.readDouble();
        }
        if (in.readByte() == 0) {
            schDiscAmt = null;
        } else {
            schDiscAmt = in.readDouble();
        }
        if (in.readByte() == 0) {
            grossAmt = null;
        } else {
            grossAmt = in.readDouble();
        }
        if (in.readByte() == 0) {
            taxAmt = null;
        } else {
            taxAmt = in.readDouble();
        }
        if (in.readByte() == 0) {
            cgstPerc = null;
        } else {
            cgstPerc = in.readDouble();
        }
        if (in.readByte() == 0) {
            cgstAmt = null;
        } else {
            cgstAmt = in.readDouble();
        }
        if (in.readByte() == 0) {
            sgstPerc = null;
        } else {
            sgstPerc = in.readDouble();
        }
        if (in.readByte() == 0) {
            sgstAmt = null;
        } else {
            sgstAmt = in.readDouble();
        }
        if (in.readByte() == 0) {
            utgstPerc = null;
        } else {
            utgstPerc = in.readDouble();
        }
        if (in.readByte() == 0) {
            utgstAmt = null;
        } else {
            utgstAmt = in.readDouble();
        }
        if (in.readByte() == 0) {
            igstPerc = null;
        } else {
            igstPerc = in.readDouble();
        }
        if (in.readByte() == 0) {
            igstAmt = null;
        } else {
            igstAmt = in.readDouble();
        }
        if (in.readByte() == 0) {
            cessPerc = null;
        } else {
            cessPerc = in.readDouble();
        }
        if (in.readByte() == 0) {
            cessAmt = null;
        } else {
            cessAmt = in.readDouble();
        }
        if (in.readByte() == 0) {
            netAmt = null;
        } else {
            netAmt = in.readDouble();
        }
    }

    public static final Creator<DeliveryOrdersDetailDataModel> CREATOR = new Creator<DeliveryOrdersDetailDataModel>() {
        @Override
        public DeliveryOrdersDetailDataModel createFromParcel(Parcel in) {
            return new DeliveryOrdersDetailDataModel(in);
        }

        @Override
        public DeliveryOrdersDetailDataModel[] newArray(int size) {
            return new DeliveryOrdersDetailDataModel[size];
        }
    };

    public String getDistrCode() {
        return distrCode;
    }

    public void setDistrCode(String distrCode) {
        this.distrCode = distrCode;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    public String getHsnCode() {
        return hsnCode;
    }

    public void setHsnCode(String hsnCode) {
        this.hsnCode = hsnCode;
    }

    public String getProdShortName() {
        return prodShortName;
    }

    public void setProdShortName(String prodShortName) {
        this.prodShortName = prodShortName;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdBatchCode() {
        return prodBatchCode;
    }

    public void setProdBatchCode(String prodBatchCode) {
        this.prodBatchCode = prodBatchCode;
    }

    public Integer getTotalInvoiceQty() {
        return totalInvoiceQty;
    }

    public void setTotalInvoiceQty(Integer totalInvoiceQty) {
        this.totalInvoiceQty = totalInvoiceQty;
    }

    public Integer getInvoiceQty1() {
        return invoiceQty1;
    }

    public void setInvoiceQty1(Integer invoiceQty1) {
        this.invoiceQty1 = invoiceQty1;
    }

    public String getUomCode1() {
        return uomCode1;
    }

    public void setUomCode1(String uomCode1) {
        this.uomCode1 = uomCode1;
    }

    public String getInputStr() {
        return inputStr;
    }

    public void setInputStr(String inputStr) {
        this.inputStr = inputStr;
    }

    public Integer getFreeQty() {
        return freeQty;
    }

    public void setFreeQty(Integer freeQty) {
        this.freeQty = freeQty;
    }

    public Double getMrp() {
        return mrp;
    }

    public void setMrp(Double mrp) {
        this.mrp = mrp;
    }

    public Double getSellRate() {
        return sellRate;
    }

    public void setSellRate(Double sellRate) {
        this.sellRate = sellRate;
    }

    public Double getActualSellRate() {
        return actualSellRate;
    }

    public void setActualSellRate(Double actualSellRate) {
        this.actualSellRate = actualSellRate;
    }

    public Double getCashDiscAmt() {
        return cashDiscAmt;
    }

    public void setCashDiscAmt(Double cashDiscAmt) {
        this.cashDiscAmt = cashDiscAmt;
    }

    public Double getDbDiscAmt() {
        return dbDiscAmt;
    }

    public void setDbDiscAmt(Double dbDiscAmt) {
        this.dbDiscAmt = dbDiscAmt;
    }

    public Double getSchDiscAmt() {
        return schDiscAmt;
    }

    public void setSchDiscAmt(Double schDiscAmt) {
        this.schDiscAmt = schDiscAmt;
    }

    public Double getGrossAmt() {
        return grossAmt;
    }

    public void setGrossAmt(Double grossAmt) {
        this.grossAmt = grossAmt;
    }

    public Double getTaxAmt() {
        return taxAmt;
    }

    public void setTaxAmt(Double taxAmt) {
        this.taxAmt = taxAmt;
    }

    public Double getCgstPerc() {
        return cgstPerc;
    }

    public void setCgstPerc(Double cgstPerc) {
        this.cgstPerc = cgstPerc;
    }

    public Double getCgstAmt() {
        return cgstAmt;
    }

    public void setCgstAmt(Double cgstAmt) {
        this.cgstAmt = cgstAmt;
    }

    public Double getSgstPerc() {
        return sgstPerc;
    }

    public void setSgstPerc(Double sgstPerc) {
        this.sgstPerc = sgstPerc;
    }

    public Double getSgstAmt() {
        return sgstAmt;
    }

    public void setSgstAmt(Double sgstAmt) {
        this.sgstAmt = sgstAmt;
    }

    public Double getUtgstPerc() {
        return utgstPerc;
    }

    public void setUtgstPerc(Double utgstPerc) {
        this.utgstPerc = utgstPerc;
    }

    public Double getUtgstAmt() {
        return utgstAmt;
    }

    public void setUtgstAmt(Double utgstAmt) {
        this.utgstAmt = utgstAmt;
    }

    public Double getIgstPerc() {
        return igstPerc;
    }

    public void setIgstPerc(Double igstPerc) {
        this.igstPerc = igstPerc;
    }

    public Double getIgstAmt() {
        return igstAmt;
    }

    public void setIgstAmt(Double igstAmt) {
        this.igstAmt = igstAmt;
    }

    public Double getCessPerc() {
        return cessPerc;
    }

    public void setCessPerc(Double cessPerc) {
        this.cessPerc = cessPerc;
    }

    public Double getCessAmt() {
        return cessAmt;
    }

    public void setCessAmt(Double cessAmt) {
        this.cessAmt = cessAmt;
    }

    public Double getNetAmt() {
        return netAmt;
    }

    public void setNetAmt(Double netAmt) {
        this.netAmt = netAmt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(distrCode);
        parcel.writeString(invoiceNo);
        parcel.writeString(prodCode);
        parcel.writeString(hsnCode);
        parcel.writeString(prodShortName);
        parcel.writeString(prodName);
        parcel.writeString(prodBatchCode);
        if (totalInvoiceQty == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(totalInvoiceQty);
        }
        if (invoiceQty1 == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(invoiceQty1);
        }
        parcel.writeString(uomCode1);
        parcel.writeString(inputStr);
        if (freeQty == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(freeQty);
        }
        if (mrp == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(mrp);
        }
        if (sellRate == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(sellRate);
        }
        if (actualSellRate == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(actualSellRate);
        }
        if (cashDiscAmt == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(cashDiscAmt);
        }
        if (dbDiscAmt == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(dbDiscAmt);
        }
        if (schDiscAmt == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(schDiscAmt);
        }
        if (grossAmt == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(grossAmt);
        }
        if (taxAmt == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(taxAmt);
        }
        if (cgstPerc == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(cgstPerc);
        }
        if (cgstAmt == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(cgstAmt);
        }
        if (sgstPerc == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(sgstPerc);
        }
        if (sgstAmt == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(sgstAmt);
        }
        if (utgstPerc == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(utgstPerc);
        }
        if (utgstAmt == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(utgstAmt);
        }
        if (igstPerc == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(igstPerc);
        }
        if (igstAmt == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(igstAmt);
        }
        if (cessPerc == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(cessPerc);
        }
        if (cessAmt == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(cessAmt);
        }
        if (netAmt == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(netAmt);
        }
    }
}
