package com.Hospitalmanagement.HospitalManagementSystem.controller;

import java.util.List;
import java.util.Scanner;

import com.Hospitalmanagement.HospitalManagementSystem.model.Doctor;
import com.Hospitalmanagement.HospitalManagementSystem.service.DoctorService;
import com.Hospitalmanagement.HospitalManagementSystem.service.impl.DoctorServiceImpl;

public class DoctorController {

    private Scanner sc = new Scanner(System.in);
    private DoctorService doctorService = new DoctorServiceImpl();

    public void doctorMenu() {
        System.out.println("\n--- Doctor Menu ---");
        System.out.println("1. Add Doctor");
        System.out.println("2. View Doctor By ID");
        System.out.println("3. View All Doctors");
        System.out.println("4. Update Doctor");
        System.out.println("5. Delete Doctor");
        System.out.print("Choose: ");
        int ch = sc.nextInt();
        sc.nextLine();

        switch (ch) {
            case 1:
                Doctor d = new Doctor();
                System.out.print("Name: ");
                d.setDoctorName(sc.nextLine());
                System.out.print("Specialization: ");
                d.setSpecialization(sc.nextLine());
                System.out.print("Phone: ");
                d.setPhone(sc.nextLine());
                System.out.print("Email: ");
                d.setEmail(sc.nextLine());
                System.out.print("Experience (number only): ");
                d.setExperience(sc.nextInt());
                sc.nextLine();
                System.out.print("Availability: ");
                d.setAvailability(sc.nextLine());

                System.out.println(
                    doctorService.addDoctor(d) ? "✅ Doctor Added" : "❌ Failed"
                );
                break;

            case 2:
                System.out.print("Doctor ID: ");
                Doctor doc = doctorService.getDoctorById(sc.nextInt());
                System.out.println(doc != null ? doc : "❌ Not Found");
                break;

            case 3:
                List<Doctor> list = doctorService.getAllDoctors();
                list.forEach(System.out::println);
                break;

            case 4:
                System.out.print("Doctor ID: ");
                Doctor upd = doctorService.getDoctorById(sc.nextInt());
                sc.nextLine();
                if (upd != null) {
                    System.out.print("Name: ");
                    upd.setDoctorName(sc.nextLine());
                    System.out.print("Specialization: ");
                    upd.setSpecialization(sc.nextLine());
                    System.out.print("Phone: ");
                    upd.setPhone(sc.nextLine());
                    System.out.print("Email: ");
                    upd.setEmail(sc.nextLine());
                    System.out.print("Experience: ");
                    upd.setExperience(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Availability: ");
                    upd.setAvailability(sc.nextLine());

                    System.out.println(
                        doctorService.updateDoctor(upd) ? "✅ Updated" : "❌ Failed"
                    );
                } else {
                    System.out.println("❌ Doctor Not Found");
                }
                break;

            case 5:
                System.out.print("Doctor ID: ");
                System.out.println(
                    doctorService.deleteDoctor(sc.nextInt()) ? "✅ Deleted" : "❌ Failed"
                );
                break;

            default:
                System.out.println("❌ Invalid Choice");
        }
    }
}
