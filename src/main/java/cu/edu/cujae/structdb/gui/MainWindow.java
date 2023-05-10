package cu.edu.cujae.structdb.gui;


import cu.edu.cujae.structdb.dto.crud.TouristDTO;
import cu.edu.cujae.structdb.services.ServicesLocator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class MainWindow extends JFrame{
    private JPanel bg;
    private JPanel leftPanel;
    private JPanel centerPanel;
    private JButton addButton;
    private JButton removeButton;
    private JButton touristButton;
    private JButton carButton;
    private JButton driverButton;
    private JButton contractButton;
    private JTable principalTable;
    private JPanel topCenterPanel;
    private JPanel exitCenterPanel;
    private JPanel tabCenterPanel;
    private JPanel tablePanel;
    private JButton xButton;
    private JScrollPane tableScrollPanel;
    private DefaultTableModel touristDTM;
    private DefaultTableModel carDTM;
    private DefaultTableModel driverDTM;
    private DefaultTableModel contractDTM;

    private Point initialClick;
    public MainWindow(){
        super("Rent A Car");
        setContentPane(bg);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);

        RunListeners();
        DeclareTableModels();

    }

    private void RunListeners(){
        getContentPane().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
                getComponentAt(initialClick);
            }
        });
        getContentPane().addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int thisX = getLocation().x;
                int thisY = getLocation().y;

                int xMoved = (thisX + e.getX()) - (thisX + initialClick.x);
                int yMoved = (thisY + e.getY()) - (thisY + initialClick.y);

                int X = thisX + xMoved;
                int Y = thisY + yMoved;
                setLocation(X, Y);
            }
        });

        touristButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principalTable.setModel(touristDTM);
                fillTouristTable();
            }
        });
        carButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principalTable.setModel(carDTM);
            }
        });
        driverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principalTable.setModel(driverDTM);
            }
        });
        contractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principalTable.setModel(contractDTM);
            }
        });

    }
    private void DeclareTableModels(){
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

    private void fillTouristTable(){
        touristDTM.setRowCount(0);
        List<TouristDTO> list = ServicesLocator.TouristServices().getAll();
        for (TouristDTO a : list) {
            Object [] row = {a.getPassport(),a.getName(),a.getAge(),a.getSex(),a.getContact(),a.getCountry()};
            touristDTM.addRow(row);
        }
    }

}

