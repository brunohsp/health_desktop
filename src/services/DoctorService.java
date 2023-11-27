package services;

import java.util.ArrayList;
import java.util.List;

import entities.Doctor;
import entities.Specialty;

public class DoctorService {
	public List<Doctor> listSpecialties(String name, Specialty specialty, String crm){
		List<Doctor> doctors = new ArrayList<Doctor>();
		
		if (name != "") {}
		if (specialty != null) {}
		if (crm != "") {}
		
		// database code - build search string in ifs
		
		return doctors;
	}
	
	public void insert(Doctor doctor) {
		AddressService as = new AddressService();
		as.insert(doctor.getAddress());
		
		PersonService ps = new PersonService();
		ps.insert(doctor);
		
		// ...
	}
}
