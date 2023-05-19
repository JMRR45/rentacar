/*
 * Created by JFormDesigner on Fri May 12 22:06:42 CDT 2023
 */

package cu.edu.cujae.structdb.gui.view;

import cu.edu.cujae.structdb.dto.model.AuxiliaryDTO;
import cu.edu.cujae.structdb.dto.model.ModelDTO;
import cu.edu.cujae.structdb.dto.model.RolDTO;
import cu.edu.cujae.structdb.dto.model.UserDTO;
import cu.edu.cujae.structdb.gui.insert.AuxiliaryInsertWindow;
import cu.edu.cujae.structdb.gui.insert.ModelInsertWindow;
import cu.edu.cujae.structdb.gui.insert.UserInsertWindow;
import cu.edu.cujae.structdb.services.ServicesLocator;
import cu.edu.cujae.structdb.utils.TableType;
import cu.edu.cujae.structdb.utils.exception.DeleteCurrentUserException;
import cu.edu.cujae.structdb.utils.exception.ForeignKeyException;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cdrobaina01
 */
public class ViewWindow extends JDialog {

    private TableType type;
    private DefaultTableModel dtm;
    private List<AuxiliaryDTO> auxiliaryList;
    private List<ModelDTO> modelList;
    private List<UserDTO> userList;
    private List<RolDTO> rolList;

    public ViewWindow(TableType type) {
        initComponents();
        this.type = type;
        String tableName = new String();
        switch (type) {
            case rol:
                tableName = "Roles";
                setRolDTM();
                break;
            case user:
                tableName = "Usuarios";
                setUserDTM();
                break;
            case brand:
                tableName = "Marcas";
                setAuxiliaryDTM();
                break;
            case model:
                tableName = "Modelos";
                setModelDTM();
                break;
            case situation:
                tableName = "Situación de los Autos";
                setAuxiliaryDTM();
                break;
            case category:
                tableName = "Categorías de Licencia";
                setAuxiliaryDTM();
                break;
            case paymethod:
                tableName = "Métodos de Pago";
                setAuxiliaryDTM();
                break;
            case country:
                tableName = "Procedencia de los Clientes";
                setAuxiliaryDTM();
                break;
        }
        this.setTitle("Ver " + tableName);
        defaultTbl.setModel(dtm);
    }

    private void setAuxiliaryDTM() {
        btnUpdate.setVisible(false);
        dtm = new DefaultTableModel();
        dtm.addColumn("Nombre");
        tableRefreshAuxiliary();
    }

    private void setModelDTM() {
        btnUpdate.setVisible(false);
        dtm = new DefaultTableModel();
        dtm.addColumn("Nombre");
        dtm.addColumn("Marca");
        tableRefreshModel();
    }

    private void setUserDTM() {
        dtm = new DefaultTableModel();
        dtm.addColumn("Nombre de Usuario");
        dtm.addColumn("Rol");
        tableRefreshUser();
    }

    private void setRolDTM() {
        btnInsert.setVisible(false);
        btnDelete.setVisible(false);
        dtm = new DefaultTableModel();
        dtm.addColumn("Nombre");
        dtm.addColumn("Descripción");
        tableRefreshRol();
    }

    public void cleanTable() {
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
    }

    public void tableRefreshAuxiliary() {
        cleanTable();
        auxiliaryList = new LinkedList<>();
        switch (type) {
            case brand -> auxiliaryList = ServicesLocator.brandServices().getAll();
            case country -> auxiliaryList = ServicesLocator.countryServices().getAll();
            case category -> auxiliaryList = ServicesLocator.categoryServices().getAll();
            case paymethod -> auxiliaryList = ServicesLocator.payMethodServices().getAll();
            case situation -> auxiliaryList = ServicesLocator.situationServices().getAll();
        }
        if (auxiliaryList == null) {
            return;
        }
        for (AuxiliaryDTO dto : auxiliaryList) {
            Object [] row = {dto.getName()};
            dtm.addRow(row);
        }
    }

    public void tableRefreshModel() {
        cleanTable();
        modelList = ServicesLocator.modelServices().getAll();
        if (modelList == null) {
            return;
        }
        for (ModelDTO dto : modelList) {
            Object [] row = {dto.getName(), dto.getBrand().getName()};
            dtm.addRow(row);
        }
    }

    public void tableRefreshUser() {
        cleanTable();
        userList = ServicesLocator.userServices().getAll();
        if (userList == null) {
            return;
        }
        for (UserDTO dto : userList) {
            Object [] row = {dto.getUsername(), dto.getRol().getName()};
            dtm.addRow(row);
        }
    }

