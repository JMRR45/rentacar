package cu.edu.cujae.structdb.dto;

import java.time.LocalDate;
import java.util.List;

public class DefaultingTouristListDTO extends AbstractDTO{
    List<DefaultingTouristDTO> defaultingTouristList;

    public DefaultingTouristListDTO(LocalDate date, List<DefaultingTouristDTO> defaultingTouristList) {
        super(date);
        this.defaultingTouristList = defaultingTouristList;
    }
}
