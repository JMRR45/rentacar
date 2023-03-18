package cu.edu.cujae.structdb.dto;

import javax.swing.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class CarSituationListDTO extends AbstractDTO {
    private List<CarSituationDTO> carSituationList;

    public CarSituationListDTO(LocalDate date, List<CarSituationDTO> carSituationList) {
        super(date);
        this.carSituationList = new LinkedList<CarSituationDTO>(carSituationList);
    }
}
