package cu.edu.cujae.structdb.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UpdateWindow extends JFrame {
    private JPanel principalPanel;
    private JButton addButton;
    private JTable principalTable;

    public UpdateWindow(DefaultTableModel model){
        super("Actualizar");
        setContentPane(principalPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(600, 200);
        setLocationRelativeTo(null);

        initializateComponents(model);
        activateActionListeners();
        setVisible(true);
    }
    private void initializateComponents(DefaultTableModel model){
        principalTable.setModel(model);
    }
    private void activateActionListeners(){

    }

}