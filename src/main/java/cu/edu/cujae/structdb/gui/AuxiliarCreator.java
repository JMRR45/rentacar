package cu.edu.cujae.structdb.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AuxiliarCreator extends JFrame {
    private JPanel creatorPanel;
    private JButton addButton;
    private JRadioButton touristRB;
    private JPanel touristPanel;
    private JPanel carPanel;
    private JPanel driverPanel;
    private JPanel contractPanel;
    private JRadioButton carRB;
    private JRadioButton driverRB;
    private JRadioButton contractRB;
    private JTable touristTable;
    private JTable carTable;
    private JTable driverTable;
    private JTable contractTable;
    private DefaultTableModel touristDTM;
    private DefaultTableModel carDTM;
    private DefaultTableModel driverDTM;
    private DefaultTableModel contractDTM;

    public AuxiliarCreator() {
        super("Rent A Car");
        setContentPane(creatorPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(800, 600);
        setLocationRelativeTo(null);

        initializateComponents();
        setVisible(true);
    }

    private void initializateComponents() {
        ButtonGroup group = new ButtonGroup();
        group.add(touristRB);
        group.add(carRB);
        group.add(driverRB);
        group.add(contractRB);
        DeclareTableModels();
        touristTable.setModel(touristDTM);
        touristDTM.addRow(new String[]{""});
        touristTable.disable();

        carTable.setModel(carDTM);
        carDTM.addRow(new String[]{""});
        carTable.disable();

        driverTable.setModel(driverDTM);
        driverDTM.addRow(new String[]{""});
        driverTable.disable();

        contractTable.setModel(contractDTM);
        contractDTM.addRow(new String[]{""});
        contractTable.disable();
    }

    private void DeclareTableModels() {
        touristDTM = new DefaultTableModel();
        touristDTM.addColumn("Pasaporte");
        touristDTM.addColumn("Nombre");
        touristDTM.addColumn("Edad");
        touristDTM.addColumn("Sexo");
        touristDTM.addColumn("Contacto");
        touristDTM.addColumn("País");

        carDTM = new DefaultTableModel();
        carDTM.addColumn("Matrícula");
        carDTM.addColumn("Modelo");
        carDTM.addColumn("Km");
        carDTM.addColumn("Color");
        carDTM.addColumn("Situación");

        driverDTM = new DefaultTableModel();
        driverDTM.addColumn("DNI");
        driverDTM.addColumn("Nombre");
        driverDTM.addColumn("Categoría");
        driverDTM.addColumn("Dirección");

        contractDTM = new DefaultTableModel();
        contractDTM.addColumn("ID");
        contractDTM.addColumn("Matrícula");
        contractDTM.addColumn("Pasaporte");
        contractDTM.addColumn("Fecha de inicio");
        contractDTM.addColumn("Fecha de fin");
        contractDTM.addColumn("Fecha de entrega");
        contractDTM.addColumn("Método de pago");
        contractDTM.addColumn("Conductor");
    }

}