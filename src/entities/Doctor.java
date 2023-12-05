package entities;

import java.util.Date;

public class Doctor extends Person{
	private int id;
    private int crmNumber;
    private Specialty specialty;

	public Doctor(int id, String name, String dateOfBirth, String gender, String cpf, String phoneNumber, Address address,
			int id2, int crmNumber, Specialty specialty) {
		super(id, name, dateOfBirth, gender, cpf, phoneNumber, address);
		id = id2;
		this.crmNumber = crmNumber;
		this.specialty = specialty;
	}
	
	public Doctor() {
		super();		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCrmNumber() {
		return crmNumber;
	}

	public void setCrmNumber(int crmNumber) {
		this.crmNumber = crmNumber;
	}

	public Specialty getSpecialty() {
		return specialty;
	}

	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}

	@Override
	public String toString() {
		return "Dr." + getName() + "-" + id + " - CRM/" + crmNumber + " - " + specialty;
	}
	
	
    
}
