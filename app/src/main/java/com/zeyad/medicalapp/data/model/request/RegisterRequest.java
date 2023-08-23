package com.zeyad.medicalapp.data.model.request;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RegisterRequest {

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("gender")
    private String gender;

    @SerializedName("specialist")
    private String specialist;

    @SerializedName("birthday")
    private String birthday;

    @SerializedName("status")
    private String status;

    @SerializedName("mobile")
    private String mobile;

    @SerializedName("email")
    private String email;

    @SerializedName("address")
    private String address;

    @SerializedName("password")
    private String password;

    @SerializedName("type")
    private String type;


    public RegisterRequest(String firstName, String lastName, String gender
            , String specialist, String birthday, String status
            , String mobile, String email, String address, String password
            , String type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.specialist = specialist;
        this.birthday = birthday;
        this.status = status;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.password = password;
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getSpecialist() {
        return specialist;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getStatus() {
        return status;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }
}
