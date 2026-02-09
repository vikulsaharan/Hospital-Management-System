package com.Hospitalmanagement.HospitalManagementSystem.service.impl;

import java.util.List;
import com.Hospitalmanagement.HospitalManagementSystem.dao.PatientsDAO;
import com.Hospitalmanagement.HospitalManagementSystem.dao.impl.PatientsDaoImpl;
import com.Hospitalmanagement.HospitalManagementSystem.model.Patients;
import com.Hospitalmanagement.HospitalManagementSystem.service.PatientService;

public class PatientServiceImpl implements PatientService {

    private PatientsDAO patientDAO = new PatientsDaoImpl();
   
    public boolean addPatient(Patients patient) {
        return patientDAO.addPatient(patient);
    }

    public Patients getPatientById(int patientId) {
        return patientDAO.getPatientById(patientId);
    }

    public List<Patients> getAllPatients() {
        return patientDAO.getAllPatients();
    }

    public boolean updatePatient(Patients patient) {
        return patientDAO.updatePatient(patient);
    }

    public boolean deletePatient(int patientId) {
        return patientDAO.deletePatient(patientId);
    }
}
