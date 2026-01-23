package com.Hospitalmanagement.HospitalManagementSystem.service.impl;

import java.util.List;
import com.Hospitalmanagement.HospitalManagementSystem.dao.StaffDAO;
import com.Hospitalmanagement.HospitalManagementSystem.dao.impl.StaffDAOImpl;
import com.Hospitalmanagement.HospitalManagementSystem.model.Staff;
import com.Hospitalmanagement.HospitalManagementSystem.service.StaffService;

public class StaffServiceImpl implements StaffService {

    private StaffDAO staffDAO = new StaffDAOImpl();

    public boolean addStaff(Staff staff) {
        return staffDAO.addStaff(staff);
    }

    public Staff getStaffById(int staffId) {
        return staffDAO.getStaffById(staffId);
    }

    public List<Staff> getAllStaff() {
        return staffDAO.getAllStaff();
    }

    public boolean updateStaff(Staff staff) {
        return staffDAO.updateStaff(staff);
    }

    public boolean deleteStaff(int staffId) {
        return staffDAO.deleteStaff(staffId);
    }
}
