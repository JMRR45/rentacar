package cu.edu.cujae.structdb.dto;

import java.time.LocalDate;
import java.util.List;

public class ContractListDTO extends AbstractDTO{
    private List<ContractDTO> contractDTOList;

    public ContractListDTO(LocalDate date, List<ContractDTO> contractDTOList) {
        super(date);
        this.contractDTOList = contractDTOList;
    }
}
