package cu.edu.cujae.structdb.dto;

public class TuristDTO {
    private String touristName;
    private String passportNumber;
    private int timesUsedCars;
    private double totalRentalsValue;
    private String country;

    public String getTouristName() {
        return touristName;
    }

    public void setTouristName(String touristName) {
        this.touristName = touristName;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public int getTimesUsedCars() {
        return timesUsedCars;
    }

    public void setTimesUsedCars(int timesUsedCars) {
        this.timesUsedCars = timesUsedCars;
    }

    public double getTotalRentalsValue() {
        return totalRentalsValue;
    }

    public void setTotalRentalsValue(double totalRentalsValue) {
        this.totalRentalsValue = totalRentalsValue;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public TuristDTO(String touristName, String passportNumber, int timesUsedCars, double totalRentalsValue, String country) {
        this.touristName = touristName;
        this.passportNumber = passportNumber;
        this.timesUsedCars = timesUsedCars;
        this.totalRentalsValue = totalRentalsValue;
        this.country = country;

    }
}
