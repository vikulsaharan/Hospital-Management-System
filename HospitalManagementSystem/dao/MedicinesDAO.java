package com.Hospitalmanagement.HospitalManagementSystem.dao;

import java.util.List;
import com.Hospitalmanagement.HospitalManagementSystem.model.Medicines;

public interface MedicinesDAO {

    boolean addMedicine(Medicines medicine);

    Medicines getMedicineById(int medicineId);

    List<Medicines> getAllMedicines();

    boolean updateMedicine(Medicines medicine);

    boolean deleteMedicine(int medicineId);
}
