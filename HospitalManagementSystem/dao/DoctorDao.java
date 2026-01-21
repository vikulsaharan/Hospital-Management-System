package com.Hospitalmanagement.HospitalManagementSystem.dao;


	import java.util.List;
	import com.Hospitalmanagement.HospitalManagementSystem.model.Doctor;

	public interface DoctorDao { 

	    boolean addDoctor(Doctor doctor);

	    Doctor getDoctorById(int doctorId);

	    List<Doctor> getAllDoctors();

	    boolean updateDoctor(Doctor doctor);

	    boolean deleteDoctor(int doctorId);
	}



