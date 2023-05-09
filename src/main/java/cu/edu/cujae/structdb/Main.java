package cu.edu.cujae.structdb;

import cu.edu.cujae.structdb.dto.crud.TouristDTO;
import cu.edu.cujae.structdb.services.ServicesLocator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!\n");

        TouristDTO dto = new TouristDTO();
        dto.setPassport("ABC070807");
        dto.setAge(25);
        dto.setName("Lidia Oropesa");
        dto.setSex("F");
        dto.setContact("+34345234098");
        dto.setCountry(5);

        ServicesLocator.TouristServices().update(dto);
    }
}