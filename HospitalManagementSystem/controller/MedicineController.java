package com.Hospitalmanagement.HospitalManagementSystem.controller;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.Hospitalmanagement.HospitalManagementSystem.model.Medicines;
import com.Hospitalmanagement.HospitalManagementSystem.service.MedicinesService;
import com.Hospitalmanagement.HospitalManagementSystem.service.impl.MedicinesServiceImpl;

public class MedicineController {

    private static MedicinesService medicineService = new MedicinesServiceImpl();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;
        do {
            System.out.println("\n------ Medicine Management ------");
            System.out.println("1. Add Medicine");
            System.out.println("2. View All Medicines");
            System.out.println("3. View Medicine By ID");
            System.out.println("4. Update Medicine");
            System.out.println("5. Delete Medicine");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addMedicine();
                    break;
                case 2:
                    viewAllMedicines();
                    break;
                case 3:
                    viewMedicineById();
                    break;
                case 4:
                    updateMedicine();
                    break;
                case 5:
                    deleteMedicine();
                    break;
                case 0:
                    System.out.println("Exiting Medicine Module...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    // ---------- Methods ----------

    private static void addMedicine() {
        Medicines m = new Medicines();

        System.out.print("Medicine Name: ");
        sc.nextLine();
        m.setMedicineName(sc.nextLine());

        System.out.print("Company: ");
        m.setCompany(sc.nextLine());

        System.out.print("Price: ");
        m.setPrice(sc.nextDouble());

        System.out.print("Quantity: ");
        m.setQuantity(sc.nextInt());

        System.out.print("Expiry Date (yyyy-mm-dd): ");
        m.setExpiryDate(Date.valueOf(sc.next()));

        boolean status = medicineService.addMedicine(m);
        System.out.println(status ? "Medicine Added Successfully" : "Failed to Add Medicine");
    }

    private static void viewAllMedicines() {
        List<Medicines> list = medicineService.getAllMedicines();

        if (list.isEmpty()) {
            System.out.println("No Medicines Found");
        } else {
            for (Medicines m : list) {
                System.out.println(m);
            }
        }
    }

    private static void viewMedicineById() {
        System.out.print("Enter Medicine ID: ");
        int id = sc.nextInt();

        Medicines m = medicineService.getMedicineById(id);
        if (m != null) {
            System.out.println(m);
        } else {
            System.out.println("Medicine Not Found");
        }
    }

    private static void updateMedicine() {
        Medicines m = new Medicines();

        System.out.print("Medicine ID: ");
        m.setMedicineId(sc.nextInt());

        System.out.print("New Medicine Name: ");
        sc.nextLine();
        m.setMedicineName(sc.nextLine());

        System.out.print("New Company: ");
        m.setCompany(sc.nextLine());

        System.out.print("New Price: ");
        m.setPrice(sc.nextDouble());

        System.out.print("New Quantity: ");
        m.setQuantity(sc.nextInt());

        System.out.print("New Expiry Date (yyyy-mm-dd): ");
        m.setExpiryDate(Date.valueOf(sc.next()));

        boolean status = medicineService.updateMedicine(m);
        System.out.println(status ? "Medicine Updated Successfully" : "Update Failed");
    }

    private static void deleteMedicine() {
        System.out.print("Enter Medicine ID to Delete: ");
        int id = sc.nextInt();

        boolean status = medicineService.deleteMedicine(id);
        System.out.println(status ? "Medicine Deleted Successfully" : "Delete Failed");
    }
}
