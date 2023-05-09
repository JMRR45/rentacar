package cu.edu.cujae.structdb.dto.report;

import java.time.LocalDate;

public class ContractDTO {
    private String touristName;
    private String numberPlate;
    private String brand;
    private String model;
    private int paymentMethod;
    private LocalDate contractStartDate;
    private LocalDate contractEndDate;
    private int extensionDays;
    private boolean driverRental;
    private double totalAmount;

    public ContractDTO(String touristName, String numberPlate, String brand, String model, int paymentMethod, LocalDate contractStartDate, LocalDate contractEndDate, int extensionDays, boolean driverRental, double totalAmount) {
        this.touristName = touristName;
        this.numberPlate = numberPlate;
        this.brand = brand;
        this.model = model;
        this.paymentMethod = paymentMethod;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.extensionDays = extensionDays;
        this.driverRental = driverRental;
        this.totalAmount = totalAmount;
    }

    public String getTouristName() {
        return touristName;
    }

    public void setTouristName(String touristName) {
        this.touristName = touristName;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
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

    public int getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(LocalDate contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public LocalDate getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(LocalDate contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public int getExtensionDays() {
        return extensionDays;
    }

    public void setExtensionDays(int extensionDays) {
        this.extensionDays = extensionDays;
    }

    public boolean isDriverRental() {
        return driverRental;
    }

    public void setDriverRental(boolean driverRental) {
        this.driverRental = driverRental;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }


}
