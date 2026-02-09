package com.Hospitalmanagement.HospitalManagementSystem.service.impl;

import java.util.List;
import com.Hospitalmanagement.HospitalManagementSystem.dao.AppointmentDAO;
import com.Hospitalmanagement.HospitalManagementSystem.dao.impl.AppointmentDAOImpl;
import com.Hospitalmanagement.HospitalManagementSystem.model.Appointment;
import com.Hospitalmanagement.HospitalManagementSystem.service.AppointmentService;

public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentDAO appointmentDAO = new AppointmentDAOImpl();

    public boolean addAppointment(Appointment appointment) {
        return appointmentDAO.addAppointment(appointment);
    }

    public Appointment getAppointmentById(int appointmentId) {
        return appointmentDAO.getAppointmentById(appointmentId);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentDAO.getAllAppointments();
    }

    public List<Appointment> getAppointmentsByPatient(int patientId) {
        return appointmentDAO.getAppointmentsByPatient(patientId);
    }

    public List<Appointment> getAppointmentsByDoctor(int doctorId) {
        return appointmentDAO.getAppointmentsByDoctor(doctorId);
    }

    public boolean updateAppointment(Appointment appointment) {
        return appointmentDAO.updateAppointment(appointment);
    }

    public boolean deleteAppointment(int appointmentId) {
        return appointmentDAO.deleteAppointment(appointmentId);
    }
}
