package services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Address;
import entities.Appointment;
import entities.Doctor;
import entities.Patient;

public class AppointmentService {
	public List<Appointment> listAppointments(String doctor, String pacient, String date) throws SQLException, IOException {
		List<Appointment> appointments = new ArrayList<Appointment>();
		
		
		
		//TODO: chamar dao
		
		return appointments;
	}
	
	public void insert(Appointment appointment) throws SQLException, IOException{
		//TODO: chamar dao
	}
	
	public List<Appointment> getDoctorReport(Doctor doctor) throws SQLException, IOException{
		List<Appointment> appointments = new ArrayList<Appointment>();
		
		
		
		//TODO: chamar dao
		
		return appointments;
	}
}
