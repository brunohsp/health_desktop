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
	
	
	public List<Patient> listarPaciente() throws SQLException, IOException {
		
		Connection conn = DataBase.conectar();
		
		List<Patient> patients = new PatientDAO(conn).buscarTodosPaciente();
		
		PatientService pacienteService = new PatientService();
		
		for (Patient patient : patients) {
			Patient paciente =  PatientService.buscarTodosPaciente();
			
		}
		
		
		return patients;
	}
	
	
	


	public void cadastrar(Patient paciente) throws SQLException, IOException {
		
		Connection conn = DataBase.conectar();
		
		new PatientDAO(conn).cadastrarPaciente(paciente);
		
		
	}
}
