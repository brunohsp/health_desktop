package services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DataBase;
import dao.DoctorDAO;
import dao.MedicalTestDAO;
import entities.Doctor;
import entities.MedicalTest;

public class MedicalTestService {
	
	
	public MedicalTestService () {
		
	}
	
	public List<MedicalTest> listMedicalTests() throws SQLException, IOException {
		
		Connection conn = DataBase.conectar();
		
		
		List<MedicalTest> medicalTests = new MedicalTestDAO(conn).buscarTodosExame();
		
		MedicalTestService medicalTestService = new MedicalTestService();
		
		
		return medicalTests;
	}
	
	public void insert(MedicalTest medicalTest) throws SQLException, IOException {
		
		Connection conn = DataBase.conectar();
		new MedicalTestDAO(conn).cadastrarExame(medicalTest);
	}
}
