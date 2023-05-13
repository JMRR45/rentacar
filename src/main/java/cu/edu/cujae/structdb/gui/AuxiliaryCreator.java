package cu.edu.cujae.structdb.gui;

import cu.edu.cujae.structdb.dto.model.*;
import cu.edu.cujae.structdb.dto.model.DriverDTO;
import cu.edu.cujae.structdb.dto.model.TouristDTO;
import cu.edu.cujae.structdb.services.ServicesLocator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class AuxiliaryCreator extends JFrame {
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
    private JButton addRowTourist;
    private JButton addRowContract;
    private JButton addRowDriver;
    private JButton addRowCar;
    private JButton cancelarButton;
    private DefaultTableModel touristDTM;
    private DefaultTableModel carDTM;
    private DefaultTableModel driverDTM;
    private DefaultTableModel contractDTM;

    public AuxiliaryCreator() {
        super("Rent A Car");
        setContentPane(creatorPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(800, 600);
        setLocationRelativeTo(null);

        initializateComponents();
        activateActionListeners();
        setVisible(true);
    }

    private void activateActionListeners() {
        touristRB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                touristTable.enable();
                addRowTourist.enable();

                cleanTables(carDTM);
                cleanTables(driverDTM);
                cleanTables(contractDTM);

                carTable.disable();
                contractTable.disable();
                driverTable.disable();

                addRowCar.disable();
                addRowContract.disable();
                addRowDriver.disable();
            }
        });

        carRB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carTable.enable();
                addRowCar.enable();

                cleanTables(driverDTM);
                cleanTables(touristDTM);
                cleanTables(contractDTM);

                driverTable.disable();
                contractTable.disable();
                touristTable.disable();

                addRowDriver.disable();
                addRowContract.disable();
                addRowTourist.disable();
            }
        });

        driverRB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                driverTable.enable();
                addRowDriver.enable();

                cleanTables(carDTM);
                cleanTables(touristDTM);
                cleanTables(contractDTM);

                carTable.disable();
                contractTable.disable();
                touristTable.disable();

                addRowCar.disable();
                addRowContract.disable();
                addRowTourist.disable();
            }
        });

        contractRB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contractTable.enable();
                addRowContract.enable();

                cleanTables(carDTM);
                cleanTables(touristDTM);
                cleanTables(driverDTM);

                carTable.disable();
                driverTable.disable();
                touristTable.disable();

                addRowCar.disable();
                addRowDriver.disable();
                addRowTourist.disable();
            }
        });

        addRowCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(carRB.isSelected()) {
                    carDTM.addRow(new Object[]{""});
                }
            }
        });
        addRowContract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(contractRB.isSelected()) {
                    contractDTM.addRow(new Object[]{""});
                }
            }
        });
        addRowTourist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(touristRB.isSelected()) {
                    touristDTM.addRow(new Object[]{""});
                }
            }
        });
        addRowDriver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(driverRB.isSelected()) {
                    driverDTM.addRow(new Object[]{""});
                }
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (touristRB.isSelected()) {
                    addTouristDTO();
                }
                if (carRB.isSelected()) {
                    addCarDTO();
                }
                if (driverRB.isSelected()) {
                    addDriverDTO();
                }
                if (contractRB.isSelected()) {
                    addContractDTO();
                }
            }
        });
    }
    private void addCarDTO(){
        CarDTO a = new CarDTO();
        for(int i = 0; i < carDTM.getRowCount(); i++){
            a.setPlate((String) carDTM.getValueAt(i,0));
            //a.setModel(Integer.parseInt((String) carDTM.getValueAt(i,1)));
            a.setCantKm(Integer.parseInt((String) carDTM.getValueAt(i,2)));
            a.setColor((String) carDTM.getValueAt(i,3));
            //a.setSituation(Integer.parseInt((String)  carDTM.getValueAt(i,4)));
            ServicesLocator.carServices().insert(a);
        }
    }
    private void addTouristDTO(){
        TouristDTO a = new TouristDTO();
        for(int i = 0; i < touristDTM.getRowCount(); i++){
            a.setPassport((String) touristDTM.getValueAt(i,0));
            a.setName((String) touristDTM.getValueAt(i,1));
            a.setAge(Integer.parseInt((String) touristDTM.getValueAt(i,2)));
            a.setSex((String) touristDTM.getValueAt(i,3));
            a.setContact((String) touristDTM.getValueAt(i,4));
            //a.setCountry(Integer.parseInt((String)touristDTM.getValueAt(i,5)));
            ServicesLocator.touristServices().insert(a);
        }
    }

    private void addContractDTO(){
        ContractDTO a = new ContractDTO();
        for(int i = 0; i < contractDTM.getRowCount(); i++){
            a.setPlate((String) contractDTM.getValueAt(i,1));
            a.setPassport((String) contractDTM.getValueAt(i,2));
            a.setStartDate(LocalDate.parse((String) contractDTM.getValueAt(i,3)));
            a.setEndDate(LocalDate.parse((String) contractDTM.getValueAt(i,4)));
            a.setDeliveryDate(LocalDate.parse((String) contractDTM.getValueAt(i,5)));
            //a.setPayMethod(Integer.parseInt((String) contractDTM.getValueAt(i,6)));
            a.setDriver((String) contractDTM.getValueAt(i,7));
            ServicesLocator.contractServices().insert(a);
        }
    }
    private void addDriverDTO(){
        DriverDTO a = new DriverDTO();
        for(int i = 0; i < driverDTM.getRowCount(); i++){
            a.setDni((String) driverDTM.getValueAt(i,0));
            a.setName((String) driverDTM.getValueAt(i,1));
            //a.setCategory(Integer.parseInt((String) driverDTM.getValueAt(i,2)));
            a.setAddress((String) driverDTM.getValueAt(i,3));
            ServicesLocator.driverServices().insert(a);
        }
    }


    private void cleanTables(DefaultTableModel a){
        int max = a.getRowCount();
        for(int i = 0; i < max; i++){
            a.removeRow(0);
        }
    }

    private void initializateComponents() {
        ButtonGroup group = new ButtonGroup();
        group.add(touristRB);
        group.add(carRB);
        group.add(driverRB);
        group.add(contractRB);
        DeclareTableModels();
        touristTable.setModel(touristDTM);
        touristTable.disable();

        carTable.setModel(carDTM);
        carTable.disable();

        driverTable.setModel(driverDTM);
        driverTable.disable();

        contractTable.setModel(contractDTM);
        contractTable.disable();

    }
        private void DeclareTableModels () {
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
    }
