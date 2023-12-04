package services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Address;
import entities.Patient;

public class PatientService {
	public List<Patient> listPatients(String name, String gender, String payMethod, String phone) throws SQLException, IOException {
		List<Patient> patients = new ArrayList<Patient>();
		patients.add(new Patient(1, "Jose", "01/01/01", "any", "0123012310", "9871979891", 
				new Address(1, 78976, "anywhere", "jardim carvalho", "ponta grossa", "pr"), 2, "popopo", "c"));
		
		//TODO: chamar dao
		
		return patients;
	}
	
	public void insert(Patient patient) throws SQLException, IOException {
		AddressService as = new AddressService();
		as.insert(patient.getAddress());
		
		PersonService ps = new PersonService();
		ps.insert(patient);
		
		//TODO: chamar dao
	}
}
