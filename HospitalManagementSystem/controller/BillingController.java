package com.Hospitalmanagement.HospitalManagementSystem.controller;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.Hospitalmanagement.HospitalManagementSystem.model.Billing;
import com.Hospitalmanagement.HospitalManagementSystem.service.BillingService;
import com.Hospitalmanagement.HospitalManagementSystem.service.impl.BillingServiceImpl;

public class BillingController {

    private BillingService billingService = new BillingServiceImpl();
    private Scanner sc = new Scanner(System.in);

    public void billingMenu() {
        int choice;

        do {
            System.out.println("\n====== BILLING MENU ======");
            System.out.println("1. Add Bill");
            System.out.println("2. View Bill By ID");
            System.out.println("3. View All Bills");
            System.out.println("0. Exit Billing");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addBill();
                    break;
                case 2:
                    viewBillById();
                    break;
                case 3:
                    viewAllBills();
                    break;
                case 0:
                    System.out.println("Exiting Billing...");
                    break;
                default:
                    System.out.println("❌ Invalid choice!");
            }
        } while (choice != 0);
    }

    private void addBill() {
        Billing bill = new Billing();

        System.out.print("Enter Patient ID: ");
        bill.setPatientId(sc.nextInt());

        System.out.print("Enter Appointment ID: ");
        bill.setAppointmentId(sc.nextInt());

        bill.setBillDate(new Date(System.currentTimeMillis()));

        System.out.print("Enter Consultation Fee: ");
        bill.setConsultationFee(sc.nextDouble());

        System.out.print("Enter Medicine Charge: ");
        bill.setMedicineCharge(sc.nextDouble());

        double total = bill.getConsultationFee() + bill.getMedicineCharge();
        bill.setTotalAmount(total);

        System.out.print("Enter Payment Status (PAID / UNPAID): ");
        bill.setPaymentStatus(sc.next());

        boolean status = billingService.addBill(bill);

        if (status) {
            System.out.println("✅ Bill Added Successfully!");
        } else {
            System.out.println("❌ Failed to add bill!");
        }
    }

    private void viewBillById() {
        System.out.print("Enter Bill ID: ");
        int id = sc.nextInt();

        Billing bill = billingService.getBillById(id);

        if (bill != null) {
            System.out.println(bill);
        } else {
            System.out.println("❌ Bill not found!");
        }
    }

    private void viewAllBills() {
        List<Billing> list = billingService.getAllBills();

        if (list.isEmpty()) {
            System.out.println("No bills found!");
        } else {
            for (Billing b : list) {
                System.out.println(b);
            }
        }
    }
}
