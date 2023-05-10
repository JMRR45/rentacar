package cu.edu.cujae.structdb;

import cu.edu.cujae.structdb.dto.crud.TouristDTO;
import cu.edu.cujae.structdb.gui.MainWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame principalFrame = new MainWindow();


        TouristDTO dto = new TouristDTO();
        dto.setPassport("ABC070807");
        dto.setAge(25);
        dto.setName("Lidia Oropesa");
        dto.setSex("F");
        dto.setContact("+34345234098");
        dto.setCountry(5);
    }
}