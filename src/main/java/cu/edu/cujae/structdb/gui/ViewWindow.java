/*
 * Created by JFormDesigner on Fri May 12 22:06:42 CDT 2023
 */

package cu.edu.cujae.structdb.gui;

import cu.edu.cujae.structdb.dto.model.AuxiliaryDTO;
import cu.edu.cujae.structdb.dto.model.ModelDTO;
import cu.edu.cujae.structdb.dto.model.RolDTO;
import cu.edu.cujae.structdb.dto.model.UserDTO;
import cu.edu.cujae.structdb.services.ServicesLocator;
import cu.edu.cujae.structdb.utils.TableType;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cdrobaina01
 */
public class ViewWindow extends JDialog {

    private TableType type;
    private DefaultTableModel dtm;

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
        btnUpdate.setEnabled(false);
        dtm = new DefaultTableModel();
        dtm.addColumn("Nombre");
        tableUpdateAuxiliary();
    }

    private void setModelDTM() {
        btnUpdate.setEnabled(false);
        dtm = new DefaultTableModel();
        dtm.addColumn("Nombre");
        dtm.addColumn("Marca");
        tableUpdateModel();
    }

    private void setUserDTM() {
        btnUpdate.setEnabled(false);
        dtm = new DefaultTableModel();
        dtm.addColumn("Nombre de Usuario");
        dtm.addColumn("Rol");
        tableUpdateUser();
    }

    private void setRolDTM() {
        btnUpdate.setEnabled(false);
        dtm = new DefaultTableModel();
        dtm.addColumn("Nombre");
        dtm.addColumn("Descripción");
        tableUpdateRol();
    }

    private void tableUpdateAuxiliary() {
        List<AuxiliaryDTO> list = new LinkedList<>();
        switch (type) {
            case brand -> list = ServicesLocator.brandServices().getAll();
            case country -> list = ServicesLocator.countryServices().getAll();
            case category -> list = ServicesLocator.categoryServices().getAll();
            case paymethod -> list = ServicesLocator.payMethodServices().getAll();
            case situation -> list = ServicesLocator.situationServices().getAll();
        }
        for (AuxiliaryDTO dto : list) {
            Object [] row = {dto.getName()};
            dtm.addRow(row);
        }
    }

    private void tableUpdateModel() {
        List<ModelDTO> list = ServicesLocator.modelServices().getAll();
        for (ModelDTO dto : list) {
            Object [] row = {dto.getName(), dto.getBrand().getName()};
            dtm.addRow(row);
        }
    }

    private void tableUpdateUser() {
        List<UserDTO> list = ServicesLocator.userServices().getAll();
        for (UserDTO dto : list) {
            Object [] row = {dto.getUsername(), dto.getRol().getName()};
            dtm.addRow(row);
        }
    }

    private void tableUpdateRol() {
        List<RolDTO> list = ServicesLocator.rolServices().getAll();
        for (RolDTO dto : list) {
            Object [] row = {dto.getName(), dto.getDescription()};
            dtm.addRow(row);
        }
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
            scrollPane1.setViewportView(defaultTbl);
        }
        contentPane.add(scrollPane1, "cell 0 0 3 1");

        //---- btnInsert ----
        btnInsert.setText("Insertar");
        contentPane.add(btnInsert, "cell 0 1");

        //---- btnDelete ----
        btnDelete.setText("Eliminar");
        contentPane.add(btnDelete, "cell 1 1");

        //---- btnUpdate ----
        btnUpdate.setText("Actualizar");
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
