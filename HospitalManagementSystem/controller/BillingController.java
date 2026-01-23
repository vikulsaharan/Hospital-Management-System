package com.Hospitalmanagement.HospitalManagementSystem.controller;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.Hospitalmanagement.HospitalManagementSystem.model.Billing;
import com.Hospitalmanagement.HospitalManagementSystem.service.BillingService;
import com.Hospitalmanagement.HospitalManagementSystem.service.impl.BillingServiceImpl;

public class BillingController {

    private Scanner sc = new Scanner(System.in);
    private BillingService billingService = new BillingServiceImpl();

    public void billingMenu() {
        System.out.println("\n--- Billing Menu ---");
        System.out.println("1. Add Bill");
        System.out.println("2. View Bill By ID");
        System.out.println("3. View All Bills");
        System.out.print("Choose: ");
        int ch = sc.nextInt();

        switch (ch) {
            case 1:
                Billing b = new Billing();
                System.out.print("Patient ID: ");
                b.setPatientId(sc.nextInt());
                System.out.print("Appointment ID: ");
                b.setAppointmentId(sc.nextInt());
                b.setBillDate(new Date(System.currentTimeMillis()));
                System.out.print("Consultation Fee: ");
                b.setConsultationFee(sc.nextDouble());
                System.out.print("Medicine Charge: ");
                b.setMedicineCharge(sc.nextDouble());
                b.setTotalAmount(b.getConsultationFee() + b.getMedicineCharge());
                b.setPaymentStatus("PAID");

                System.out.println(
                    billingService.addBill(b) ? "✅ Bill Added" : "❌ Failed"
                );
                break;

            case 2:
                System.out.print("Bill ID: ");
                Billing bill = billingService.getBillById(sc.nextInt());
                System.out.println(bill != null ? bill : "❌ Not Found");
                break;

            case 3:
                List<Billing> list = billingService.getAllBills();
                list.forEach(System.out::println);
                break;

            default:
                System.out.println("❌ Invalid Choice");
        }
    }
}

