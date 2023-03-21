package cu.edu.cujae.structdb.dto;

public class CarSituationDTO extends AbstractDTO {
    private String numberPlate;
    private String brand;
    private String situation;
    private String contractEndDate;

    public CarSituationDTO(String numberPlate, String brand, String situation, String contractEndDate) {
        super();
        this.numberPlate = numberPlate;
        this.brand = brand;
        this.situation = situation;
        this.contractEndDate = contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public String getBrand() {
        return brand;
    }

    public String getSituation() {
        return situation;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }
}
