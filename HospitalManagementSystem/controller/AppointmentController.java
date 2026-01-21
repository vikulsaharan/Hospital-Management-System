package com.Hospitalmanagement.HospitalManagementSystem.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Scanner;

import com.Hospitalmanagement.HospitalManagementSystem.model.Appointment;
import com.Hospitalmanagement.HospitalManagementSystem.service.AppointmentService;
import com.Hospitalmanagement.HospitalManagementSystem.service.impl.AppointmentServiceImpl;

public class AppointmentController {

    public static void main(String[] args) {

        AppointmentService service = new AppointmentServiceImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n====== APPOINTMENT MENU ======");
            System.out.println("1. Add Appointment");
            System.out.println("2. View Appointment By ID");
            System.out.println("3. View All Appointments");
            System.out.println("4. View Appointments By Patient");
            System.out.println("5. View Appointments By Doctor");
            System.out.println("6. Update Appointment");
            System.out.println("7. Delete Appointment");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    Appointment ap = new Appointment();

                    System.out.print("Patient ID: ");
                    ap.setPatientId(sc.nextInt());

                    System.out.print("Doctor ID: ");
                    ap.setDoctorId(sc.nextInt());

                    System.out.print("Appointment Date (yyyy-mm-dd): ");
                    ap.setAppointmentDate(Date.valueOf(sc.next()));

                    System.out.print("Appointment Time (hh:mm:ss): ");
                    ap.setAppointmentTime(Time.valueOf(sc.next()));

                    System.out.print("Remarks: ");
                    ap.setRemarks(sc.next());

                    if (service.addAppointment(ap)) {
                        System.out.println("Appointment Added Successfully");
                    } else {
                        System.out.println("Failed to Add Appointment");
                    }
                    break;

                case 2:
                    System.out.print("Enter Appointment ID: ");
                    Appointment a = service.getAppointmentById(sc.nextInt());
                    System.out.println(a != null ? a : "No Record Found");
                    break;

                case 3:
                    List<Appointment> list = service.getAllAppointments();
                    list.forEach(System.out::println);
                    break;

                case 4:
                    System.out.print("Enter Patient ID: ");
                    service.getAppointmentsByPatient(sc.nextInt())
                           .forEach(System.out::println);
                    break;

                case 5:
                    System.out.print("Enter Doctor ID: ");
                    service.getAppointmentsByDoctor(sc.nextInt())
                           .forEach(System.out::println);
                    break;

                case 6:
                    Appointment up = new Appointment();

                    System.out.print("Appointment ID: ");
                    up.setAppointmentId(sc.nextInt());

                    System.out.print("Patient ID: ");
                    up.setPatientId(sc.nextInt());

                    System.out.print("Doctor ID: ");
                    up.setDoctorId(sc.nextInt());

                    System.out.print("Date (yyyy-mm-dd): ");
                    up.setAppointmentDate(Date.valueOf(sc.next()));

                    System.out.print("Time (hh:mm:ss): ");
                    up.setAppointmentTime(Time.valueOf(sc.next()));

                    System.out.print("Remarks: ");
                    up.setRemarks(sc.next());

                    if (service.updateAppointment(up)) {
                        System.out.println("Appointment Updated");
                    } else {
                        System.out.println("Update Failed");
                    }
                    break;

                case 7:
                    System.out.print("Enter Appointment ID: ");
                    if (service.deleteAppointment(sc.nextInt())) {
                        System.out.println("Appointment Deleted");
                    } else {
                        System.out.println("Delete Failed");
                    }
                    break;

                case 0:
                    System.out.println("Thank You 🙏");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
