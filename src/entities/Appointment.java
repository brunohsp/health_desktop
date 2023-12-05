package entities;

import java.util.Date;

public class Appointment {
	private int id;
	private String appointmentDate;
	private String time;
	private String payment;
    private Patient patient;
    private Doctor doctor;
	
    public Appointment(int id, String appointmentDate, String time, String payment, Patient patient, Doctor doctor) {
		super();
		this.id = id;
		this.appointmentDate = appointmentDate;
		this.time = time;
		this.payment = payment;
		this.patient = patient;
		this.doctor = doctor;
	}
    
    public Appointment() {
		super();		
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	
    
    

    
}

