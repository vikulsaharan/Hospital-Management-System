package com.Hospitalmanagement.HospitalManagementSystem.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Hospitalmanagement.HospitalManagementSystem.dao.MedicinesDAO;
import com.Hospitalmanagement.HospitalManagementSystem.model.Medicines;
import com.Hospitalmanagement.HospitalManagementSystem.util.DataBaseUtil;

public class MedicinesDAOImpl implements MedicinesDAO {

    private Connection conn;

    public MedicinesDAOImpl() {
        conn = DataBaseUtil.getConnection();
    }

    // ➕ ADD MEDICINE
    @Override
    public boolean addMedicine(Medicines medicine) {

        String sql = "INSERT INTO medicine (medicine_name, company, price, quantity, expiry_date) VALUES (?,?,?,?,?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, medicine.getMedicineName());
            ps.setString(2, medicine.getCompany());
            ps.setDouble(3, medicine.getPrice());
            ps.setInt(4, medicine.getQuantity());
            ps.setDate(5, medicine.getExpiryDate());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 🔍 GET BY ID
    @Override
    public Medicines getMedicineById(int medicineId) {

        String sql = "SELECT * FROM medicine WHERE medicine_id=?";
        Medicines medicine = null;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, medicineId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                medicine = new Medicines();
                medicine.setMedicineId(rs.getInt("medicine_id"));
                medicine.setMedicineName(rs.getString("medicine_name"));
                medicine.setCompany(rs.getString("company"));
                medicine.setPrice(rs.getDouble("price"));
                medicine.setQuantity(rs.getInt("quantity"));
                medicine.setExpiryDate(rs.getDate("expiry_date"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicine;
    }

    // 📄 GET ALL
    @Override
    public List<Medicines> getAllMedicines() {

        List<Medicines> list = new ArrayList<>();
        String sql = "SELECT * FROM medicine";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Medicines medicine = new Medicines();
                medicine.setMedicineId(rs.getInt("medicine_id"));
                medicine.setMedicineName(rs.getString("medicine_name"));
                medicine.setCompany(rs.getString("company"));
                medicine.setPrice(rs.getDouble("price"));
                medicine.setQuantity(rs.getInt("quantity"));
                medicine.setExpiryDate(rs.getDate("expiry_date"));
                list.add(medicine);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // ✏ UPDATE
    @Override
    public boolean updateMedicine(Medicines medicine) {

        String sql = "UPDATE medicine SET medicine_name=?, company=?, price=?, quantity=?, expiry_date=? WHERE medicine_id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, medicine.getMedicineName());
            ps.setString(2, medicine.getCompany());
            ps.setDouble(3, medicine.getPrice());
            ps.setInt(4, medicine.getQuantity());
            ps.setDate(5, medicine.getExpiryDate());
            ps.setInt(6, medicine.getMedicineId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // ❌ DELETE
    @Override
    public boolean deleteMedicine(int medicineId) {

        String sql = "DELETE FROM medicine WHERE medicine_id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, medicineId);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
