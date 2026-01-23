package com.Hospitalmanagement.HospitalManagementSystem.dao;

import java.util.List;

import com.Hospitalmanagement.HospitalManagementSystem.model.Staff;

	public interface StaffDAO {
 
	    boolean addStaff(Staff staff);

	    Staff getStaffById(int staffId);

	    List<Staff> getAllStaff();

	    boolean updateStaff(Staff staff);

	    boolean deleteStaff(int staffId);
	}


