package entities;

public class MedicalTest {
    private int id;	
    private String name;
    private double value;
    private String instructions;

    public MedicalTest(int id, String testName, double testValue, String testInstructions, String testCode) {
        this.id = id;    	
        this.name = testName;
        this.value = testValue;
        this.instructions = testInstructions;
    }
    
    public MedicalTest() {
        
    }

    // Getters and setters for the attributes

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

		
	@Override
    public String toString() {
        return name;
    }
	
}

