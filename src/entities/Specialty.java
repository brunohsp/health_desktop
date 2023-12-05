package entities;

public class Specialty {
    private int id;
	private int code;
    private String name;

    public Specialty(int id, int code, String name) {
        this.id = id;
    	this.code = code;
        this.name = name;
    }
    
    public Specialty() {
        
    }

    public int getSpecialtyCode() {
        return code;
    }

    public void setSpecialtyCode(int code) {
        this.code = code;
    }

    public String getSpecialtyName() {
        return name;
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
