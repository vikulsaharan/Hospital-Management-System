package com.Hospitalmanagement.HospitalManagementSystem;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.Hospitalmanagement.HospitalManagementSystem.model.*;
import com.Hospitalmanagement.HospitalManagementSystem.service.*;
import com.Hospitalmanagement.HospitalManagementSystem.service.impl.*;

public class App { 

    private static Scanner sc = new Scanner(System.in);

    private static DoctorService doctorService = new DoctorServiceImpl();
    private static PatientService patientService = new PatientServiceImpl();
    private static StaffService staffService = new StaffServiceImpl();
    private static AppointmentService appointmentService = new AppointmentServiceImpl();
    private static MedicinesService medicineService = new MedicinesServiceImpl();
    private static BillingService BillingService = new BillingServiceImpl();

    public static void main(String[] args) { 
        boolean exit = false;
        while (!exit) {
            System.out.println("\n===== Hospital Management System =====");
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("3. Staff");
            System.out.println("4. Appointment");
            System.out.println("5. Medicine");
            System.out.println("6. Billing");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: doctorMenu(); break;
                case 2: patientMenu(); break;
                case 3: staffMenu(); break;
                case 4: appointmentMenu(); break;
                case 5: medicineMenu(); break;
                case 6: billingMenu(); break;
                case 0: exit = true; System.out.println("Exiting..."); break;
                default: System.out.println("Invalid option!"); break;
            }
        }
    }

    // ------------------- Doctor Menu -------------------
    private static void doctorMenu() {
        System.out.println("\n--- Doctor Menu ---");
        System.out.println("1. Add Doctor");
        System.out.println("2. View Doctor by ID");
        System.out.println("3. View All Doctors");
        System.out.println("4. Update Doctor");
        System.out.println("5. Delete Doctor");
        System.out.print("Choose: ");
        int ch = sc.nextInt(); sc.nextLine();

        switch (ch) {
            case 1:
                Doctor d = new Doctor();
                System.out.print("Name: "); d.setDoctorName(sc.nextLine());
                System.out.print("Specialization: "); d.setSpecialization(sc.nextLine());
                System.out.print("Phone: "); d.setPhone(sc.nextLine());
                System.out.print("Email: "); d.setEmail(sc.nextLine());
                System.out.print("Experience: "); d.setExperience(sc.nextInt()); sc.nextLine();
                System.out.print("Availability: "); d.setAvailability(sc.nextLine());
                if (doctorService.addDoctor(d)) System.out.println("✅ Doctor added!");
                else System.out.println("❌ Failed!");
                break;
            case 2:
                System.out.print("Enter Doctor ID: "); int id = sc.nextInt();
                Doctor doc = doctorService.getDoctorById(id);
                if (doc != null) System.out.println(doc);
                else System.out.println("Not found!");
                break;
            case 3:
                List<Doctor> doctors = doctorService.getAllDoctors();
                doctors.forEach(System.out::println);
                break;
            case 4:
                System.out.print("Enter Doctor ID to update: "); int upId = sc.nextInt(); sc.nextLine();
                Doctor upd = doctorService.getDoctorById(upId);
                if (upd != null) {
                    System.out.print("Name: "); upd.setDoctorName(sc.nextLine());
                    System.out.print("Specialization: "); upd.setSpecialization(sc.nextLine());
                    System.out.print("Phone: "); upd.setPhone(sc.nextLine());
                    System.out.print("Email: "); upd.setEmail(sc.nextLine());
                    System.out.print("Experience: "); upd.setExperience(sc.nextInt()); sc.nextLine();
                    System.out.print("Availability: "); upd.setAvailability(sc.nextLine());
                    if (doctorService.updateDoctor(upd)) System.out.println("✅ Updated!");
                    else System.out.println("❌ Failed!");
                } else System.out.println("Doctor not found!");
                break;
            case 5:
                System.out.print("Enter Doctor ID to delete: "); int delId = sc.nextInt();
                if (doctorService.deleteDoctor(delId)) System.out.println("✅ Deleted!");
                else System.out.println("❌ Failed!");
                break;
            default: System.out.println("Invalid!");
        }
    }

    // ------------------- Patient Menu -------------------
    private static void patientMenu() {
        System.out.println("\n--- Patient Menu ---");
        System.out.println("1. Add Patient");
        System.out.println("2. View Patient by ID");
        System.out.println("3. View All Patients");
        System.out.println("4. Update Patient");
        System.out.println("5. Delete Patient");
        System.out.print("Choose: ");
        int ch = sc.nextInt(); sc.nextLine();

        switch (ch) {
            case 1:
                Patients p = new Patients();
                System.out.print("Name: "); p.setPatientName(sc.nextLine());
                System.out.print("Age: "); p.setAge(sc.nextInt()); sc.nextLine();
                System.out.print("Gender: "); p.setGender(sc.nextLine());
                System.out.print("Phone: "); p.setPhone(sc.nextLine());
                System.out.print("Blood Group: "); p.setBloodGroup(sc.nextLine());
                System.out.print("Disease: "); p.setDisease(sc.nextLine());
                p.setRegistrationDate(new Date(System.currentTimeMillis()));
                if (patientService.addPatient(p)) System.out.println("✅ Added!");
                else System.out.println("❌ Failed!");
                break;
            case 2:
                System.out.print("Enter Patient ID: "); int id = sc.nextInt();
                Patients pt = patientService.getPatientById(id);
                if (pt != null) System.out.println(pt);
                else System.out.println("Not found!");
                break;
            case 3:
                List<Patients> pts = patientService.getAllPatients();
                pts.forEach(System.out::println);
                break;
            case 4:
                System.out.print("Enter Patient ID to update: "); int upId = sc.nextInt(); sc.nextLine();
                Patients upd = patientService.getPatientById(upId);
                if (upd != null) {
                    System.out.print("Name: "); upd.setPatientName(sc.nextLine());
                    System.out.print("Age: "); upd.setAge(sc.nextInt()); sc.nextLine();
                    System.out.print("Gender: "); upd.setGender(sc.nextLine());
                    System.out.print("Phone: "); upd.setPhone(sc.nextLine());
                    System.out.print("Blood Group: "); upd.setBloodGroup(sc.nextLine());
                    System.out.print("Disease: "); upd.setDisease(sc.nextLine());
                    if (patientService.updatePatient(upd)) System.out.println("✅ Updated!");
                    else System.out.println("❌ Failed!");
                } else System.out.println("Patient not found!");
                break;
            case 5:
                System.out.print("Enter Patient ID to delete: "); int delId = sc.nextInt();
                if (patientService.deletePatient(delId)) System.out.println("✅ Deleted!");
                else System.out.println("❌ Failed!");
                break;
            default: System.out.println("Invalid!");
        }
    }

    // ------------------- Staff Menu -------------------
    private static void staffMenu() {
        System.out.println("Staff menu coming soon...");
    }

    // ------------------- Appointment Menu -------------------
    private static void appointmentMenu() {
        System.out.println("Appointment menu coming soon...");
    }

    // ------------------- Medicine Menu -------------------
    private static void medicineMenu() {
        System.out.println("Medicine menu coming soon...");
    }
    
 

    // ------------------- Billing Menu -------------------
    private static void billingMenu() {
        System.out.println("Billing menu coming soon...");
    }
}
