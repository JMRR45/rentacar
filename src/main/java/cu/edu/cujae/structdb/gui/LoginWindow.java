/*
 * Created by JFormDesigner on Fri May 12 09:35:46 CDT 2023
 */

package cu.edu.cujae.structdb.gui;

import cu.edu.cujae.structdb.dto.model.UserDTO;
import cu.edu.cujae.structdb.services.AuthService;
import cu.edu.cujae.structdb.services.ServicesLocator;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author cdrobaina01
 */
public class LoginWindow extends JFrame {
    public LoginWindow() {
        initComponents();
        lblError.setVisible(false);
    }

    private void btnLoginKeyPressed(KeyEvent e) {
        if (e.equals(KeyEvent.VK_ENTER)) {
            login();
        }
    }

    private void btnLogin(ActionEvent e) {
        login();
    }

    private void login() {
        lblError.setVisible(false);
        UserDTO credentials = new UserDTO();
        credentials.setUsername(txtFldUsername.getText());
        credentials.setPassword(String.valueOf(txtFldPassword.getPassword()));
        AuthService.LoginResult result = ServicesLocator.AuthService().login(credentials);
        switch (result) {
            case wrongUsername:
                lblError.setText("Error: Usuario Incorrecto");
                lblError.setVisible(true);
                break;
            case wrongPassword:
                lblError.setText("Error: Contraseña Incorrecta");
                lblError.setVisible(true);
                break;
            case correct:
                MainWindow main = new MainWindow();
                this.dispose();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Carlos Daniel Robaina Rivero
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        txtFldUsername = new JTextField();
        label2 = new JLabel();
        txtFldPassword = new JPasswordField();
        lblError = new JLabel();
        buttonBar = new JPanel();
        btnLogin = new JButton();

        //======== this ========
        setTitle("Inicio de Sesi\u00f3n");
        setResizable(false);
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(
            0,0,0,0), "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e",javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder
            .BOTTOM,new java.awt.Font("D\u0069al\u006fg",java.awt.Font.BOLD,12),java.awt.Color.
            red),dialogPane. getBorder()));dialogPane. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.
            beans.PropertyChangeEvent e){if("\u0062or\u0064er".equals(e.getPropertyName()))throw new RuntimeException();}});
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new MigLayout(
                    "insets dialog,hidemode 3",
                    // columns
                    "[left]" +
                    "[182,fill]",
                    // rows
                    "[]" +
                    "[]" +
                    "[]" +
                    "[]"));

                //---- label1 ----
                label1.setText("Nombre de Usuario");
                label1.setLabelFor(txtFldUsername);
                contentPanel.add(label1, "cell 0 0");
                contentPanel.add(txtFldUsername, "cell 1 0");

                //---- label2 ----
                label2.setText("Contrase\u00f1a");
                label2.setLabelFor(txtFldPassword);
                contentPanel.add(label2, "cell 0 1");
                contentPanel.add(txtFldPassword, "cell 1 1");

                //---- lblError ----
                lblError.setText("Error");
                lblError.setForeground(new Color(0xff3300));
                contentPanel.add(lblError, "cell 0 3 2 1,alignx center,growx 0");
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setLayout(new MigLayout(
                    "insets dialog,alignx right",
                    // columns
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[fill]" +
                    "[button,left]",
                    // rows
                    null));

                //---- btnLogin ----
                btnLogin.setText("Autenticarse");
                btnLogin.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        btnLoginKeyPressed(e);
                    }
                });
                btnLogin.addActionListener(e -> btnLogin(e));
                buttonBar.add(btnLogin, "cell 3 0");
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
    private JTextField txtFldUsername;
    private JLabel label2;
    private JPasswordField txtFldPassword;
    private JLabel lblError;
    private JPanel buttonBar;
    private JButton btnLogin;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
