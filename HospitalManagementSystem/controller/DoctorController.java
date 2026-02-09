package com.Hospitalmanagement.HospitalManagementSystem.controller;

import java.util.List;
import java.util.Scanner;

import com.Hospitalmanagement.HospitalManagementSystem.model.Doctor;
import com.Hospitalmanagement.HospitalManagementSystem.service.DoctorService;
import com.Hospitalmanagement.HospitalManagementSystem.service.impl.DoctorServiceImpl;

public class DoctorController {

    private Scanner sc = new Scanner(System.in);
    private DoctorService doctorService = new DoctorServiceImpl();

    // ================= DOCTOR MENU =================
    public void doctorMenu() {
        boolean back = false;

        while (!back) {
            System.out.println("\n===== DOCTOR MANAGEMENT =====");
            System.out.println("1. Add Doctor");
            System.out.println("2. View All Doctors");
            System.out.println("3. Update Doctor");
            System.out.println("4. Delete Doctor");
            System.out.println("0. Back");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addDoctor(); break;
                case 2: viewDoctors(); break;
                case 3: updateDoctor(); break;
                case 4: deleteDoctor(); break;
                case 0: back = true; break;
                default: System.out.println("❌ Invalid choice");
            }
        }
    }

    // ================= ADD =================
    private void addDoctor() {
        Doctor d = new Doctor();

        System.out.print("Doctor Name: ");
        d.setDoctorName(sc.nextLine());

        System.out.print("Specialization: ");
        d.setSpecialization(sc.nextLine());

        System.out.print("Phone: ");
        d.setPhone(sc.nextLine());

        System.out.print("Email: ");
        d.setEmail(sc.nextLine());

        System.out.print("Experience (years only): ");
        d.setExperience(sc.nextInt());
        sc.nextLine();

        System.out.print("Availability: ");
        d.setAvailability(sc.nextLine());

        boolean status = doctorService.addDoctor(d);
        System.out.println(status ? "✅ Doctor Added Successfully" : "❌ Failed to Add Doctor");
    }

    // ================= VIEW (TABLE FORMAT) =================
    private void viewDoctors() {
        List<Doctor> list = doctorService.getAllDoctors();

        if (list.isEmpty()) {
            System.out.println("No doctors found.");
            return;
        }

        System.out.println("\n---------------------------------------------------------------------------------------------");
        System.out.printf("%-5s %-20s %-15s %-15s %-25s %-10s %-15s%n",
                "ID", "Name", "Specialization", "Phone", "Email", "Exp", "Availability");
        System.out.println("---------------------------------------------------------------------------------------------");

        for (Doctor d : list) {
            System.out.printf("%-5d %-20s %-15s %-15s %-25s %-10d %-15s%n",
                    d.getDoctorId(),
                    d.getDoctorName(),
                    d.getSpecialization(),
                    d.getPhone(),
                    d.getEmail(),
                    d.getExperience(),
                    d.getAvailability());
        }

        System.out.println("---------------------------------------------------------------------------------------------");
    }

    // ================= UPDATE =================
    private void updateDoctor() {
        System.out.print("Enter Doctor ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        Doctor d = doctorService.getDoctorById(id);
        if (d == null) {
            System.out.println("❌ Doctor not found");
            return;
        }

        System.out.print("New Name: ");
        d.setDoctorName(sc.nextLine());

        System.out.print("New Specialization: ");
        d.setSpecialization(sc.nextLine());

        System.out.print("New Phone: ");
        d.setPhone(sc.nextLine());

        System.out.print("New Email: ");
        d.setEmail(sc.nextLine());

        System.out.print("New Experience (years): ");
        d.setExperience(sc.nextInt());
        sc.nextLine();

        System.out.print("New Availability: ");
        d.setAvailability(sc.nextLine());

        boolean status = doctorService.updateDoctor(d);
        System.out.println(status ? "✅ Doctor Updated Successfully" : "❌ Update Failed");
    }

    // ================= DELETE =================
    private void deleteDoctor() {
        System.out.print("Enter Doctor ID to delete: ");
        int id = sc.nextInt();

        boolean status = doctorService.deleteDoctor(id);
        System.out.println(status ? "✅ Doctor Deleted Successfully" : "❌ Delete Failed");
    }
}
