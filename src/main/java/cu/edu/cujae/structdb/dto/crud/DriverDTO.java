package cu.edu.cujae.structdb.dto.crud;

public class DriverDTO {
    private String dni;
    private String name;
    private int category;
    private String address;

    public DriverDTO() {
    }

    public DriverDTO(String dni, String name, int category, String address) {
        this.dni = dni;
        this.name = name;
        this.category = category;
        this.address = address;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
