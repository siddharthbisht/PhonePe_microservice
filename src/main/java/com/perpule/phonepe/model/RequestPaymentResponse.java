package com.perpule.phonepe.model;

public class RequestPaymentResponse {
    Data data;

    Boolean success;
    String code;
    String message;

    public RequestPaymentResponse(Data data, Boolean success, String code, String message) {
        this.data = data;
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public class Data{
        String transactionId;
        Integer amount;
        String merchantId;
        String mobileNumber;
        String providerReferenceId;

        public Data(String transactionId, Integer amount, String merchantId, String mobileNumber, String providerReferenceId) {
            this.transactionId = transactionId;
            this.amount = amount;
            this.merchantId = merchantId;
            this.mobileNumber = mobileNumber;
            this.providerReferenceId = providerReferenceId;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(String transactionId) {
            this.transactionId = transactionId;
        }

        public Integer getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }

        public String getMerchantId() {
            return merchantId;
        }

        public void setMerchantId(String merchantId) {
            this.merchantId = merchantId;
        }

        public String getMobileNumber() {
            return mobileNumber;
        }

        public void setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
        }

        public String getProviderReferenceId() {
            return providerReferenceId;
        }

        public void setProviderReferenceId(String providerReferenceId) {
            this.providerReferenceId = providerReferenceId;
        }
    }

}
