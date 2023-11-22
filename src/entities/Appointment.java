package entities;

import java.util.Date;

public class Appointment {
	private int id;
	private Date appointmentDate;
	private String time;
    private Patient patient;
    private Doctor doctor;
	
    public Appointment(int id, Date appointmentDate, String time, Patient patient, Doctor doctor) {
		super();
		this.id = id;
		this.appointmentDate = appointmentDate;
		this.time = time;
		this.patient = patient;
		this.doctor = doctor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
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
    
    

    
}

