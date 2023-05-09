package cu.edu.cujae.structdb.dto.report;

import cu.edu.cujae.structdb.dto.AbstractDTO;

import java.util.LinkedList;
import java.util.List;

public class DriverListDTO extends AbstractDTO {
    List<DriverDTO> driversList;

    public DriverListDTO(List<DriverDTO> driversList) {
        super();
        this.driversList = new LinkedList<DriverDTO>(driversList);
    }
}
