package services;

import java.util.ArrayList;
import java.util.List;

import entities.MedicalTestOrder;

public class MedicalTestOrderService {
	public List<MedicalTestOrder> listSpecialties(String pacient, String doctor, String medicalTest){
		List<MedicalTestOrder> medicalTestOrders = new ArrayList<MedicalTestOrder>();
		
		if (pacient != "") {}
		if (doctor != "") {}
		if (medicalTest != "") {}
		
		// database code - build search string in ifs
		
		return medicalTestOrders;
	}
	
	public void insert(MedicalTestOrder medicalTestOrder) {
		// ...
	}
}
