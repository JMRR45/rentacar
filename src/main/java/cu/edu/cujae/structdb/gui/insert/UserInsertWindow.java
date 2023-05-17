/*
 * Created by JFormDesigner on Tue May 16 17:35:34 CDT 2023
 */

package cu.edu.cujae.structdb.gui.insert;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;

import cu.edu.cujae.structdb.dto.model.RolDTO;
import cu.edu.cujae.structdb.dto.model.UserDTO;
import cu.edu.cujae.structdb.gui.ViewWindow;
import cu.edu.cujae.structdb.services.ServicesLocator;
import net.miginfocom.swing.*;

/**
 * @author carlosd.inc
 */
public class UserInsertWindow extends JDialog {
    private UserDTO dto;
    private List<RolDTO> roles;
    private boolean isUpdating;
    public UserInsertWindow(Window owner, UserDTO dto) {
        super(owner);
        initComponents();
        setLocationRelativeTo(null);
        this.dto = dto;
        isUpdating = dto.getId() != null;
        this.setTitle("Crear nuevo usuario.");
        roles = ServicesLocator.rolServices().getAll();
        for (RolDTO rol : roles) {
            cmBox.addItem(rol.getName());
        }
    }

    private void cancel(ActionEvent e) {
        this.dispose();
    }

    private void ok(ActionEvent e) {
        if (txtFld.getText().isBlank()) {
            JOptionPane.showMessageDialog(okButton, "Debe introducir un nombre de usuario.");
            return;
        }
        dto.setUsername(txtFld.getText());
        dto.setRol(roles.get(cmBox.getSelectedIndex()));
        ServicesLocator.userServices().insert(dto);
        Window owner = getOwner();
        if (owner instanceof ViewWindow) {
            ((ViewWindow) owner).tableRefreshUser();
        }
        JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente.");
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Carlos Daniel Robaina Rivero
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        txtFld = new JTextField();
        label2 = new JLabel();
        cmBox = new JComboBox();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setModal(true);
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (
            new javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn"
            , javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
            , new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 )
            , java. awt. Color. red) ,dialogPane. getBorder( )) ); dialogPane. addPropertyChangeListener (
            new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
            ; }} );
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new MigLayout(
                    "insets dialog,hidemode 3",
                    // columns
                    "[fill]" +
                    "[grow,fill]",
                    // rows
                    "[]" +
                    "[]"));

                //---- label1 ----
                label1.setText("Nombre de Usuario: ");
                contentPanel.add(label1, "cell 0 0");
                contentPanel.add(txtFld, "cell 1 0");

                //---- label2 ----
                label2.setText("Rol: ");
                contentPanel.add(label2, "cell 0 1");
                contentPanel.add(cmBox, "cell 1 1");
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setLayout(new MigLayout(
                    "insets dialog,alignx right",
                    // columns
                    "[button,fill]" +
                    "[button,fill]",
                    // rows
                    null));

                //---- okButton ----
                okButton.setText("OK");
                okButton.addActionListener(e -> ok(e));
                buttonBar.add(okButton, "cell 0 0");

                //---- cancelButton ----
                cancelButton.setText("Cancel");
                cancelButton.addActionListener(e -> cancel(e));
                buttonBar.add(cancelButton, "cell 1 0");
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Carlos Daniel Robaina Rivero
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JTextField txtFld;
    private JLabel label2;
    private JComboBox cmBox;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
