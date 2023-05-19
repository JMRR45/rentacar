package cu.edu.cujae.structdb.gui.abstractions;

import cu.edu.cujae.structdb.utils.TableType;
import cu.edu.cujae.structdb.utils.exception.DeleteCurrentUserException;
import cu.edu.cujae.structdb.utils.exception.ForeignKeyException;

import javax.swing.table.DefaultTableModel;
import java.awt.*;

public abstract class AbstractViewHandler {
    public void cleanDTM(DefaultTableModel dtm) {
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
    }
    public abstract String getTitle();
    public abstract void setDTM(DefaultTableModel dtm);
    public abstract void refreshDTM(DefaultTableModel dtm);
    public abstract void buttonDelete(DefaultTableModel dtm, int selection) throws ForeignKeyException, DeleteCurrentUserException;
    public abstract void buttonInsert(DefaultTableModel dtm, TableType type, Window owner);
    public abstract void buttonUpdate(DefaultTableModel dtm, TableType type, Window owner, int selection);
}
