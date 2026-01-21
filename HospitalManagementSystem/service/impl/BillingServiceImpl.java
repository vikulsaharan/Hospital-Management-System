package com.Hospitalmanagement.HospitalManagementSystem.service.impl;

import java.util.List;
import com.Hospitalmanagement.HospitalManagementSystem.dao.BillingDAO;
import com.Hospitalmanagement.HospitalManagementSystem.dao.impl.BillingDAOImpl;
import com.Hospitalmanagement.HospitalManagementSystem.model.Billing;
import com.Hospitalmanagement.HospitalManagementSystem.service.BillingService;

public class BillingServiceImpl implements BillingService {

    private BillingDAO billingDAO = new BillingDAOImpl();

    public boolean addBill(Billing bill) {
        return billingDAO.addBill(bill);
    }

    public Billing getBillById(int billId) {
        return billingDAO.getBillById(billId);
    }

    public List<Billing> getAllBills() {
        return billingDAO.getAllBills();
    }
}
