package entities;

public class Doctor {
    private String crmNumber;
    private String fullName;
    private String address;
    private String phoneNumber;
    private Specialty specialty;

    public Doctor(String crmNumber, String fullName, String address, String phoneNumber, Specialty specialty) {
        this.crmNumber = crmNumber;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.specialty = specialty;
    }

    public String getCrmNumber() {
        return crmNumber;
    }

    public void setCrmNumber(String crmNumber) {
        this.crmNumber = crmNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "crmNumber='" + crmNumber + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", specialty=" + specialty +
                '}';
    }
}
