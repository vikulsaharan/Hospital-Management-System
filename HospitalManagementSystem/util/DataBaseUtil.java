package com.Hospitalmanagement.HospitalManagementSystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/hospital_management_system";
    private static final String USER = "root";     // apna DB username
    private static final String PASSWORD = "sql@silki84"; // apna DB password

    private static Connection connection;

    // Private constructor: prevent object creation
    private DataBaseUtil() { 
    }

    // Public method: return single connection instance
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                // Load MySQL driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Connect to database
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("✅ Database Connected Successfully!");
            }
        } catch (ClassNotFoundException e) {
            System.out.println(" MySQL Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println(" Database connection failed!");
            e.printStackTrace();
        }

        return connection;
    }
}
