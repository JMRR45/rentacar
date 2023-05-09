package cu.edu.cujae.structdb.dto.report;

import java.time.LocalDate;

public class DefaultingTouristDTO {
    private String name;
    private LocalDate realEndDate;
    private LocalDate contractEndDate;

    public DefaultingTouristDTO(String name, LocalDate realEndDate, LocalDate contractEndDate) {
        this.name = name;
        this.realEndDate = realEndDate;
        this.contractEndDate = contractEndDate;
    }
}
