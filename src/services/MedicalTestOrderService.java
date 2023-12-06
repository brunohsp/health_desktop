package services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DataBase;
import dao.DoctorDAO;
import dao.MedicalTestOrderDAO;
import entities.Address;
import entities.Doctor;
import entities.MedicalTest;
import entities.MedicalTestOrder;
import entities.Patient;

public class MedicalTestOrderService {
	
	public List<MedicalTestOrder> listMedicalTestOrders() throws SQLException, IOException {
		
		Connection conn = DataBase.conectar();
		List<MedicalTestOrder> medicalTestOrders = new MedicalTestOrderDAO(conn).buscarTodosPedidoExame();
		
		return medicalTestOrders;
	}
	
	public void insert(MedicalTestOrder medicalTestOrder) throws SQLException, IOException {
		
		Connection conn = DataBase.conectar();
		new MedicalTestOrderDAO(conn).cadastrarPedidoExame(medicalTestOrder);
	}
	
	public List<MedicalTestOrder> listMedicalTestReport(MedicalTest medicalTest) throws SQLException, IOException {
		List<MedicalTestOrder> medicalTestOrders = new ArrayList<MedicalTestOrder>();

		//TODO: chamar dao

		return medicalTestOrders;
	}
	
}
