package cu.edu.cujae.structdb.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    }

}

