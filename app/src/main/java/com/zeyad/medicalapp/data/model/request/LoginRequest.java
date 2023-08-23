package com.zeyad.medicalapp.data.model.request;

public class LoginRequest {
    private String email;
    private String password;
    private String device_token = "";

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public LoginRequest(String email, String password, String device_token) {
        this.email = email;
        this.password = password;
        this.device_token = device_token;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDevice_token() {
        return device_token;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
