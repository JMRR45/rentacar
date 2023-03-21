package cu.edu.cujae.structdb.dto;

import java.util.List;

public class ContractListDTO extends AbstractDTO {
    private List<ContractDTO> contractDTOList;

    public ContractListDTO(List<ContractDTO> contractDTOList) {
        super();
        this.contractDTOList = contractDTOList;
    }
}
