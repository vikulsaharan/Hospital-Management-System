package com.Hospitalmanagement.HospitalManagementSystem.dao.impl;

import java.sql.*;
import com.Hospitalmanagement.HospitalManagementSystem.dao.AdminDAO;
import com.Hospitalmanagement.HospitalManagementSystem.util.DataBaseUtil;

public class AdminDAOImpl implements AdminDAO {

    private Connection conn = DataBaseUtil.getConnection();

    @Override
    public boolean login(String username, String password) {
        String sql = "SELECT * FROM admin WHERE username=? AND password=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // login success
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
