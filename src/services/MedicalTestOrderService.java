package services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Address;
import entities.Doctor;
import entities.MedicalTest;
import entities.MedicalTestOrder;
import entities.Patient;

public class MedicalTestOrderService {
	public List<MedicalTestOrder> listMedicalTestOrders(String pacient, String doctor, String medicalTest) throws SQLException, IOException {
		List<MedicalTestOrder> medicalTestOrders = new ArrayList<MedicalTestOrder>();
		
		medicalTestOrders.add(new MedicalTestOrder(0, "01/01/01", "00:00", 10.0, 
				new MedicalTest("safdsa", "pipipi", 10.0, "popopo"), 
				new Patient(1, "Jose", "01/01/01", "any", "0123012310", "9871979891", 
				new Address(1, 78976, "anywhere", "jardim carvalho", "ponto grossa", "pr"), 2, "popopo", "c"), 
				new Doctor(0, "rosberval", "01/01/01", "any", "8949849", "46494964", null, 0, 0, null)));
		
		//TODO: chamar dao
		
		return medicalTestOrders;
	}
	
	public void insert(MedicalTestOrder medicalTestOrder) throws SQLException, IOException {
		//TODO: chamar dao
	}
	
	public List<MedicalTestOrder> listMedicalTestReport(MedicalTest medicalTest) throws SQLException, IOException {
		List<MedicalTestOrder> medicalTestOrders = new ArrayList<MedicalTestOrder>();
		
		medicalTestOrders.add(new MedicalTestOrder(0, "01/01/01", "00:00", 10.0, 
				new MedicalTest("safdsa", "pipipi", 10.0, "popopo"), 
				new Patient(1, "Jose", "01/01/01", "any", "0123012310", "9871979891", 
				new Address(1, 78976, "anywhere", "jardim carvalho", "ponto grossa", "pr"), 2, "popopo", "c"), 
				new Doctor(0, "rosberval", "01/01/01", "any", "8949849", "46494964", null, 0, 0, null)));
		
		//TODO: chamar dao
		
		return medicalTestOrders;
	}
}
