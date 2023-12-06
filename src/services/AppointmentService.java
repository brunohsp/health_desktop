package services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AppointmentDAO;
import dao.DataBase;
import dao.DoctorDAO;
import entities.Address;
import entities.Appointment;
import entities.Doctor;
import entities.Patient;

public class AppointmentService {
	
	public AppointmentService () {
		
	}
	
	
	public List<Appointment> listAppointments() throws SQLException, IOException {
		
		Connection conn = DataBase.conectar();
		
		
		List<Appointment> appointments = new AppointmentDAO(conn).buscarTodosConsulta();
		
		AppointmentService appointmentService = new AppointmentService();
		
		for (Appointment appointment : appointments) {
			// Appointment consulta = AppointmentService.buscarTodosConsulta();
		}
		
		return appointments;
	}
	
	public void insert(Appointment appointment) throws SQLException, IOException{
		
		Connection conn = DataBase.conectar();
		new AppointmentDAO(conn).cadastrarConsulta(appointment);
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
