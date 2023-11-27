package services;

import java.util.ArrayList;
import java.util.List;

import entities.Appointment;

public class AppointmentService {
	public List<Appointment> listSpecialties(String doctor, String pacient, String date){
		List<Appointment> appointments = new ArrayList<Appointment>();
		
		if (doctor == "") {}
		if (pacient == "") {}
		if (date == "") {}
		
		// database code - build search string in ifs
		
		return appointments;
	}
	
	public void insert(Appointment appointment) {
		
	}
}
