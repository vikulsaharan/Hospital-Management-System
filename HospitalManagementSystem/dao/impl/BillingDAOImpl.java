package com.Hospitalmanagement.HospitalManagementSystem.dao.impl;

import java.sql.*;
import java.util.*;

import com.Hospitalmanagement.HospitalManagementSystem.dao.BillingDAO;
import com.Hospitalmanagement.HospitalManagementSystem.model.Billing;
import com.Hospitalmanagement.HospitalManagementSystem.util.DataBaseUtil;

public class BillingDAOImpl implements BillingDAO {

    private Connection conn;

    public BillingDAOImpl() {
        conn = DataBaseUtil.getConnection();
    }

    @Override
    public boolean addBill(Billing bill) {

        String sql = "INSERT INTO billing (patient_id, appointment_id, bill_date, consultation_fee, medicine_charge, total_amount, payment_status) VALUES (?,?,?,?,?,?,?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, bill.getPatientId());
            ps.setInt(2, bill.getAppointmentId());

            // 🔥 Date fix
            ps.setDate(3, new java.sql.Date(bill.getBillDate().getTime()));

            ps.setDouble(4, bill.getConsultationFee());
            ps.setDouble(5, bill.getMedicineCharge());
            ps.setDouble(6, bill.getTotalAmount());
            ps.setString(7, bill.getPaymentStatus());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Billing getBillById(int billId) {

        String sql = "SELECT * FROM billing WHERE bill_id=?";
        Billing bill = null;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, billId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                bill = new Billing();
                bill.setBillId(rs.getInt("bill_id"));
                bill.setPatientId(rs.getInt("patient_id"));
                bill.setAppointmentId(rs.getInt("appointment_id"));
                bill.setBillDate(rs.getDate("bill_date"));
                bill.setConsultationFee(rs.getDouble("consultation_fee"));
                bill.setMedicineCharge(rs.getDouble("medicine_charge"));
                bill.setTotalAmount(rs.getDouble("total_amount"));
                bill.setPaymentStatus(rs.getString("payment_status"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bill;
    }

    @Override
    public List<Billing> getAllBills() {

        List<Billing> list = new ArrayList<>();
        String sql = "SELECT * FROM billing";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Billing bill = new Billing();
                bill.setBillId(rs.getInt("bill_id"));
                bill.setPatientId(rs.getInt("patient_id"));
                bill.setAppointmentId(rs.getInt("appointment_id"));
                bill.setBillDate(rs.getDate("bill_date"));
                bill.setConsultationFee(rs.getDouble("consultation_fee"));
                bill.setMedicineCharge(rs.getDouble("medicine_charge"));
                bill.setTotalAmount(rs.getDouble("total_amount"));
                bill.setPaymentStatus(rs.getString("payment_status"));
                list.add(bill);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
