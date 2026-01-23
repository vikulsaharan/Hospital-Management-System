package com.Hospitalmanagement.HospitalManagementSystem.controller;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.Hospitalmanagement.HospitalManagementSystem.model.Patients;
import com.Hospitalmanagement.HospitalManagementSystem.service.PatientService;
import com.Hospitalmanagement.HospitalManagementSystem.service.impl.PatientServiceImpl;

public class PatientController {

    private Scanner sc = new Scanner(System.in);
    private PatientService patientService = new PatientServiceImpl();

    public void patientMenu() {
        System.out.println("\n--- Patient Menu ---");
        System.out.println("1. Add Patient");
        System.out.println("2. View Patient By ID");
        System.out.println("3. View All Patients");
        System.out.println("4. Update Patient");
        System.out.println("5. Delete Patient");
        System.out.print("Choose: ");
        int ch = sc.nextInt();
        sc.nextLine();

        switch (ch) {
            case 1:
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
                p.setRegistrationDate(new Date(System.currentTimeMillis()));

                System.out.println(
                    patientService.addPatient(p) ? "✅ Patient Added" : "❌ Failed"
                );
                break;

            case 2:
                System.out.print("Patient ID: ");
                Patients pt = patientService.getPatientById(sc.nextInt());
                System.out.println(pt != null ? pt : "❌ Not Found");
                break;

            case 3:
                List<Patients> list = patientService.getAllPatients();
                list.forEach(System.out::println);
                break;

            case 4:
                System.out.print("Patient ID: ");
                Patients upd = patientService.getPatientById(sc.nextInt());
                sc.nextLine();
                if (upd != null) {
                    System.out.print("Name: ");
                    upd.setPatientName(sc.nextLine());
                    System.out.print("Age: ");
                    upd.setAge(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Gender: ");
                    upd.setGender(sc.nextLine());
                    System.out.print("Phone: ");
                    upd.setPhone(sc.nextLine());
                    System.out.print("Blood Group: ");
                    upd.setBloodGroup(sc.nextLine());
                    System.out.print("Disease: ");
                    upd.setDisease(sc.nextLine());

                    System.out.println(
                        patientService.updatePatient(upd) ? "✅ Updated" : "❌ Failed"
                    );
                } else {
                    System.out.println("❌ Patient Not Found");
                }
                break;

            case 5:
                System.out.print("Patient ID: ");
                System.out.println(
                    patientService.deletePatient(sc.nextInt()) ? "✅ Deleted" : "❌ Failed"
                );
                break;

            default:
                System.out.println("❌ Invalid Choice");
        }
    }
}
