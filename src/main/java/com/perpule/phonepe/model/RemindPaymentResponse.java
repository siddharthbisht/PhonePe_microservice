package com.perpule.phonepe.model;

public class RemindPaymentResponse {
    Boolean success;
    String code;

    public RemindPaymentResponse(Boolean success, String code) {
        this.success = success;
        this.code = code;
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
}
