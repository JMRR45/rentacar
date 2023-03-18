package cu.edu.cujae.structdb.dto;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class CarListDTO extends AbstractDTO{
    private List<CarDTO> carsList;
    public CarListDTO(LocalDate date, List<CarDTO> carsList) {
        super(date);
        this.carsList = new LinkedList<CarDTO>(carsList);
    }
}
