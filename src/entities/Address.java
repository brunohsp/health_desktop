package entities;

public class Address {
	private int id;
	private int cep;
	private String location;
	private String neighborhood;
	private String city;
	private String uf;
	
	public Address(int id, int cep, String location, String neighborhood, String city, String uf) {
		super();
		this.id = id;
		this.cep = cep;
		this.location = location;
		this.neighborhood = neighborhood;
		this.city = city;
		this.uf = uf;
	}
	
	public Address() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
}
