package services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entities.Specialty;

public class SpecialtyService {

	public List<Specialty> listSpecialties(String code, String name) throws SQLException, IOException {
		List<Specialty> specialties = new ArrayList<Specialty>();
		specialties.add(new Specialty(1, "pipipi"));
		
		//TODO: chamar dao
		
		return specialties;
	}
	
	public void insert(Specialty specialty) throws SQLException, IOException {
		//TODO: chamar dao
	}
}
