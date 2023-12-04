package entities;

public class MedicalTest {
    private String code;
    private String name;
    private double value;
    private String instructions;

    public MedicalTest(String testCode, String testName, double testValue, String testInstructions) {
        this.code = testCode;
        this.name = testName;
        this.value = testValue;
        this.instructions = testInstructions;
    }

    // Getters and setters for the attributes
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setTestName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setTestValue(double value) {
        this.value = value;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setTestInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return name;
    }
}

