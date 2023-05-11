package cu.edu.cujae.structdb.services;

import cu.edu.cujae.structdb.dto.model.CarDTO;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CarService {
    public void insert(CarDTO dto) {
        String function = "{call add_car(?, ?, ?, ?, ?)}";
        try {
            Connection con = ServicesLocator.getConnection();
            CallableStatement call = con.prepareCall(function);
            call.setString(1, dto.getPlate());
            call.setInt(2, dto.getModel().getId());
            call.setInt(3, dto.getCantKm());
            call.setString(4, dto.getColor());
            call.setInt(5, dto.getSituation().getId());

            call.execute();
            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remove(String plate) {
        String function = "{call remove_car(?)}";
        try {
            Connection con = ServicesLocator.getConnection();
            CallableStatement call = con.prepareCall(function);
            call.setString(1, plate);
            call.execute();

            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(CarDTO dto) {
        String function = "{call update_car(?, ?, ?, ?, ?)}";
        try {
            Connection con = ServicesLocator.getConnection();
            CallableStatement call = con.prepareCall(function);
            call.setString(1, dto.getPlate());
            call.setInt(2, dto.getModel().getId());
            call.setInt(3, dto.getCantKm());
            call.setString(4, dto.getColor());
            call.setInt(5, dto.getSituation().getId());

            call.execute();
            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CarDTO> getAll() {
        List<CarDTO> list = new LinkedList<>();
        String function = "{?= call get_cars()}";
        try {
            Connection con = ServicesLocator.getConnection();
            con.setAutoCommit(false);
            CallableStatement call = con.prepareCall(function);
            call.registerOutParameter(1, Types.OTHER);
            call.execute();

            ResultSet resultSet = (ResultSet) call.getObject(1);
            if (resultSet == null) {
                return null;
            }
            while (resultSet.next()) {
                CarDTO dto = new CarDTO();
                dto.setPlate(resultSet.getString(1));
                dto.setModel(ServicesLocator.modelServices().getByID(resultSet.getInt(2)));
                dto.setCantKm(resultSet.getInt(3));
                dto.setColor(resultSet.getString(4));
                dto.setSituation(ServicesLocator.situationServices().getByID(resultSet.getInt(5)));
                list.add(dto);
            }
            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public CarDTO getByPlate(String plate) {
        CarDTO dto = new CarDTO();
        dto.setPlate(plate);
        String function = "{?= call get_car_by_plate(?)}";
        try {
            Connection con = ServicesLocator.getConnection();
            con.setAutoCommit(false);
            CallableStatement call = con.prepareCall(function);
            call.registerOutParameter(1, Types.OTHER);
            call.setString(2, plate);
            call.execute();

            ResultSet resultSet = (ResultSet) call.getObject(1);
            if (resultSet == null) {
                return null;
            }
            if (resultSet.next()) {
                dto.setModel(ServicesLocator.modelServices().getByID(resultSet.getInt(2)));
                dto.setCantKm(resultSet.getInt(3));
                dto.setColor(resultSet.getString(4));
                dto.setSituation(ServicesLocator.situationServices().getByID(resultSet.getInt(5)));
            }
            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dto;
    }
}
