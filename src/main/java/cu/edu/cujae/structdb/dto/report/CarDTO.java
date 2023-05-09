package cu.edu.cujae.structdb.dto.report;

import cu.edu.cujae.structdb.dto.AbstractDTO;

public class CarDTO extends AbstractDTO {
    private int numberPlate;
    private String brand;
    private String model;
    private String color;
    private double kmTraveled;


    public CarDTO(int numberPlate, String brand, String model, String color, double kmTraveled) {
        super();
        this.numberPlate = numberPlate;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.kmTraveled = kmTraveled;
    }

    public int getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(int numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getKmTraveled() {
        return kmTraveled;
    }

    public void setKmTraveled(double kmTraveled) {
        this.kmTraveled = kmTraveled;
    }

}
