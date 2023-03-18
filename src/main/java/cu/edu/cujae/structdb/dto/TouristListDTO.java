package cu.edu.cujae.structdb.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TouristListDTO extends AbstractDTO {
    private String country;
    private List<TouristDTO> touristList;

    public TouristListDTO(LocalDate date, String country, List<TouristDTO> touristList) {
        super(date);
        this.country = country;
        this.touristList = new LinkedList<TouristDTO>(touristList);
    }
}
