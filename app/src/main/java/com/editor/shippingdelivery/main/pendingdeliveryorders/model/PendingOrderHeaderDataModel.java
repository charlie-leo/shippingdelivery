package com.editor.shippingdelivery.main.pendingdeliveryorders.model;

import java.util.List;

public class PendingOrderHeaderDataModel {
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
}
