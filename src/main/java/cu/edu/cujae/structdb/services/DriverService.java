package cu.edu.cujae.structdb.services;

import cu.edu.cujae.structdb.dto.crud.DriverDTO;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DriverService {
    public void insert(DriverDTO dto) {
        String function = "{call add_driver(?, ?, ?, ?)}";
        try {
            Connection con = ServicesLocator.getConnection();
            CallableStatement call = con.prepareCall(function);
            call.setString(1, dto.getDni());
            call.setString(2, dto.getName());
            call.setInt(3, dto.getCategory());
            call.setString(4, dto.getAddress());

            call.execute();
            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remove(String dni) {
        String function = "{call remove_driver(?)}";
        try {
            Connection con = ServicesLocator.getConnection();
            CallableStatement call = con.prepareCall(function);
            call.setString(1, dni);
            call.execute();

            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(DriverDTO dto) {
        String function = "{call update_driver(?, ?, ?, ?)}";
        try {
            Connection con = ServicesLocator.getConnection();
            CallableStatement call = con.prepareCall(function);
            call.setString(1, dto.getDni());
            call.setString(2, dto.getName());
            call.setInt(3, dto.getCategory());
            call.setString(4, dto.getAddress());

            call.execute();
            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<DriverDTO> getAll() {
        List<DriverDTO> list = new LinkedList<>();
        String function = "{?= call get_drivers()}";
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
                DriverDTO dto = new DriverDTO();
                dto.setDni(resultSet.getString(1));
                dto.setName(resultSet.getString(2));
                dto.setCategory(resultSet.getInt(3));
                dto.setAddress(resultSet.getString(4));
                list.add(dto);
            }
            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public DriverDTO getByDni(String dni) {
        DriverDTO dto = new DriverDTO();
        dto.setDni(dni);
        String function = "{?= call get_driver_by_dni(?)}";
        try {
            Connection con = ServicesLocator.getConnection();
            con.setAutoCommit(false);
            CallableStatement call = con.prepareCall(function);
            call.registerOutParameter(1, Types.OTHER);
            call.setString(2, dni);
            call.execute();

            ResultSet resultSet = (ResultSet) call.getObject(1);
            if (resultSet == null) {
                return null;
            }
            if (resultSet.next()) {
                dto.setName(resultSet.getString(2));
                dto.setCategory(resultSet.getInt(3));
                dto.setAddress(resultSet.getString(4));
            }
            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dto;
    }
}
