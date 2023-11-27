package services;

import java.util.ArrayList;
import java.util.List;

import entities.Patient;

public class PatientService {
	public List<Patient> listSpecialties(String name, String gender, String payMethod, String phone){
		List<Patient> patients = new ArrayList<Patient>();
		
		if (name != "") {}
		if (gender != "") {}
		if (payMethod != "") {}
		if (phone != "") {}
		
		// database code - build search string in ifs
		
		return patients;
	}
	
	public void insert(Patient patient) {
		AddressService as = new AddressService();
		as.insert(patient.getAddress());
		
		PersonService ps = new PersonService();
		ps.insert(patient);
		
		// ...
	}
}
