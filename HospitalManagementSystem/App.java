package com.Hospitalmanagement.HospitalManagementSystem;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Scanner;

import com.Hospitalmanagement.HospitalManagementSystem.model.*;
import com.Hospitalmanagement.HospitalManagementSystem.service.*;
import com.Hospitalmanagement.HospitalManagementSystem.service.impl.*;

public class App {

    private static Scanner sc = new Scanner(System.in);

    // ===== SERVICES ===== 
    private static AdminService adminService = new AdminServiceImpl();
    private static DoctorService doctorService = new DoctorServiceImpl();
    private static PatientService patientService = new PatientServiceImpl();
    private static StaffService staffService = new StaffServiceImpl();
    private static AppointmentService appointmentService = new AppointmentServiceImpl();
    private static MedicinesService medicinesService = new MedicinesServiceImpl();
    private static BillingService billingService = new BillingServiceImpl();

    public static void main(String[] args) {

        // ===== ADMIN LOGIN =====
        System.out.println("===== ADMIN LOGIN =====");
        System.out.print("Username: ");
        String user = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();

        if (!adminService.login(user, pass)) {
            System.out.println("❌ Invalid Admin Login");
            return;
        }

        System.out.println("✅ Login Successful");

        boolean exit = false;
        while (!exit) {
            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("3. Staff");
            System.out.println("4. Appointment");
            System.out.println("5. Medicine");
            System.out.println("6. Billing");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: doctorMenu(); break;
                case 2: patientMenu(); break;
                case 3: staffMenu(); break;
                case 4: appointmentMenu(); break;
                case 5: medicineMenu(); break;
                case 6: billingMenu(); break;
                case 0: exit = true; System.out.println("Bye 👋"); break;
                default: System.out.println("Invalid choice");
            }
        }
    }

    // ================= DOCTOR =================
    private static void doctorMenu() {
        System.out.println("\n--- Doctor ---");
        System.out.println("1. Add Doctor");
        System.out.println("2. View All Doctors");
        int ch = sc.nextInt(); sc.nextLine();

        if (ch == 1) {
            Doctor d = new Doctor();
            System.out.print("Name: "); d.setDoctorName(sc.nextLine());
            System.out.print("Specialization: "); d.setSpecialization(sc.nextLine());
            System.out.print("Phone: "); d.setPhone(sc.nextLine());
            System.out.print("Email: "); d.setEmail(sc.nextLine());
            System.out.print("Experience:only in number of year not in word "); d.setExperience(sc.nextInt()); sc.nextLine();

 

            System.out.print("Availability: "); d.setAvailability(sc.nextLine());
            System.out.println(doctorService.addDoctor(d) ? "✅ Added" : "❌ Failed");
        } else if (ch == 2) {
            doctorService.getAllDoctors().forEach(System.out::println);
        }
    }

    // ================= PATIENT =================
    private static void patientMenu() {
        System.out.println("\n--- Patient ---");
        System.out.println("1. Add Patient");
        System.out.println("2. View All Patients");
        int ch = sc.nextInt(); sc.nextLine();

        if (ch == 1) {
            Patients p = new Patients();
            System.out.print("Name: "); p.setPatientName(sc.nextLine());
            System.out.print("Age: "); p.setAge(sc.nextInt()); sc.nextLine();
            System.out.print("Gender: "); p.setGender(sc.nextLine());
            System.out.print("Phone: "); p.setPhone(sc.nextLine());
            System.out.print("Blood Group: "); p.setBloodGroup(sc.nextLine());
            System.out.print("Disease: "); p.setDisease(sc.nextLine());
            p.setRegistrationDate(new Date(System.currentTimeMillis()));
            System.out.println(patientService.addPatient(p) ? "✅ Added" : "❌ Failed");
        } else if (ch == 2) {
            patientService.getAllPatients().forEach(System.out::println);
        }
    }

    // ================= STAFF =================
    private static void staffMenu() {
        System.out.println("\n--- Staff ---");
        Staff s = new Staff();
        sc.nextLine();
        System.out.print("Name: "); s.setStaffName(sc.nextLine());
        System.out.print("Role: "); s.setRole(sc.nextLine());
        System.out.print("Phone: "); s.setPhone(sc.nextLine());
        System.out.print("Salary: "); s.setSalary(sc.nextDouble());
        System.out.println(staffService.addStaff(s) ? "✅ Added" : "❌ Failed");
    }

    // ================= APPOINTMENT =================
    private static void appointmentMenu() {
        System.out.println("\n--- Appointment ---");
        Appointment a = new Appointment();
        System.out.print("Patient ID: "); a.setPatientId(sc.nextInt());
        System.out.print("Doctor ID: "); a.setDoctorId(sc.nextInt());
        a.setAppointmentDate(new Date(System.currentTimeMillis()));
        a.setAppointmentTime(new Time(System.currentTimeMillis()));
        sc.nextLine();
        System.out.print("Remarks: "); a.setRemarks(sc.nextLine());
        System.out.println(appointmentService.addAppointment(a) ? "✅ Added" : "❌ Failed");
    }

    // ================= MEDICINE =================
    private static void medicineMenu() {
        System.out.println("\n--- Medicine ---");
        Medicines m = new Medicines();
        sc.nextLine();
        System.out.print("Name: "); m.setMedicineName(sc.nextLine());
        System.out.print("Company: "); m.setCompany(sc.nextLine());
        System.out.print("Price: "); m.setPrice(sc.nextDouble());
        System.out.print("Quantity: "); m.setQuantity(sc.nextInt());
        m.setExpiryDate(new Date(System.currentTimeMillis()));
        System.out.println(medicinesService.addMedicine(m) ? "✅ Added" : "❌ Failed");
    }

    // ================= BILLING =================
    private static void billingMenu() {
        System.out.println("\n--- Billing ---");
        Billing b = new Billing();
        System.out.print("Patient ID: "); b.setPatientId(sc.nextInt());
        System.out.print("Appointment ID: "); b.setAppointmentId(sc.nextInt());
        b.setBillDate(new Date(System.currentTimeMillis()));
        System.out.print("Consultation Fee: "); b.setConsultationFee(sc.nextDouble());
        System.out.print("Medicine Charge: "); b.setMedicineCharge(sc.nextDouble());
        b.setTotalAmount(b.getConsultationFee() + b.getMedicineCharge());
        sc.nextLine();
        System.out.print("Payment Status: "); b.setPaymentStatus(sc.nextLine());
        System.out.println(billingService.addBill(b) ? "✅ Added" : "❌ Failed");
    }
}
