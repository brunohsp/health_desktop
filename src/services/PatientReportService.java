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
		
		
		//TODO: chamar dao
		
		return patientReports;
	}
}
