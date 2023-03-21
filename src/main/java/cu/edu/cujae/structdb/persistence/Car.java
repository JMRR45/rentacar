package cu.edu.cujae.structdb.persistence;

public class Car {
    public enum Situation {AVAILABLE, RENTED, WORKSHOP}

    private String plate;
    private String model;
    private String brand;
    private Situation situation;
    private String color;
    private double cantKm;

    public String getPlate() {
        return plate;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public Situation getSituation() {
        return situation;
    }

    public String getColor() {
        return color;
    }

    public double getCantKm() {
        return cantKm;
    }
}
