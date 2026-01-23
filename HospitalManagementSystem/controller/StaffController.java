package com.Hospitalmanagement.HospitalManagementSystem.controller; 

import java.util.List;
import java.util.Scanner;

import com.Hospitalmanagement.HospitalManagementSystem.model.Staff;
import com.Hospitalmanagement.HospitalManagementSystem.service.StaffService;
import com.Hospitalmanagement.HospitalManagementSystem.service.impl.StaffServiceImpl;

public class StaffController {

    private StaffService staffService = new StaffServiceImpl();
    private Scanner sc = new Scanner(System.in);

    public void staffMenu() {
        System.out.println("\n--- Staff Menu ---");
        System.out.println("1. Add Staff");
        System.out.println("2. View All Staff");
        System.out.println("3. Delete Staff");
        System.out.print("Choose: ");
        int ch = sc.nextInt();
        sc.nextLine();

        switch (ch) {
            case 1:
                Staff s = new Staff();
                System.out.print("Name: "); s.setStaffName(sc.nextLine());
                System.out.print("Role: "); s.setRole(sc.nextLine());
                System.out.print("Phone: "); s.setPhone(sc.nextLine());
                System.out.print("Email: "); s.setEmail(sc.nextLine());
                System.out.print("Shift: "); s.setShift(sc.nextLine());
                System.out.print("Salary: "); s.setSalary(sc.nextDouble());
                sc.nextLine();
                System.out.print("Gender: "); s.setGender(sc.nextLine());

                if (staffService.addStaff(s))
                    System.out.println("✅ Staff Added");
                else
                    System.out.println("❌ Failed");
                break;

            case 2:
                List<Staff> list = staffService.getAllStaff();
                list.forEach(System.out::println);
                break;

            case 3:
                System.out.print("Enter Staff ID: ");
                int id = sc.nextInt();
                if (staffService.deleteStaff(id))
                    System.out.println("✅ Deleted");
                else
                    System.out.println("❌ Failed");
                break;

            default:
                System.out.println("Invalid choice");
        }
    }
}
