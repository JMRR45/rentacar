package cu.edu.cujae.structdb.dto.report;

import cu.edu.cujae.structdb.dto.AbstractDTO;

import java.util.List;

public class DefaultingTouristListDTO extends AbstractDTO {
    List<DefaultingTouristDTO> defaultingTouristList;

    public DefaultingTouristListDTO(List<DefaultingTouristDTO> defaultingTouristList) {
        super();
        this.defaultingTouristList = defaultingTouristList;
    }
}