    public void tableRefreshRol() {
        cleanTable();
        rolList = ServicesLocator.rolServices().getAll();
        if (rolList == null) {
            return;
        }
        for (RolDTO dto : rolList) {
            Object [] row = {dto.getName(), dto.getDescription()};
            dtm.addRow(row);
        }
    }

    private void btnDelete(ActionEvent e) {
        int selection = defaultTbl.getSelectedRow();
        if (selection == -1) {
            JOptionPane.showMessageDialog(btnDelete, "Debe seleccionar una entrada.");
            return;
        }
        int option = JOptionPane.showOptionDialog(btnDelete, "¿Está seguro que desea eliminar la entrada seleccionada?",
                "Confirmar Eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,
                new Object[] {"Sí", "No"},"No");
        if ( option != 0) {
            return;
        }
        try {
            switch (type) {
                case rol -> tableDeleteRol(selection);
                case user -> tableDeleteUser(selection);
                case model -> tableDeleteModel(selection);
                default -> tableDeleteAuxiliary(selection);
            }
        } catch (ForeignKeyException exception) {
            JOptionPane.showMessageDialog(this, "La entrada que desea eliminar es utilizada en otros campos.");
        } catch (DeleteCurrentUserException exception) {
            JOptionPane.showMessageDialog(this, "No se puede eliminar el usuario actual.");
        }
    }

    private void tableDeleteAuxiliary(int selection) throws ForeignKeyException {
        switch (type) {
            case brand -> ServicesLocator.brandServices().remove(auxiliaryList.get(selection).getName());
            case situation -> ServicesLocator.situationServices().remove(auxiliaryList.get(selection).getName());
            case category -> ServicesLocator.categoryServices().remove(auxiliaryList.get(selection).getName());
            case country -> ServicesLocator.countryServices().remove(auxiliaryList.get(selection).getName());
            case paymethod -> ServicesLocator.payMethodServices().remove(auxiliaryList.get(selection).getName());
        }
        tableRefreshAuxiliary();
    }

    private void tableDeleteModel(int selection) throws ForeignKeyException{
        ServicesLocator.modelServices().remove(modelList.get(selection).getName());
        tableRefreshModel();
    }

    private void tableDeleteUser(int selection) throws DeleteCurrentUserException{
        ServicesLocator.userServices().remove(userList.get(selection).getId());
        tableRefreshUser();
    }

    private void tableDeleteRol(int selection) {
        ServicesLocator.rolServices().remove(rolList.get(selection).getId());
        tableRefreshRol();
    }

    private void btnInsert(ActionEvent e) {
        switch (type) {
            case rol -> tableInsertRol();
            case user -> tableInsertUser();
            case model -> tableInsertModel();
            default -> tableInsertAuxiliary();
        }
    }

    private void tableInsertAuxiliary() {
        AuxiliaryInsertWindow dialog = new AuxiliaryInsertWindow(this, type);
        dialog.setVisible(true);
    }

    private void tableInsertModel() {
        ModelInsertWindow dialog = new ModelInsertWindow(this);
        dialog.setVisible(true);
    }

    private void tableInsertUser() {
        UserInsertWindow dialog = new UserInsertWindow(this, new UserDTO());
        dialog.setVisible(true);
    }

    private void tableInsertRol() {

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Carlos Daniel Robaina Rivero
        scrollPane1 = new JScrollPane();
        defaultTbl = new JTable();
        btnInsert = new JButton();
        btnDelete = new JButton();
        btnUpdate = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[147,grow,fill]" +
            "[142,grow,fill]" +
            "[grow,fill]",
            // rows
            "[]" +
            "[]" +
            "[]"));

        //======== scrollPane1 ========
        {

            //---- defaultTbl ----
            defaultTbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            scrollPane1.setViewportView(defaultTbl);
        }
        contentPane.add(scrollPane1, "cell 0 0 3 1");

        //---- btnInsert ----
        btnInsert.setText("Insertar");
        btnInsert.addActionListener(e -> btnInsert(e));
        contentPane.add(btnInsert, "cell 0 1");

        //---- btnDelete ----
        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(e -> btnDelete(e));
        contentPane.add(btnDelete, "cell 1 1");

        //---- btnUpdate ----
        btnUpdate.setText("Modificar");
        contentPane.add(btnUpdate, "cell 2 1");
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Carlos Daniel Robaina Rivero
    private JScrollPane scrollPane1;
    private JTable defaultTbl;
    private JButton btnInsert;
    private JButton btnDelete;
    private JButton btnUpdate;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
