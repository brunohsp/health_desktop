package services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Address;
import entities.Doctor;
import entities.Specialty;

public class DoctorService {
	public List<Doctor> listDoctors(String name, Specialty specialty, String crm) throws SQLException, IOException {
		List<Doctor> doctors = new ArrayList<Doctor>();
		
		doctors.add(new Doctor(0, "rosberval", "01/01/01", "any", "8949849", "46494964", 
				new Address(1, 78976, "anywhere", "jardim carvalho", "ponta grossa", "pr"), 0, 0, 
				new Specialty(0, "teste")));
		
		
		//TODO: chamar dao
		
		return doctors;
	}
	
	public void insert(Doctor doctor) throws SQLException, IOException {
		AddressService as = new AddressService();
		as.insert(doctor.getAddress());
		
		PersonService ps = new PersonService();
		ps.insert(doctor);
		
		//TODO: chamar dao
	}
}
