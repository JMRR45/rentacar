package cu.edu.cujae.structdb.gui.abstractions;

import cu.edu.cujae.structdb.dto.model.RolDTO;
import cu.edu.cujae.structdb.services.ServicesLocator;
import cu.edu.cujae.structdb.utils.TableType;
import cu.edu.cujae.structdb.utils.exception.DeleteCurrentUserException;
import cu.edu.cujae.structdb.utils.exception.ForeignKeyException;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class RolViewHandler extends AbstractViewHandler{

    private List<RolDTO> list;
    @Override
    public String getTitle() {
        return "Ver Roles";
    }

    @Override
    public void setDTM(DefaultTableModel dtm) {
        dtm.addColumn("Nombre");
        dtm.addColumn("Descripción");
        refreshDTM(dtm);
    }

    @Override
    public void refreshDTM(DefaultTableModel dtm) {
        cleanDTM(dtm);
        list = ServicesLocator.rolServices().getAll();
        if (list == null) {
            return;
        }
        for (RolDTO dto : list) {
            Object [] row = {dto.getName(), dto.getDescription()};
            dtm.addRow(row);
        }
    }

    @Override
    public void buttonDelete(DefaultTableModel dtm, int selection) throws ForeignKeyException, DeleteCurrentUserException {
        ServicesLocator.rolServices().remove(list.get(selection).getId());
        refreshDTM(dtm);
    }

    @Override
    public void buttonInsert(DefaultTableModel dtm, TableType type, Window owner) {

    }

    @Override
    public void buttonUpdate(DefaultTableModel dtm) {

    }
}
