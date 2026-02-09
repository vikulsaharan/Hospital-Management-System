package com.Hospitalmanagement.HospitalManagementSystem.controller;

import java.util.List;
import java.util.Scanner;

import com.Hospitalmanagement.HospitalManagementSystem.model.Staff;
import com.Hospitalmanagement.HospitalManagementSystem.service.StaffService;
import com.Hospitalmanagement.HospitalManagementSystem.service.impl.StaffServiceImpl;

public class StaffController {

    private StaffService staffService = new StaffServiceImpl();
    private Scanner sc = new Scanner(System.in);

    // ===== STAFF MENU =====
    public void staffMenu() {

        boolean back = false;

        while (!back) {
            System.out.println("\n===== STAFF MANAGEMENT =====");
            System.out.println("1. Add Staff");
            System.out.println("2. View All Staff");
            System.out.println("3. Update Staff");
            System.out.println("4. Delete Staff");
            System.out.println("0. Back");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addStaff(); break;
                case 2: viewAllStaff(); break;
                case 3: updateStaff(); break;
                case 4: deleteStaff(); break;
                case 0: back = true; break;
                default: System.out.println("❌ Invalid choice");
            }
        }
    }

    // ===== ADD STAFF =====
    private void addStaff() {
        Staff s = new Staff();

        System.out.print("Name: ");
        s.setStaffName(sc.nextLine());

        System.out.print("Role: ");
        s.setRole(sc.nextLine());

        System.out.print("Phone: ");
        s.setPhone(sc.nextLine());

        System.out.print("Salary: ");
        s.setSalary(sc.nextDouble());
        sc.nextLine();

        System.out.println(staffService.addStaff(s) ? "✅ Staff Added" : "❌ Failed");
    }

    // ===== VIEW ALL STAFF (TABLE FORMAT) =====
    private void viewAllStaff() {

        List<Staff> list = staffService.getAllStaff();

        if (list.isEmpty()) {
            System.out.println("No staff records found.");
            return;
        }

        System.out.println("\n--------------------------------------------------------------------------");
        System.out.printf("%-5s %-20s %-15s %-15s %-10s%n",
                "ID", "Name", "Role", "Phone", "Salary");
        System.out.println("--------------------------------------------------------------------------");

        for (Staff s : list) {
            System.out.printf("%-5d %-20s %-15s %-15s %-10.2f%n",
                    s.getStaffId(),
                    s.getStaffName(),
                    s.getRole(),
                    s.getPhone(),
                    s.getSalary());
        }

        System.out.println("--------------------------------------------------------------------------");
    }

    // ===== UPDATE STAFF =====
    private void updateStaff() {

        System.out.print("Enter Staff ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        Staff s = staffService.getStaffById(id);

        if (s == null) {
            System.out.println(" Staff not found");
            return;
        }

        System.out.print("New Name: ");
        s.setStaffName(sc.nextLine());

        System.out.print("New Role: ");
        s.setRole(sc.nextLine());

        System.out.print("New Phone: ");
        s.setPhone(sc.nextLine());

        System.out.print("New Salary: ");
        s.setSalary(sc.nextDouble());
        sc.nextLine();

        System.out.println(staffService.updateStaff(s) ? " Updated" : " Failed");
    }

    // ===== DELETE STAFF =====
    private void deleteStaff() {

        System.out.print("Enter Staff ID to delete: ");
        int id = sc.nextInt();

        System.out.println(staffService.deleteStaff(id) ? " Deleted" : " Failed");
    }
}
