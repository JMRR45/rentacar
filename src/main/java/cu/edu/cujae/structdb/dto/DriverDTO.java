package cu.edu.cujae.structdb.dto;

public class DriverDTO {
        private String dni;
        private String name;
        private String address;
        private String category;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCarsDriven() {
        return carsDriven;
    }

    public void setCarsDriven(int carsDriven) {
        this.carsDriven = carsDriven;
    }

    private int carsDriven;

    public DriverDTO(String dni, String name, String address, String category, int carsDriven) {
        this.dni = dni;
        this.name = name;
        this.address = address;
        this.category = category;
        this.carsDriven = carsDriven;
    }
}
