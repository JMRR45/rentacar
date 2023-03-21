package cu.edu.cujae.structdb.dto;

import java.util.LinkedList;
import java.util.List;

public class DriverListDTO extends AbstractDTO {
    List<DriverDTO> driversList;

    public DriverListDTO(List<DriverDTO> driversList) {
        super();
        this.driversList = new LinkedList<DriverDTO>(driversList);
    }
}
