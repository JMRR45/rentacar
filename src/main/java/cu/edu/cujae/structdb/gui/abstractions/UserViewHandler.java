package cu.edu.cujae.structdb.gui.abstractions;

import cu.edu.cujae.structdb.dto.model.UserDTO;
import cu.edu.cujae.structdb.gui.GuiManager;
import cu.edu.cujae.structdb.services.ServicesLocator;
import cu.edu.cujae.structdb.utils.TableType;
import cu.edu.cujae.structdb.utils.exception.DeleteCurrentUserException;
import cu.edu.cujae.structdb.utils.exception.ForeignKeyException;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class UserViewHandler extends AbstractViewHandler {

    private List<UserDTO> list;

    @Override
    public String getTitle() {
        return "Ver Usuarios";
    }

    @Override
    public void setDTM(DefaultTableModel dtm) {
        dtm.addColumn("Nombre de Usuario");
        dtm.addColumn("Rol");
        refreshDTM(dtm);
    }

    @Override
    public void refreshDTM(DefaultTableModel dtm) {
        cleanDTM(dtm);
        list = ServicesLocator.userServices().getAll();
        if (list == null) {
            return;
        }
        for (UserDTO dto : list) {
            Object [] row = {dto.getUsername(), dto.getRol().getName()};
            dtm.addRow(row);
        }
    }

    @Override
    public void buttonDelete(DefaultTableModel dtm, int selection) throws ForeignKeyException, DeleteCurrentUserException {
        ServicesLocator.userServices().remove(list.get(selection).getId());
        refreshDTM(dtm);
    }

    @Override
    public void buttonInsert(DefaultTableModel dtm, TableType type, Window owner) {
        GuiManager.openDialog(GuiManager.DialogType.insertUser, owner, new UserDTO());
    }

    @Override
    public void buttonUpdate(DefaultTableModel dtm) {

    }
}
