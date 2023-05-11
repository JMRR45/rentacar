package cu.edu.cujae.structdb.dto.model;

import java.time.LocalDate;

public class ContractDTO {
    private int id;
    private String plate;
    private String passport;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate deliveryDate;
    private AuxiliaryDTO payMethod;
    private String driver;

    public ContractDTO() {
    }

    public ContractDTO(int id, String plate, String passport, LocalDate startDate, LocalDate endDate, LocalDate deliveryDate, AuxiliaryDTO payMethod, String driver) {
        this.id = id;
        this.plate = plate;
        this.passport = passport;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deliveryDate = deliveryDate;
        this.payMethod = payMethod;
        this.driver = driver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public AuxiliaryDTO getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(AuxiliaryDTO payMethod) {
        this.payMethod = payMethod;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}
