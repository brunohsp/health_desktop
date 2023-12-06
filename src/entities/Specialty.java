package entities;

public class Specialty {
    private int id;
    private String name;
    
    public Specialty() {}
    
    public Specialty(String name) {
    	System.out.println(name);
    	this.name = name;
    }


    public String getSpecialtyName() {
        return this.name;
    }

    public void setSpecialtyName(String name) {
        this.name = name;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
    @Override
    public String toString() {
        return name;
    }

	
}
