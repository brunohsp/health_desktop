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
		
		appointments.add(new Appointment(1, "12/43/2321", "00:00", 
				new Patient(1, "Jose", "01/01/01", "any", "0123012310", "9871979891", 
				new Address(1, 78976, "anywhere", "jardim carvalho", "ponto grossa", "pr"), 2, "popopo", "c"), 
				new Doctor(0, "rosberval", "01/01/01", "any", "8949849", "46494964", null, 0, 0, null)));
		
		//TODO: chamar dao
		
		return appointments;
	}
	
	public void insert(Appointment appointment) throws SQLException, IOException{
		//TODO: chamar dao
	}
	
	public List<Appointment> getDoctorReport(Doctor doctor) throws SQLException, IOException{
		List<Appointment> appointments = new ArrayList<Appointment>();
		
		appointments.add(new Appointment(1, "12/43/2321", "00:00", 
				new Patient(1, "Jose", "01/01/01", "any", "0123012310", "9871979891", 
				new Address(1, 78976, "anywhere", "jardim carvalho", "ponto grossa", "pr"), 2, "popopo", "c"), 
				new Doctor(0, "rosberval", "01/01/01", "any", "8949849", "46494964", null, 0, 0, null)));
		
		//TODO: chamar dao
		
		return appointments;
	}
}
