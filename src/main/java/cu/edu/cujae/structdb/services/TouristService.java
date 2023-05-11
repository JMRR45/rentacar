package cu.edu.cujae.structdb.services;

import cu.edu.cujae.structdb.dto.model.TouristDTO;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class TouristService {
    public void insert(TouristDTO dto) {
        String function = "{call add_tourist(?, ?, ?, ?, ?, ?)}";
        try {
            Connection con = ServicesLocator.getConnection();
            CallableStatement call = con.prepareCall(function);
            call.setString(1, dto.getPassport());
            call.setString(2, dto.getName());
            call.setInt(3, dto.getAge());
            call.setString(4, dto.getSex());
            call.setString(5, dto.getContact());
            call.setInt(6, dto.getCountry().getId());

            call.execute();
            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remove(String passport) {
        String function = "{call remove_tourist(?)}";
        try {
            Connection con = ServicesLocator.getConnection();
            CallableStatement call = con.prepareCall(function);
            call.setString(1, passport);
            call.execute();

            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(TouristDTO dto) {
        String function = "{call update_tourist(?, ?, ?, ?, ?, ?)}";
        try {
            Connection con = ServicesLocator.getConnection();
            CallableStatement call = con.prepareCall(function);
            call.setString(1, dto.getPassport());
            call.setString(2, dto.getName());
            call.setInt(3, dto.getAge());
            call.setString(4, dto.getSex());
            call.setString(5, dto.getContact());
            call.setInt(6, dto.getCountry().getId());

            call.execute();
            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<TouristDTO> getAll() {
        List<TouristDTO> list = new LinkedList<>();
        String function = "{?= call get_tourists()}";
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
                TouristDTO dto = new TouristDTO();
                dto.setPassport(resultSet.getString(1));
                dto.setName(resultSet.getString(2));
                dto.setAge(resultSet.getInt(3));
                dto.setSex(resultSet.getString(4));
                dto.setContact(resultSet.getString(5));
                dto.setCountry(ServicesLocator.CountryServices().getByID(resultSet.getInt(6)));
                list.add(dto);
            }
            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public TouristDTO getByPassport(String passport) {
        TouristDTO dto = new TouristDTO();
        dto.setPassport(passport);
        String function = "{?= call get_tourist_by_passport(?)}";
        try {
            Connection con = ServicesLocator.getConnection();
            con.setAutoCommit(false);
            CallableStatement call = con.prepareCall(function);
            call.registerOutParameter(1, Types.OTHER);
            call.setString(2, passport);
            call.execute();
            ResultSet resultSet = (ResultSet) call.getObject(1);
            if (resultSet == null) {
                return null;
            }
            if (resultSet.next()) {
                dto.setName(resultSet.getString(2));
                dto.setAge(resultSet.getInt(3));
                dto.setSex(resultSet.getString(4));
                dto.setContact(resultSet.getString(5));
                dto.setCountry(ServicesLocator.CountryServices().getByID(resultSet.getInt(6)));
            }
            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dto;
    }
}
