package com.Hospitalmanagement.HospitalManagementSystem.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Scanner;

import com.Hospitalmanagement.HospitalManagementSystem.model.Appointment;
import com.Hospitalmanagement.HospitalManagementSystem.service.AppointmentService;
import com.Hospitalmanagement.HospitalManagementSystem.service.impl.AppointmentServiceImpl;

public class AppointmentController {

    private AppointmentService appointmentService = new AppointmentServiceImpl();
    private Scanner sc = new Scanner(System.in);

    public void appointmentMenu() {
        int choice;

        do {
            System.out.println("\n====== APPOINTMENT MANAGEMENT ======");
            System.out.println("1. Add Appointment");
            System.out.println("2. View All Appointments");
            System.out.println("3. View Appointment by ID");
            System.out.println("4. Delete Appointment");
            System.out.println("0. Back");
            System.out.print("Choose: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addAppointment(); break;
                case 2: viewAllAppointments(); break;
                case 3: viewAppointmentById(); break;
                case 4: deleteAppointment(); break;
                case 0: System.out.println("Back to main menu"); break;
                default: System.out.println("Invalid choice");
            }
        } while (choice != 0);
    }

    // ================= ADD =================
    private void addAppointment() {
        Appointment a = new Appointment();

        System.out.print("Patient ID: ");
        a.setPatientId(sc.nextInt());

        System.out.print("Doctor ID: ");
        a.setDoctorId(sc.nextInt());

        a.setAppointmentDate(new Date(System.currentTimeMillis()));
        a.setAppointmentTime(new Time(System.currentTimeMillis()));
        sc.nextLine();

        System.out.print("Remarks: ");
        a.setRemarks(sc.nextLine());

        System.out.println(appointmentService.addAppointment(a)
                ? "✅ Appointment Added"
                : "❌ Failed");
    }

    // ================= VIEW ALL (TABLE) =================
    private void viewAllAppointments() {
        List<Appointment> list = appointmentService.getAllAppointments();

        System.out.println("\n--------------------------------------------------------------------------");
        System.out.printf("%-5s %-10s %-10s %-15s %-15s %-20s%n",
                "ID", "PatientID", "DoctorID", "Date", "Time", "Remarks");
        System.out.println("--------------------------------------------------------------------------");

        for (Appointment a : list) {
            System.out.printf("%-5d %-10d %-10d %-15s %-15s %-20s%n",
                    a.getAppointmentId(),
                    a.getPatientId(),
                    a.getDoctorId(),
                    a.getAppointmentDate(),
                    a.getAppointmentTime(),
                    a.getRemarks());
        }
    }

    // ================= VIEW BY ID =================
    private void viewAppointmentById() {
        System.out.print("Enter Appointment ID: ");
        int id = sc.nextInt();

        Appointment a = appointmentService.getAppointmentById(id);

        if (a == null) {
            System.out.println(" Appointment not found");
            return;
        }

        System.out.println("\n------------------------------------------------------------");
        System.out.printf("%-5s %-10s %-10s %-15s %-15s %-20s%n",
                "ID", "PatientID", "DoctorID", "Date", "Time", "Remarks");
        System.out.println("------------------------------------------------------------");

        System.out.printf("%-5d %-10d %-10d %-15s %-15s %-20s%n",
                a.getAppointmentId(),
                a.getPatientId(),
                a.getDoctorId(),
                a.getAppointmentDate(),
                a.getAppointmentTime(),
                a.getRemarks());
    }

    // ================= DELETE =================
    private void deleteAppointment() {
        System.out.print("Enter Appointment ID to delete: ");
        int id = sc.nextInt();

        System.out.println(appointmentService.deleteAppointment(id)
                ? " Appointment Deleted"
                : " Delete Failed");
    }
}
