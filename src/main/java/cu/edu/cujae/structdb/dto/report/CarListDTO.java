package cu.edu.cujae.structdb.dto.report;

import cu.edu.cujae.structdb.dto.AbstractDTO;

import java.util.LinkedList;
import java.util.List;

public class CarListDTO extends AbstractDTO {
    private List<CarDTO> carsList;

    public CarListDTO(List<CarDTO> carsList) {
        super();
        this.carsList = new LinkedList<CarDTO>(carsList);
    }
}
