package com.example.accesskeybackend.template.dto;

public class CheckUrlResponse {
    private boolean success;

    public CheckUrlResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
