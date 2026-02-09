package com.Hospitalmanagement.HospitalManagementSystem.service;

import java.util.List;
import com.Hospitalmanagement.HospitalManagementSystem.model.Appointment;

public interface AppointmentService {
    boolean addAppointment(Appointment appointment);
    Appointment getAppointmentById(int appointmentId);
    List<Appointment> getAllAppointments();
    List<Appointment> getAppointmentsByPatient(int patientId);
    List<Appointment> getAppointmentsByDoctor(int doctorId);
    boolean updateAppointment(Appointment appointment);
    boolean deleteAppointment(int appointmentId);
}
