package cu.edu.cujae.structdb.dto;

import java.util.List;

public class DefaultingTouristListDTO extends AbstractDTO {
    List<DefaultingTouristDTO> defaultingTouristList;

    public DefaultingTouristListDTO(List<DefaultingTouristDTO> defaultingTouristList) {
        super();
        this.defaultingTouristList = defaultingTouristList;
    }
}
