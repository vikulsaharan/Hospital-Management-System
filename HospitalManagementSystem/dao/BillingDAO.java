package com.Hospitalmanagement.HospitalManagementSystem.dao;

import java.util.List;
import com.Hospitalmanagement.HospitalManagementSystem.model.Billing;

public interface BillingDAO {

    boolean addBill(Billing bill);

    Billing getBillById(int billId);

    List<Billing> getAllBills();
}
