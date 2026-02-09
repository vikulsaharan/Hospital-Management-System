package com.Hospitalmanagement.HospitalManagementSystem.service.impl;

import com.Hospitalmanagement.HospitalManagementSystem.dao.AdminDAO;
import com.Hospitalmanagement.HospitalManagementSystem.dao.impl.AdminDAOImpl;
import com.Hospitalmanagement.HospitalManagementSystem.service.AdminService;

public class AdminServiceImpl implements AdminService {

    private AdminDAO adminDAO = new AdminDAOImpl(); 

    @Override
    public boolean login(String username, String password) {
        return adminDAO.login(username, password);
    }
}
