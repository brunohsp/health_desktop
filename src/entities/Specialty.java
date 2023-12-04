package entities;

public class Specialty {
    private int code;
    private String name;

    public Specialty(int code, String name) {
        this.code = code;
        this.name = name;
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

    @Override
    public String toString() {
        return name;
    }
}
