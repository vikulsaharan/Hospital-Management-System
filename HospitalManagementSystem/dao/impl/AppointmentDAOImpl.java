package com.Hospitalmanagement.HospitalManagementSystem.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.Hospitalmanagement.HospitalManagementSystem.dao.AppointmentDAO;
import com.Hospitalmanagement.HospitalManagementSystem.model.Appointment;
import com.Hospitalmanagement.HospitalManagementSystem.util.DataBaseUtil;

public class AppointmentDAOImpl implements AppointmentDAO {

    private Connection conn = DataBaseUtil.getConnection();

    @Override
    public boolean addAppointment(Appointment ap) {
        String sql = "INSERT INTO appointment (patient_id, doctor_id, appointment_date, appointment_time, remarks) VALUES (?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, ap.getPatientId());
            ps.setInt(2, ap.getDoctorId());
            ps.setDate(3, ap.getAppointmentDate());
            ps.setTime(4, ap.getAppointmentTime());
            ps.setString(5, ap.getRemarks());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Appointment getAppointmentById(int id) {
        String sql = "SELECT * FROM appointment WHERE appointment_id=?";
        Appointment ap = null;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ap = new Appointment();
                ap.setAppointmentId(rs.getInt("appointment_id"));
                ap.setPatientId(rs.getInt("patient_id"));
                ap.setDoctorId(rs.getInt("doctor_id"));
                ap.setAppointmentDate(rs.getDate("appointment_date"));
                ap.setAppointmentTime(rs.getTime("appointment_time"));
                ap.setRemarks(rs.getString("remarks"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ap;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        List<Appointment> list = new ArrayList<>();
        String sql = "SELECT * FROM appointment";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Appointment ap = new Appointment();
                ap.setAppointmentId(rs.getInt("appointment_id"));
                ap.setPatientId(rs.getInt("patient_id"));
                ap.setDoctorId(rs.getInt("doctor_id"));
                ap.setAppointmentDate(rs.getDate("appointment_date"));
                ap.setAppointmentTime(rs.getTime("appointment_time"));
                ap.setRemarks(rs.getString("remarks"));
                list.add(ap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Appointment> getAppointmentsByPatient(int patientId) {
        List<Appointment> list = new ArrayList<>();
        String sql = "SELECT * FROM appointment WHERE patient_id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, patientId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Appointment ap = new Appointment();
                ap.setAppointmentId(rs.getInt("appointment_id"));
                ap.setPatientId(rs.getInt("patient_id"));
                ap.setDoctorId(rs.getInt("doctor_id"));
                ap.setAppointmentDate(rs.getDate("appointment_date"));
                ap.setAppointmentTime(rs.getTime("appointment_time"));
                ap.setRemarks(rs.getString("remarks"));
                list.add(ap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Appointment> getAppointmentsByDoctor(int doctorId) {
        List<Appointment> list = new ArrayList<>();
        String sql = "SELECT * FROM appointment WHERE doctor_id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, doctorId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Appointment ap = new Appointment();
                ap.setAppointmentId(rs.getInt("appointment_id"));
                ap.setPatientId(rs.getInt("patient_id"));
                ap.setDoctorId(rs.getInt("doctor_id"));
                ap.setAppointmentDate(rs.getDate("appointment_date"));
                ap.setAppointmentTime(rs.getTime("appointment_time"));
                ap.setRemarks(rs.getString("remarks"));
                list.add(ap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean updateAppointment(Appointment ap) {
        String sql = "UPDATE appointment SET patient_id=?, doctor_id=?, appointment_date=?, appointment_time=?, remarks=? WHERE appointment_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, ap.getPatientId());
            ps.setInt(2, ap.getDoctorId());
            ps.setDate(3, ap.getAppointmentDate());
            ps.setTime(4, ap.getAppointmentTime());
            ps.setString(5, ap.getRemarks());
            ps.setInt(6, ap.getAppointmentId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteAppointment(int appointmentId) {
        String sql = "DELETE FROM appointment WHERE appointment_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, appointmentId);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
