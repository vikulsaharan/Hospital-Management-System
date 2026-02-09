package com.Hospitalmanagement.HospitalManagementSystem.controller;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.Hospitalmanagement.HospitalManagementSystem.model.Patients;
import com.Hospitalmanagement.HospitalManagementSystem.service.PatientService;
import com.Hospitalmanagement.HospitalManagementSystem.service.impl.PatientServiceImpl;

public class PatientController {

    private PatientService patientService = new PatientServiceImpl();
    private Scanner sc = new Scanner(System.in);

    // ===== MAIN MENU =====
    public void patientMenu() {
        boolean back = false;

        while (!back) {
            System.out.println("\n========= PATIENT MENU =========");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
            System.out.println("0. Back");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addPatient(); break;
                case 2: viewAllPatients(); break;
                case 3: updatePatient(); break;
                case 4: deletePatient(); break;
                case 0: back = true; break;
                default: System.out.println(" Invalid option");
            }
        }
    }

    // ===== ADD PATIENT =====
    private void addPatient() {
        Patients p = new Patients();

        System.out.print("Name: ");
        p.setPatientName(sc.nextLine());

        System.out.print("Age: ");
        p.setAge(sc.nextInt());
        sc.nextLine();

        System.out.print("Gender: ");
        p.setGender(sc.nextLine());

        System.out.print("Phone: ");
        p.setPhone(sc.nextLine());

        System.out.print("Blood Group: ");
        p.setBloodGroup(sc.nextLine());

        System.out.print("Disease: ");
        p.setDisease(sc.nextLine());

        // auto current date
        p.setRegistrationDate(new Date(System.currentTimeMillis()));

        boolean status = patientService.addPatient(p);
        System.out.println(status ? "✅ Patient Added" : "❌ Failed");
    }

    // ===== VIEW ALL (TABLE FORMAT) =====
    private void viewAllPatients() {
        List<Patients> list = patientService.getAllPatients();

        if (list.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }

        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.printf("%-5s %-20s %-5s %-8s %-15s %-12s %-15s%n",
                "ID", "Name", "Age", "Gender", "Phone", "BloodGrp", "Disease");
        System.out.println("--------------------------------------------------------------------------------");

        for (Patients p : list) {
            System.out.printf("%-5d %-20s %-5d %-8s %-15s %-12s %-15s%n",
                    p.getPatientId(),
                    p.getPatientName(),
                    p.getAge(),
                    p.getGender(),
                    p.getPhone(),
                    p.getBloodGroup(),
                    p.getDisease());
        }
    }

    // ===== UPDATE PATIENT =====
    private void updatePatient() {
        System.out.print("Enter Patient ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        Patients p = patientService.getPatientById(id);

        if (p == null) {
            System.out.println(" Patient not found");
            return;
        }

        System.out.print("Name: ");
        p.setPatientName(sc.nextLine());

        System.out.print("Age: ");
        p.setAge(sc.nextInt());
        sc.nextLine();

        System.out.print("Gender: ");
        p.setGender(sc.nextLine());

        System.out.print("Phone: ");
        p.setPhone(sc.nextLine());

        System.out.print("Blood Group: ");
        p.setBloodGroup(sc.nextLine());

        System.out.print("Disease: ");
        p.setDisease(sc.nextLine());

        boolean status = patientService.updatePatient(p);
        System.out.println(status ? " Updated Successfully" : " Update Failed");
    }

    // ===== DELETE PATIENT =====
    private void deletePatient() {
        System.out.print("Enter Patient ID to delete: ");
        int id = sc.nextInt();

        boolean status = patientService.deletePatient(id);
        System.out.println(status ? " Deleted Successfully" : "Delete Failed");
    }
}
