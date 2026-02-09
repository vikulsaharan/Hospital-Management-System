package com.Hospitalmanagement.HospitalManagementSystem;

import java.util.Scanner;

import com.Hospitalmanagement.HospitalManagementSystem.controller.AdminController;
import com.Hospitalmanagement.HospitalManagementSystem.controller.DoctorController;
import com.Hospitalmanagement.HospitalManagementSystem.controller.PatientController;
import com.Hospitalmanagement.HospitalManagementSystem.controller.StaffController;
import com.Hospitalmanagement.HospitalManagementSystem.controller.AppointmentController;
import com.Hospitalmanagement.HospitalManagementSystem.controller.MedicineController;
import com.Hospitalmanagement.HospitalManagementSystem.controller.BillingController;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ===== CONTROLLERS =====
        AdminController adminController = new AdminController();
        DoctorController doctorController = new DoctorController();
        PatientController patientController = new PatientController();
        StaffController staffController = new StaffController();
        AppointmentController appointmentController = new AppointmentController();
        MedicineController medicineController = new MedicineController();
        BillingController billingController = new BillingController();

        // ===== ADMIN LOGIN =====
        if (!adminController.login()) {
            System.out.println("Application terminated ❌");
            return;
        }

        int choice;
        do {
            System.out.println("\n========= HOSPITAL MANAGEMENT SYSTEM =========");
            System.out.println("1. Doctor Management");
            System.out.println("2. Patient Management");
            System.out.println("3. Staff Management");
            System.out.println("4. Appointment Management");
            System.out.println("5. Medicine Management");
            System.out.println("6. Billing Management");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    doctorController.doctorMenu();
                    break;

                case 2:
                    patientController.patientMenu();
                    break;

                case 3:
                    staffController.staffMenu();
                    break;

                case 4:
                    appointmentController.appointmentMenu();
                    break;

                case 5:
                    medicineController.medicineMenu();
                    break;

                case 6:
                    billingController.billingMenu();
                    break;

                case 0:
                    System.out.println("Thank you 👋 Exiting system...");
                    break;

                default:
                    System.out.println("❌ Invalid option");
            }

        } while (choice != 0);

        sc.close();
    }
}
