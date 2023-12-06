package services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DataBase;
import dao.DoctorDAO;
import dao.PatientDAO;
import entities.Address;
import entities.Doctor;
import entities.Patient;
import entities.Specialty;

public class DoctorService {
	
	public DoctorService () {
		
	}
	
	
	public List<Doctor> listDoctors() throws SQLException, IOException {
		
		
		Connection conn = DataBase.conectar();
		
		List<Doctor> medico = new DoctorDAO(conn).buscarTodosMedico();
		
		return medico;
	}
	
	public void insert(Doctor doctor) throws SQLException, IOException {
		Connection conn = DataBase.conectar();
		new DoctorDAO(conn).cadastrarMedico(doctor);
	}
}
