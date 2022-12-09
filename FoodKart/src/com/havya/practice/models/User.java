package com.havya.practice.models;

import com.havya.practice.enums.Gender;

import java.util.ArrayList;
import java.util.List;

public class User {
    String name;
    String pinCode;

    Gender gender;

    String phoneNo;

    List<Order> orders = new ArrayList<>();

    public User(String name, String pinCode, Gender gender, String phoneNo) {
        this.name = name;
        this.pinCode = pinCode;
        this.gender = gender;
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", gender=" + gender +
                ", phoneNo='" + phoneNo + '\'' +
                ", orders=" + orders +
                '}';
    }
}
