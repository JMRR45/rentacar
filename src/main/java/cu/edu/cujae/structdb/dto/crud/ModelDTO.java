package cu.edu.cujae.structdb.dto.crud;

public class ModelDTO {
    private int id;
    private String name;
    private int brand;

    public ModelDTO() {
    }

    public ModelDTO(int id, String name, int brand) {
        this.id = id;
        this.name = name;
        this.brand = brand;
    }

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

    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }
}
