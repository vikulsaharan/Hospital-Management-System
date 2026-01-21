package com.Hospitalmanagement.HospitalManagementSystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.Hospitalmanagement.HospitalManagementSystem.dao.PatientsDAO; 
import com.Hospitalmanagement.HospitalManagementSystem.model.Patients;
import com.Hospitalmanagement.HospitalManagementSystem.util.DataBaseUtil;

public class PatientsDaoImpl implements PatientsDAO {     

    private Connection conn = DataBaseUtil.getConnection(); 

    // ADD PATIENT
    @Override
    public boolean addPatient(Patients patient) {
        String sql = "INSERT INTO patient (patient_name, age, gender, phone, blood_group, disease, registration_date) VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
 
            ps.setString(1, patient.getPatientName());
            ps.setInt(2, patient.getAge());
            ps.setString(3, patient.getGender());
            ps.setString(4, patient.getPhone());
            ps.setString(5, patient.getBloodGroup());
            ps.setString(6, patient.getDisease());
            ps.setDate(7, patient.getRegistrationDate());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // GET PATIENT BY ID
    @Override
    public Patients getPatientById(int patientId) {
        String sql = "SELECT * FROM patient WHERE patient_id=?";
//        Patient = null;
        Patients patient = null;


        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, patientId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                patient = new Patients();
                patient.setPatientId(rs.getInt("patient_id"));
                patient.setPatientName(rs.getString("patient_name"));
                patient.setAge(rs.getInt("age"));
                patient.setGender(rs.getString("gender"));
                patient.setPhone(rs.getString("phone"));
                patient.setBloodGroup(rs.getString("blood_group"));
                patient.setDisease(rs.getString("disease"));
                patient.setRegistrationDate(rs.getDate("registration_date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patient;
    }

    // GET ALL PATIENTS
    @Override
    public List<Patients> getAllPatients() { 
        List<Patients> list = new ArrayList<>();
        String sql = "SELECT * FROM patient";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Patients patient = new Patients();
                patient.setPatientId(rs.getInt("patient_id"));
                patient.setPatientName(rs.getString("patient_name"));
                patient.setAge(rs.getInt("age"));
                patient.setGender(rs.getString("gender"));
                patient.setPhone(rs.getString("phone"));
                patient.setBloodGroup(rs.getString("blood_group"));
                patient.setDisease(rs.getString("disease"));
                patient.setRegistrationDate(rs.getDate("registration_date"));

                list.add(patient);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // UPDATE PATIENT
    @Override
    public boolean updatePatient(Patients patient) {
        String sql = "UPDATE patient SET patient_name=?, age=?, gender=?, phone=?, blood_group=?, disease=? WHERE patient_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, patient.getPatientName());
            ps.setInt(2, patient.getAge());
            ps.setString(3, patient.getGender());
            ps.setString(4, patient.getPhone());
            ps.setString(5, patient.getBloodGroup());
            ps.setString(6, patient.getDisease());
            ps.setInt(7, patient.getPatientId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // DELETE PATIENT
    @Override
    public boolean deletePatient(int patientId) {
        String sql = "DELETE FROM patient WHERE patient_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, patientId);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
