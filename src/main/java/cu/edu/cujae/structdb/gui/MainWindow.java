package cu.edu.cujae.structdb.gui;


import cu.edu.cujae.structdb.dto.model.*;
import cu.edu.cujae.structdb.dto.model.CarDTO;
import cu.edu.cujae.structdb.dto.model.TouristDTO;
import cu.edu.cujae.structdb.services.ServicesLocator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
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
    private JButton updButton;
    private DefaultTableModel touristDTM;
    private DefaultTableModel carDTM;
    private DefaultTableModel driverDTM;
    private DefaultTableModel contractDTM;

    private Point initialClick;
    public MainWindow(){
        super("Rent A Car");
        // This puts the JFrame inside the regular Windows Frame
        pack();
        // This is the rest of your code, i comment the setUndecorated method because it breaks the app :D
        setContentPane(bg);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setUndecorated(true);
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
                fillCarTable();
            }
        });
        driverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principalTable.setModel(driverDTM);
                fillDriverTable();
            }
        });
        contractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                principalTable.setModel(contractDTM);
                fillContractTable();
            }
        });

        xButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AuxiliaryCreator();
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(principalTable.getModel()==touristDTM){
                    removeTourist();
                }
                if(principalTable.getModel()==carDTM){
                    removeCar();
                }
                if(principalTable.getModel()==driverDTM){
                    removeDriver();
                }
                if(principalTable.getModel()==contractDTM){
                    removeContract();
                }
            }
        });

        updButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(principalTable.getModel()==touristDTM && principalTable.getSelectedRow() != -1){
                    Object[] a = {touristDTM.getValueAt(principalTable.getSelectedRow(), 0),
                            touristDTM.getValueAt(principalTable.getSelectedRow(), 1),
                            touristDTM.getValueAt(principalTable.getSelectedRow(), 2),
                            touristDTM.getValueAt(principalTable.getSelectedRow(), 3),
                            touristDTM.getValueAt(principalTable.getSelectedRow(), 4),
                            touristDTM.getValueAt(principalTable.getSelectedRow(), 5)};
                    touristDTM.setRowCount(0);
                    touristDTM.addRow(a);
                    new UpdateWindow(touristDTM);
                }
                if(principalTable.getModel()==carDTM){
                    new UpdateWindow(carDTM);
                }
                if(principalTable.getModel()==driverDTM){
                    new UpdateWindow(driverDTM);
                }
                if(principalTable.getModel()==contractDTM){
                    new UpdateWindow(contractDTM);
                }
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
        List<TouristDTO> list = ServicesLocator.touristServices().getAll();
        for (TouristDTO a : list) {
            Object [] row = {a.getPassport(),a.getName(),a.getAge(),a.getSex(),a.getContact(),a.getCountry().getName()};
            touristDTM.addRow(row);
        }
    }
    private void fillCarTable(){
        carDTM.setRowCount(0);
        List<CarDTO> list = ServicesLocator.carServices().getAll();
        for (CarDTO a : list) {
            Object [] row = {a.getPlate(),a.getModel().getName(),a.getCantKm(),a.getColor(),a.getSituation().getName()};
            carDTM.addRow(row);
        }
    }
    private void fillDriverTable(){
        driverDTM.setRowCount(0);
        List<DriverDTO> list = ServicesLocator.driverServices().getAll();
        for (DriverDTO a : list) {
            Object [] row = {a.getDni(),a.getName(),a.getCategory().getName(),a.getAddress()};
            driverDTM.addRow(row);
        }
    }
    private void fillContractTable(){
        contractDTM.setRowCount(0);
        List<ContractDTO> list = ServicesLocator.contractServices().getAll();
        for (ContractDTO a : list) {
            Object [] row = {a.getPlate(), a.getStartDate(), a.getPassport(), a.getEndDate(), a.getDeliveryDate(), a.getPayMethod().getName(), a.getDriver()};
            contractDTM.addRow(row);
        }
    }
    private void removeTourist(){
        ServicesLocator.touristServices().remove((String)touristDTM.getValueAt(principalTable.getSelectedRow(), 0));
    }
    private void removeCar(){
        ServicesLocator.carServices().remove((String)carDTM.getValueAt(principalTable.getSelectedRow(), 0));
    }
    private void removeDriver(){
        ServicesLocator.driverServices().remove((String)driverDTM.getValueAt(principalTable.getSelectedRow(), 0));
    }
    private void removeContract(){
        ServicesLocator.contractServices().remove((String) (contractDTM.getValueAt(principalTable.getSelectedRow(), 0)), (LocalDate) contractDTM.getValueAt(principalTable.getSelectedRow(), 1));
    }
}

