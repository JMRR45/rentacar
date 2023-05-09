package cu.edu.cujae.structdb.dto.crud;

public class CarDTO {
    private String plate;
    private int model;
    private int cantKm;
    private String color;
    private int situation;

    public CarDTO() {
    }

    public CarDTO(String plate, int model, int cantKm, String color, int situation) {
        this.plate = plate;
        this.model = model;
        this.cantKm = cantKm;
        this.color = color;
        this.situation = situation;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getCantKm() {
        return cantKm;
    }

    public void setCantKm(int cantKm) {
        this.cantKm = cantKm;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSituation() {
        return situation;
    }

    public void setSituation(int situation) {
        this.situation = situation;
    }
}
