package cu.edu.cujae.structdb.dto.report;

import cu.edu.cujae.structdb.dto.AbstractDTO;

import java.util.LinkedList;
import java.util.List;

public class CarSituationListDTO extends AbstractDTO {
    private List<CarSituationDTO> carSituationList;

    public CarSituationListDTO(List<CarSituationDTO> carSituationList) {
        super();
        this.carSituationList = new LinkedList<CarSituationDTO>(carSituationList);
    }
}
