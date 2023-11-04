package entities;

import java.util.Date;

public class MedicalTestOrder {
    private MedicalTest test;
    private Patient patient;
    private Doctor doctor;
    private Date testDate;
    private double valuePaid;

    public MedicalTestOrder(MedicalTest test, Patient patient, Doctor doctor, Date testDate, double testValuePaid) {
        this.test = test;
        this.patient = patient;
        this.doctor = doctor;
        this.testDate = testDate;
        this.valuePaid = testValuePaid;
    }

    // Getters and setters for the attributes
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

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public double getTestValuePaid() {
        return valuePaid;
    }

    public void setTestValuePaid(double testValuePaid) {
        this.valuePaid = testValuePaid;
    }

    @Override
    public String toString() {
        return "MedicalTestOrder{" +
                "test='" + test + '\'' +
                ", patient='" + patient + '\'' +
                ", doctor='" + doctor + '\'' +
                ", testDate=" + testDate +
                ", testValuePaid=" + valuePaid +
                '}';
    }
}
