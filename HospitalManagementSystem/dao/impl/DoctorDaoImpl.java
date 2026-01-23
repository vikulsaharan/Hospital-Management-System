//package com.Hospitalmanagement.HospitalManagementSystem.dao.impl;
//
//public class DoctorDaoImpl {
//
//}



package com.Hospitalmanagement.HospitalManagementSystem.dao.impl;

import com.Hospitalmanagement.HospitalManagementSystem.dao.DoctorDao;
import com.Hospitalmanagement.HospitalManagementSystem.model.Doctor;
import   com.Hospitalmanagement.HospitalManagementSystem.util.DataBaseUtil;    

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDaoImpl implements DoctorDao { 

    private Connection con;

    public DoctorDaoImpl() {
        this.con = DataBaseUtil.getConnection();
    }

    // ----------------- ADD DOCTOR -----------------
    @Override
    public boolean addDoctor(Doctor doctor) {
        String sql = "INSERT INTO doctor (doctor_name, specialization, phone, email, experience, availability) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, doctor.getDoctorName());
            ps.setString(2, doctor.getSpecialization());
            ps.setString(3, doctor.getPhone());
            ps.setString(4, doctor.getEmail());
            ps.setInt(5, doctor.getExperience());
            ps.setString(6, doctor.getAvailability());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // ----------------- GET DOCTOR BY ID -----------------
    @Override
    public Doctor getDoctorById(int doctorId) {
        String sql = "SELECT * FROM doctor WHERE doctor_id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, doctorId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setDoctorId(rs.getInt("doctor_id"));
                doctor.setDoctorName(rs.getString("doctor_name"));
                doctor.setSpecialization(rs.getString("specialization"));
                doctor.setPhone(rs.getString("phone"));
                doctor.setEmail(rs.getString("email"));
                doctor.setExperience(rs.getInt("experience"));
                doctor.setAvailability(rs.getString("availability"));
                return doctor;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // ----------------- GET ALL DOCTORS -----------------
    @Override
    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT * FROM doctor";

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setDoctorId(rs.getInt("doctor_id"));
                doctor.setDoctorName(rs.getString("doctor_name"));
                doctor.setSpecialization(rs.getString("specialization"));
                doctor.setPhone(rs.getString("phone"));
                doctor.setEmail(rs.getString("email"));
                doctor.setExperience(rs.getInt("experience"));
                doctor.setAvailability(rs.getString("availability"));

                doctors.add(doctor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return doctors;
    }

    // ----------------- UPDATE DOCTOR -----------------
    @Override
    public boolean updateDoctor(Doctor doctor) {
        String sql = "UPDATE doctor SET doctor_name=?, specialization=?, phone=?, email=?, experience=?, availability=? " +
                     "WHERE doctor_id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, doctor.getDoctorName());
            ps.setString(2, doctor.getSpecialization());
            ps.setString(3, doctor.getPhone());
            ps.setString(4, doctor.getEmail());
            ps.setInt(5, doctor.getExperience());
            ps.setString(6, doctor.getAvailability());
            ps.setInt(7, doctor.getDoctorId());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // ----------------- DELETE DOCTOR -----------------
    @Override
    public boolean deleteDoctor(int doctorId) {
        String sql = "DELETE FROM doctor WHERE doctor_id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, doctorId);
            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
