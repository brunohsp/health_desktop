package services;


import java.io.IOException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Address;
import entities.Patient;
import entities.Person;
import dao.DataBase;
import dao.PatientDAO;

public class PatientService {
	
	
	public PatientService() {
		
	}
	
	
	public List<Patient> listPatients() throws SQLException, IOException {
		
		Connection conn = DataBase.conectar();
		
		List<Patient> patients = new PatientDAO(conn).buscarTodosPaciente();
		
		
		return patients;
	}
	
	
	


	public void insert(Patient paciente) throws SQLException, IOException {
		
		Connection conn = DataBase.conectar();
		
		new PatientDAO(conn).cadastrarPaciente(paciente);
		
		
	}
}
