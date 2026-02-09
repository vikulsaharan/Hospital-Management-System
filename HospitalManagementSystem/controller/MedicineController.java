package com.Hospitalmanagement.HospitalManagementSystem.controller;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.Hospitalmanagement.HospitalManagementSystem.model.Medicines;
import com.Hospitalmanagement.HospitalManagementSystem.service.MedicinesService;
import com.Hospitalmanagement.HospitalManagementSystem.service.impl.MedicinesServiceImpl;

public class MedicineController {

    private MedicinesService medicinesService = new MedicinesServiceImpl();
    private Scanner sc = new Scanner(System.in);

    public void medicineMenu() {
        int choice;

        do {
            System.out.println("\n====== MEDICINE MANAGEMENT ======");
            System.out.println("1. Add Medicine");
            System.out.println("2. View All Medicines");
            System.out.println("3. View Medicine by ID");
            System.out.println("4. Delete Medicine");
            System.out.println("0. Back");
            System.out.print("Choose: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addMedicine(); break;
                case 2: viewAllMedicines(); break;
                case 3: viewMedicineById(); break;
                case 4: deleteMedicine(); break;
                case 0: System.out.println("Back to main menu"); break;
                default: System.out.println("Invalid choice");
            }
        } while (choice != 0);
    }

    // ================= ADD =================
    private void addMedicine() {
        Medicines m = new Medicines();
        sc.nextLine();

        System.out.print("Medicine Name: ");
        m.setMedicineName(sc.nextLine());

        System.out.print("Company: ");
        m.setCompany(sc.nextLine());

        System.out.print("Price: ");
        m.setPrice(sc.nextDouble());

        System.out.print("Quantity: ");
        m.setQuantity(sc.nextInt());

        m.setExpiryDate(new Date(System.currentTimeMillis()));

        System.out.println(medicinesService.addMedicine(m)
                ? "✅ Medicine Added"
                : "❌ Failed");
    }

    // ================= VIEW ALL (TABLE) =================
    private void viewAllMedicines() {
        List<Medicines> list = medicinesService.getAllMedicines();

        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.printf("%-5s %-20s %-20s %-10s %-10s %-15s%n",
                "ID", "Name", "Company", "Price", "Qty", "Expiry Date");
        System.out.println("--------------------------------------------------------------------------------");

        for (Medicines m : list) {
            System.out.printf("%-5d %-20s %-20s %-10.2f %-10d %-15s%n",
                    m.getMedicineId(),
                    m.getMedicineName(),
                    m.getCompany(),
                    m.getPrice(),
                    m.getQuantity(),
                    m.getExpiryDate());
        }
    }

    // ================= VIEW BY ID =================
    private void viewMedicineById() {
        System.out.print("Enter Medicine ID: ");
        int id = sc.nextInt();

        Medicines m = medicinesService.getMedicineById(id);

        if (m == null) {
            System.out.println("❌ Medicine not found");
            return;
        }

        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.printf("%-5s %-20s %-20s %-10s %-10s %-15s%n",
                "ID", "Name", "Company", "Price", "Qty", "Expiry Date");
        System.out.println("--------------------------------------------------------------------------------");

        System.out.printf("%-5d %-20s %-20s %-10.2f %-10d %-15s%n",
                m.getMedicineId(),
                m.getMedicineName(),
                m.getCompany(),
                m.getPrice(),
                m.getQuantity(),
                m.getExpiryDate());
    }

    // ================= DELETE =================
    private void deleteMedicine() {
        System.out.print("Enter Medicine ID to delete: ");
        int id = sc.nextInt();

        System.out.println(medicinesService.deleteMedicine(id)
                ? "✅ Medicine Deleted"
                : "❌ Delete Failed");
    }
}
