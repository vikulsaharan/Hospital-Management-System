package com.Hospitalmanagement.HospitalManagementSystem.dao;

import java.util.List;
import com.Hospitalmanagement.HospitalManagementSystem.model.Appointment;

public interface AppointmentDAO {

    boolean addAppointment(Appointment appointment);

    Appointment getAppointmentById(int appointmentId);

    List<Appointment> getAllAppointments();

    List<Appointment> getAppointmentsByPatient(int patientId);

    List<Appointment> getAppointmentsByDoctor(int doctorId);

    boolean updateAppointment(Appointment appointment);

    boolean deleteAppointment(int appointmentId);
}
