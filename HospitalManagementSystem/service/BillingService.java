package com.Hospitalmanagement.HospitalManagementSystem.service;

import java.util.List;
import com.Hospitalmanagement.HospitalManagementSystem.model.Billing;

public interface BillingService {

    boolean addBill(Billing bill);

    Billing getBillById(int billId);

    List<Billing> getAllBills();

    boolean deleteBill(int billId);   // ✅ ye line MUST honi chahiye
}
