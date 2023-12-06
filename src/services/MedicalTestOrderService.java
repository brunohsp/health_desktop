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
	
	public MedicalTestOrderService () {
		
	}
	
	
	public List<MedicalTestOrder> listMedicalTestOrders() throws SQLException, IOException {
		
		Connection conn = DataBase.conectar();
		
		
		List<MedicalTestOrder> medicalTestOrders = new MedicalTestOrderDAO(conn).buscarTodosPedidoExame();
		
		MedicalTestOrderService medicalTestOrderService = new MedicalTestOrderService();
		
		for (MedicalTestOrder medicalTestOrder : medicalTestOrders) {
			
			MedicalTestOrderService medicalTestOrderServices = MedicalTestOrderService.buscarTodosPedidoExame();
		}
		
		
		return medicalTestOrders;
	}
	
	public void insert(MedicalTestOrder medicalTestOrder) throws SQLException, IOException {
		
		Connection conn = DataBase.conectar();
		new MedicalTestOrderDAO(conn).cadastrarPedidoExame(medicalTestOrder);
	}
	
	
}
