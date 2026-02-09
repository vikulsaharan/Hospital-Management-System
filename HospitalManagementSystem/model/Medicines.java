package com.Hospitalmanagement.HospitalManagementSystem.model;

import java.sql.Date;

public class Medicines { 

    private int medicineId;
    private String medicineName;
    private String company;
    private double price;
    private int quantity;
    private Date expiryDate;

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }


@Override
public String toString() {
    return "Medicine ID: " + medicineId +
           ", Name: " + medicineName +
           ", Company: " + company +
           ", Price: " + price +
           ", Quantity: " + quantity +
           ", Expiry: " + expiryDate;
}
}

