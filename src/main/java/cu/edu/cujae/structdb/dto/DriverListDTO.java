package cu.edu.cujae.structdb.dto;

import javax.swing.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class DriverListDTO extends AbstractDTO{
    List<DriverDTO> driversList;

    public DriverListDTO(LocalDate date, List<DriverDTO> driversList) {
        super(date);
        this.driversList = new LinkedList<DriverDTO>(driversList);
    }
}
