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
            System.out.println("\n====== BILLING MANAGEMENT ======");
            System.out.println("1. Add Bill");
            System.out.println("2. View All Bills");
            System.out.println("3. View Bill by ID");
            System.out.println("4. Delete Bill");
            System.out.println("0. Back");
            System.out.print("Choose: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addBill(); break;
                case 2: viewAllBills(); break;
                case 3: viewBillById(); break;
                case 4: deleteBill(); break;
                case 0: System.out.println("Back to main menu"); break;
                default: System.out.println("Invalid choice");
            }
        } while (choice != 0);
    }

    // ================= ADD =================
    private void addBill() {
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
        sc.nextLine();

        System.out.print("Payment Status (Paid / Unpaid): ");
        b.setPaymentStatus(sc.nextLine());

        System.out.println(billingService.addBill(b)
                ? "✅ Bill Added Successfully"
                : "❌ Failed to Add Bill");
    }

    // ================= VIEW ALL (TABLE) =================
    private void viewAllBills() {
        List<Billing> list = billingService.getAllBills();

        System.out.println("\n------------------------------------------------------------------------------------------------------");
        System.out.printf("%-5s %-10s %-15s %-12s %-15s %-15s %-15s %-10s%n",
                "ID", "Patient", "Appointment", "Bill Date",
                "Consult Fee", "Med Charge", "Total", "Status");
        System.out.println("------------------------------------------------------------------------------------------------------");

        for (Billing b : list) {
            System.out.printf("%-5d %-10d %-15d %-12s %-15.2f %-15.2f %-15.2f %-10s%n",
                    b.getBillId(),
                    b.getPatientId(),
                    b.getAppointmentId(),
                    b.getBillDate(),
                    b.getConsultationFee(),
                    b.getMedicineCharge(),
                    b.getTotalAmount(),
                    b.getPaymentStatus());
        }
    }

    // ================= VIEW BY ID =================
    private void viewBillById() {
        System.out.print("Enter Bill ID: ");
        int id = sc.nextInt();

        Billing b = billingService.getBillById(id);

        if (b == null) {
            System.out.println("❌ Bill not found");
            return;
        }

        System.out.println("\n------------------------------------------------------------------------------------------------------");
        System.out.printf("%-5s %-10s %-15s %-12s %-15s %-15s %-15s %-10s%n",
                "ID", "Patient", "Appointment", "Bill Date",
                "Consult Fee", "Med Charge", "Total", "Status");
        System.out.println("------------------------------------------------------------------------------------------------------");

        System.out.printf("%-5d %-10d %-15d %-12s %-15.2f %-15.2f %-15.2f %-10s%n",
                b.getBillId(),
                b.getPatientId(),
                b.getAppointmentId(),
                b.getBillDate(),
                b.getConsultationFee(),
                b.getMedicineCharge(),
                b.getTotalAmount(),
                b.getPaymentStatus());
    }

    // ================= DELETE =================
    private void deleteBill() {
        System.out.print("Enter Bill ID to delete: ");
        int id = sc.nextInt();

        System.out.println(billingService.deleteBill(id)
                ? " Bill Deleted"
                : " Delete Failed");
    }
}
