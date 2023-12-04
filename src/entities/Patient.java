package entities;

import java.util.Date;

public class Patient extends Person{
    private int id;
    private String photo; // URL or a file path for the photo
    private String paymentMethod;

	public Patient(int id, String name, String dateOfBirth, String gender, String cpf, String phoneNumber,
			Address address, int id2, String photo, String paymentMethod) {
		super(id, name, dateOfBirth, gender, cpf, phoneNumber, address);
		id = id2;
		this.photo = photo;
		this.paymentMethod = paymentMethod;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return getName();
	}



}
