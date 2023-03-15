package cu.edu.cujae.structdb.dto;

public class ContractDTO {
    private String touristName;
    private int numberPlate;
    private String brand;
    private String model;
    private String paymentMethod;
    private String contractStartDate;
    private String contractEndDate;
    private int extensionDays;
    private boolean driverRental;
    private double totalAmount;

    public ContractDTO(String touristName, int numberPlate, String brand, String model, String paymentMethod, String contractStartDate, String contractEndDate, int extensionDays, boolean driverRental, double totalAmount) {
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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
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
