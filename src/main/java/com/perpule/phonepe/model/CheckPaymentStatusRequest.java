package com.perpule.phonepe.model;

public class CheckPaymentStatusRequest {
    String merchantId = "M2306160483220675579140";
    String transactionId = "0";
    String salt_key="8289e078-be0b-484d-ae60-052f117f8deb";
    String salt_index="1";

    public CheckPaymentStatusRequest(String merchantId, String transactionId, String salt_key, String salt_index) {
        this.merchantId = merchantId;
        this.transactionId = transactionId;
        this.salt_key = salt_key;
        this.salt_index = salt_index;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getSalt_key() {
        return salt_key;
    }

    public void setSalt_key(String salt_key) {
        this.salt_key = salt_key;
    }

    public String getSalt_index() {
        return salt_index;
    }

    public void setSalt_index(String salt_index) {
        this.salt_index = salt_index;
    }
}
