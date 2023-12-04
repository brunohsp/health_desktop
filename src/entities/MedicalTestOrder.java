package entities;

import java.util.Date;

public class MedicalTestOrder {
	private int id;
	private String testDate;
	private String time;
	private double valuePaid;
    private MedicalTest test;
    private Patient patient;
    private Doctor doctor;
	
    public MedicalTestOrder(int id, String testDate, String time, double valuePaid, MedicalTest test, Patient patient, Doctor doctor) {
		super();
		this.id = id;
		this.testDate = testDate;
		this.time = time;
		this.valuePaid = valuePaid;
		this.test = test;
		this.patient = patient;
		this.doctor = doctor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTestDate() {
		return testDate;
	}

	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getValuePaid() {
		return valuePaid;
	}

	public void setValuePaid(double valuePaid) {
		this.valuePaid = valuePaid;
	}

	public MedicalTest getTest() {
		return test;
	}

	public void setTest(MedicalTest test) {
		this.test = test;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

    
}
