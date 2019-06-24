package com.perpule.phonepe.model;

public class RequestPaymentRequest {
    String merchantId = "M2306160483220675579140";
    String transactionId = "0";
    String merchantOrderId = "0";
    Integer amount = 100;
    String instrumentType = "MOBILE";
    String instrumentReference = "7397430279";
    String message = "collect for XXX order";
    String email = "amitxxx75@gmail.com";
    Integer expiresIn = 180;
    String storeId = "store1";
    String terminalId = "terminal1";
    String salt_key="8289e078-be0b-484d-ae60-052f117f8deb";
    String salt_index="1";

    public RequestPaymentRequest(String instrumentReference) {
        this.instrumentReference = instrumentReference;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public String getInstrumentReference() {
        return instrumentReference;
    }

    public String getMessage() {
        return message;
    }

    public String getEmail() {
        return email;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public String getStoreId() {
        return storeId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public String getSalt_key() {
        return salt_key;
    }

    public String getSalt_index() {
        return salt_index;
    }



}
