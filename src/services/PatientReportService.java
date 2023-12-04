package services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Address;
import entities.Appointment;
import entities.Doctor;
import entities.MedicalTest;
import entities.MedicalTestOrder;
import entities.Patient;
import entities.PatientReport;

public class PatientReportService {
	public List<PatientReport> listPatientReports(Patient patient) throws SQLException, IOException {
		List<PatientReport> patientReports = new ArrayList<PatientReport>();
		
		patientReports.add(new PatientReport(
				new MedicalTestOrder(0, "01/01/01", "00:00", 10.0, 
				new MedicalTest("safdsa", "pipipi", 10.0, "popopo"), 
				new Patient(1, "Jose", "01/01/01", "any", "0123012310", "9871979891", 
				new Address(1, 78976, "anywhere", "jardim carvalho", "ponta grossa", "pr"), 2, "popopo", "c"), 
				new Doctor(0, "rosberval", "01/01/01", "any", "8949849", "46494964", null, 0, 0, null))));
		
		patientReports.add(new PatientReport(
				new Appointment(1, "12/43/2321", "00:00", 
				new Patient(1, "Jose", "01/01/01", "any", "0123012310", "9871979891", 
				new Address(1, 78976, "anywhere", "jardim carvalho", "ponta grossa", "pr"), 2, "popopo", "c"), 
				new Doctor(0, "rosberval", "01/01/01", "any", "8949849", "46494964", null, 0, 0, null))));
		
		//TODO: chamar dao
		
		return patientReports;
	}
}
