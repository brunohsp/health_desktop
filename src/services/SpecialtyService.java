package services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DataBase;
import dao.DoctorDAO;
import dao.SpecialtyDAO;
import entities.Specialty;

public class SpecialtyService {
	
	public SpecialtyService () {
		
	}

	public List<Specialty> listSpecialties() throws SQLException, IOException {
		
		Connection conn = DataBase.conectar();		
		
		List<Specialty> specialties = new SpecialtyDAO(conn).buscarTodosEspecialidade();
		
		//SpecialtyService specialtyService = new SpecialtyService();
		
		
		
		return specialties;
	}
	
	public void insert(Specialty specialty) throws SQLException, IOException {
		
		Connection conn = DataBase.conectar();
		
		System.out.println(specialty);
		
		new SpecialtyDAO(conn).cadastrarEspecialidade(specialty);
		
	}
}
