package services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.MedicalTest;

public class MedicalTestService {
	public List<MedicalTest> listMedicalTests(String name, String code, float value) throws SQLException, IOException {
		List<MedicalTest> medicalTests = new ArrayList<MedicalTest>();
		
		medicalTests.add(new MedicalTest("safdsa", "pipipi", 10.0, "popopo"));
		
		if (name != "") {}
		if (value != -1.0) {}
		if (code != "") {}
		
		//TODO: chamar dao
		
		return medicalTests;
	}
	
	public void insert(MedicalTest medicalTest) throws SQLException, IOException {
		//TODO: chamar dao
	}
}
