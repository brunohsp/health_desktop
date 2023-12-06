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
			Appointment consulta = AppointmentService.buscarTodosConsulta();
		}
		
		return appointments;
	}
	
	public void insert(Appointment appointment) throws SQLException, IOException{
		
		Connection conn = DataBase.conectar();
		new AppointmentDAO(conn).cadastrarConsulta(appointment);
	}
	
	
}
