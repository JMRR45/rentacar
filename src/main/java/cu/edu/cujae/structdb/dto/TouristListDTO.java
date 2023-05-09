package cu.edu.cujae.structdb.dto;

import java.util.LinkedList;
import java.util.List;

public class TouristListDTO extends AbstractDTO {
    private String country;
    private List<TouristReportDTO> touristList;

    public TouristListDTO(String country, List<TouristReportDTO> touristList) {
        super();
        this.country = country;
        this.touristList = new LinkedList<TouristReportDTO>(touristList);
    }
}
