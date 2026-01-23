package com.Hospitalmanagement.HospitalManagementSystem.service;

import java.util.List;
import com.Hospitalmanagement.HospitalManagementSystem.model.Medicines;

public interface MedicinesService {

    boolean addMedicine(Medicines medicine);

    Medicines getMedicineById(int medicineId);

    List<Medicines> getAllMedicines();

    boolean updateMedicine(Medicines medicine);

    boolean deleteMedicine(int medicineId);
}
