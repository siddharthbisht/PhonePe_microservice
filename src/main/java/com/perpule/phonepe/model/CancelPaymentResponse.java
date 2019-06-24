package com.perpule.phonepe.model;

public class CancelPaymentResponse {
    Data data;

    Boolean success;
    String code;
    String message;

    public CancelPaymentResponse(Data data, Boolean success, String code, String message) {
        this.data = data;
        this.success = success;
        this.code = code;
        this.message = message;
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

    public class Data{}

}




