package cu.edu.cujae.structdb.dto;

import java.util.LinkedList;
import java.util.List;

public class CarSituationListDTO extends AbstractDTO {
    private List<CarSituationDTO> carSituationList;

    public CarSituationListDTO(List<CarSituationDTO> carSituationList) {
        super();
        this.carSituationList = new LinkedList<CarSituationDTO>(carSituationList);
    }
}
