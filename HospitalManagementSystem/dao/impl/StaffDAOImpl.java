package com.Hospitalmanagement.HospitalManagementSystem.dao.impl;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.Hospitalmanagement.HospitalManagementSystem.dao.StaffDAO;
import com.Hospitalmanagement.HospitalManagementSystem.model.Staff;
import com.Hospitalmanagement.HospitalManagementSystem.util.DataBaseUtil;

public class StaffDAOImpl implements StaffDAO {

    private Connection conn = DataBaseUtil.getConnection();

    @Override
    public boolean addStaff(Staff staff) {
        String sql = "INSERT INTO staff (staff_name, role, phone, email, shift, salary, gender) VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, staff.getStaffName());
            ps.setString(2, staff.getRole());
            ps.setString(3, staff.getPhone());
            ps.setString(4, staff.getEmail());
            ps.setString(5, staff.getShift());
            ps.setDouble(6, staff.getSalary());
            ps.setString(7, staff.getGender());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Staff getStaffById(int staffId) {
        String sql = "SELECT * FROM staff WHERE staff_id=?";
        Staff staff = null;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, staffId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                staff = new Staff();
                staff.setStaffId(rs.getInt("staff_id"));
                staff.setStaffName(rs.getString("staff_name"));
                staff.setRole(rs.getString("role"));
                staff.setPhone(rs.getString("phone"));
                staff.setEmail(rs.getString("email"));
                staff.setShift(rs.getString("shift"));
                staff.setSalary(rs.getDouble("salary"));
                staff.setGender(rs.getString("gender"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return staff;
    }

    @Override
    public List<Staff> getAllStaff() {
        List<Staff> list = new ArrayList<>();
        String sql = "SELECT * FROM staff";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Staff staff = new Staff();
                staff.setStaffId(rs.getInt("staff_id"));
                staff.setStaffName(rs.getString("staff_name"));
                staff.setRole(rs.getString("role"));
                staff.setPhone(rs.getString("phone"));
                staff.setEmail(rs.getString("email"));
                staff.setShift(rs.getString("shift"));
                staff.setSalary(rs.getDouble("salary"));
                staff.setGender(rs.getString("gender"));
                list.add(staff);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean updateStaff(Staff staff) {
        String sql = "UPDATE staff SET staff_name=?, role=?, phone=?, email=?, shift=?, salary=?, gender=? WHERE staff_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, staff.getStaffName());
            ps.setString(2, staff.getRole());
            ps.setString(3, staff.getPhone());
            ps.setString(4, staff.getEmail());
            ps.setString(5, staff.getShift());
            ps.setDouble(6, staff.getSalary());
            ps.setString(7, staff.getGender());
            ps.setInt(8, staff.getStaffId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteStaff(int staffId) {
        String sql = "DELETE FROM staff WHERE staff_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, staffId);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
