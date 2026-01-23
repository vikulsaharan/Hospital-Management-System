package com.Hospitalmanagement.HospitalManagementSystem.service.impl;

import java.util.List;
import com.Hospitalmanagement.HospitalManagementSystem.dao.DoctorDao;
import com.Hospitalmanagement.HospitalManagementSystem.dao.impl.DoctorDaoImpl;
import com.Hospitalmanagement.HospitalManagementSystem.model.Doctor;
import com.Hospitalmanagement.HospitalManagementSystem.service.DoctorService;

public class DoctorServiceImpl implements DoctorService {

    private DoctorDao doctorDAO = new DoctorDaoImpl();

    public boolean addDoctor(Doctor doctor) {
        return doctorDAO.addDoctor(doctor);
    }

    public Doctor getDoctorById(int doctorId) {
        return doctorDAO.getDoctorById(doctorId);
    }

    public List<Doctor> getAllDoctors() {
        return doctorDAO.getAllDoctors();
    }

    public boolean updateDoctor(Doctor doctor) {
        return doctorDAO.updateDoctor(doctor);
    }

    public boolean deleteDoctor(int doctorId) {
        return doctorDAO.deleteDoctor(doctorId);
    }
}
