package com.Hospitalmanagement.HospitalManagementSystem.controller;

import java.util.Scanner;

import com.Hospitalmanagement.HospitalManagementSystem.service.AdminService;
import com.Hospitalmanagement.HospitalManagementSystem.service.impl.AdminServiceImpl;

public class AdminController {

    private AdminService adminService = new AdminServiceImpl();
    private Scanner sc = new Scanner(System.in);

    // ===== ADMIN LOGIN =====
    public boolean login() {
        System.out.println("===== ADMIN LOGIN =====");

        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        if (adminService.login(username, password)) {
            System.out.println("✅ Login Successful");
            return true;
        } else {
            System.out.println("❌ Invalid Username or Password");
            return false;
        }
    }
}
