package com.perpule.phonepe.model;

public class CheckPaymentStatusResponse {
    Data data;

    Boolean success;
    String code;
    String message;

    public CheckPaymentStatusResponse(Data data, Boolean success, String code, String message) {
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
        String providerReferenceId;
        String paymentState;
        String payResponseCode;

        public Data(String transactionId, Integer amount, String merchantId, String providerReferenceId, String paymentState, String payResponseCode) {
            this.transactionId = transactionId;
            this.amount = amount;
            this.merchantId = merchantId;
            this.providerReferenceId = providerReferenceId;
            this.paymentState = paymentState;
            this.payResponseCode = payResponseCode;
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


        public String getProviderReferenceId() {
            return providerReferenceId;
        }

        public void setProviderReferenceId(String providerReferenceId) {
            this.providerReferenceId = providerReferenceId;
        }

        public String getPaymentState() {
            return paymentState;
        }

        public void setPaymentState(String paymentState) {
            this.paymentState = paymentState;
        }

        public String getPayResponseCode() {
            return payResponseCode;
        }

        public void setPayResponseCode(String payResponseCode) {
            this.payResponseCode = payResponseCode;
        }
    }

}


