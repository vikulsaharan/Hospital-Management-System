package com.Hospitalmanagement.HospitalManagementSystem.dao;



	import java.util.List;
	import com.Hospitalmanagement.HospitalManagementSystem.model.Patients;



	public interface PatientsDAO {

	    boolean addPatient(Patients patient);

	    Patients getPatientById(int patientId);

	    List<Patients> getAllPatients();

	    boolean updatePatient(Patients patient);

	    boolean deletePatient(int patientId);
	} 



