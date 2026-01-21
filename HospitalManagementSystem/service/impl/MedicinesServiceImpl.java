package com.Hospitalmanagement.HospitalManagementSystem.service.impl;

import java.util.List;

import com.Hospitalmanagement.HospitalManagementSystem.dao.MedicinesDAO;
import com.Hospitalmanagement.HospitalManagementSystem.dao.impl.MedicinesDAOImpl;
import com.Hospitalmanagement.HospitalManagementSystem.model.Medicines;
import com.Hospitalmanagement.HospitalManagementSystem.service.MedicinesService;

public class MedicinesServiceImpl implements MedicinesService {

    private MedicinesDAO medicinesDAO = new MedicinesDAOImpl();

    @Override
    public boolean addMedicine(Medicines medicine) {
        return medicinesDAO.addMedicine(medicine);
    }

    @Override
    public Medicines getMedicineById(int medicineId) {
        return medicinesDAO.getMedicineById(medicineId);
    }

    @Override
    public List<Medicines> getAllMedicines() {
        return medicinesDAO.getAllMedicines();
    }

    @Override
    public boolean updateMedicine(Medicines medicine) {
        return medicinesDAO.updateMedicine(medicine);
    }

    @Override
    public boolean deleteMedicine(int medicineId) {
        return medicinesDAO.deleteMedicine(medicineId);
    }
}
