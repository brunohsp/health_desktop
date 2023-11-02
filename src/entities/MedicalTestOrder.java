package entities;

import java.util.Date;

public class MedicalTestOrder {
    private String testCode;
    private String patientName;
    private String doctorCrm;
    private Date testDate;
    private double valuePaid;

    public MedicalTestOrder(String testCode, String patientName, String doctorCrm, Date testDate, double testValuePaid) {
        this.testCode = testCode;
        this.patientName = patientName;
        this.doctorCrm = doctorCrm;
        this.testDate = testDate;
        this.valuePaid = testValuePaid;
    }

    // Getters and setters for the attributes
    public String getTestCode() {
        return testCode;
    }

    public void setTestCode(String testCode) {
        this.testCode = testCode;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorCrm() {
        return doctorCrm;
    }

    public void setDoctorCrm(String doctorCrm) {
        this.doctorCrm = doctorCrm;
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
                "testCode='" + testCode + '\'' +
                ", patientName='" + patientName + '\'' +
                ", doctorCrm='" + doctorCrm + '\'' +
                ", testDate=" + testDate +
                ", testValuePaid=" + valuePaid +
                '}';
    }
}

