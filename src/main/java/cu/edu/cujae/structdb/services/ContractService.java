package cu.edu.cujae.structdb.services;

import cu.edu.cujae.structdb.dto.model.ContractDTO;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ContractService {
    public void insert(ContractDTO dto) {
        String function = "{call add_contract(?, ?, ?, ?, ?, ?, ?)}";
        try {
            Connection con = ServicesLocator.getConnection();
            CallableStatement call = con.prepareCall(function);
            call.setString(1, dto.getPlate());
            call.setString(2, dto.getPassport());
            call.setDate(3, new Date(dto.getStartDate().toEpochDay()));
            call.setDate(4, new Date(dto.getEndDate().toEpochDay()));
            call.setDate(5, new Date(dto.getDeliveryDate().toEpochDay()));
            call.setInt(6, dto.getPayMethod().getId());
            call.setString(7, dto.getDriver());

            call.execute();
            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remove(int id) {
        String function = "{call remove_contract(?)}";
        try {
            Connection con = ServicesLocator.getConnection();
            CallableStatement call = con.prepareCall(function);
            call.setInt(1, id);
            call.execute();

            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(ContractDTO dto) {
        String function = "{call update_contract(?, ?, ?, ?, ?, ?, ?)}";
        try {
            Connection con = ServicesLocator.getConnection();
            CallableStatement call = con.prepareCall(function);
            call.setString(1, dto.getPlate());
            call.setString(2, dto.getPassport());
            call.setDate(3, new Date(dto.getStartDate().toEpochDay()));
            call.setDate(4, new Date(dto.getEndDate().toEpochDay()));
            call.setDate(5, new Date(dto.getDeliveryDate().toEpochDay()));
            call.setInt(6, dto.getPayMethod().getId());
            call.setString(7, dto.getDriver());

            call.execute();
            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ContractDTO> getAll() {
        List<ContractDTO> list = new LinkedList<>();
        String function = "{?= call get_contracts()}";
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
                ContractDTO dto = new ContractDTO();
                dto.setId(resultSet.getInt(1));
                dto.setPlate(resultSet.getString(2));
                dto.setPassport(resultSet.getString(3));
                dto.setStartDate(resultSet.getDate(4).toLocalDate());
                dto.setEndDate(resultSet.getDate(5).toLocalDate());
                dto.setDeliveryDate(resultSet.getDate(6).toLocalDate());
                dto.setPayMethod(ServicesLocator.payMethodServices().getByID(resultSet.getInt(7)));
                dto.setDriver(resultSet.getString(8));
                list.add(dto);
            }
            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<ContractDTO> getByPassport(String passport) {
        List<ContractDTO> list = new LinkedList<>();
        String function = "{?= call get_contract_by_passport(?)}";
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
            while (resultSet.next()) {
                ContractDTO dto = new ContractDTO();
                dto.setId(resultSet.getInt(1));
                dto.setPlate(resultSet.getString(2));
                dto.setPassport(resultSet.getString(3));
                dto.setStartDate(resultSet.getDate(4).toLocalDate());
                dto.setEndDate(resultSet.getDate(5).toLocalDate());
                dto.setDeliveryDate(resultSet.getDate(6).toLocalDate());
                dto.setPayMethod(ServicesLocator.payMethodServices().getByID(resultSet.getInt(7)));
                dto.setDriver(resultSet.getString(8));
                list.add(dto);
            }
            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<ContractDTO> getByPlate(String plate) {
        List<ContractDTO> list = new LinkedList<>();
        String function = "{?= call get_contract_by_plate(?)}";
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
            while (resultSet.next()) {
                ContractDTO dto = new ContractDTO();
                dto.setId(resultSet.getInt(1));
                dto.setPlate(resultSet.getString(2));
                dto.setPassport(resultSet.getString(3));
                dto.setStartDate(resultSet.getDate(4).toLocalDate());
                dto.setEndDate(resultSet.getDate(5).toLocalDate());
                dto.setDeliveryDate(resultSet.getDate(6).toLocalDate());
                dto.setPayMethod(ServicesLocator.payMethodServices().getByID(resultSet.getInt(7)));
                dto.setDriver(resultSet.getString(8));
                list.add(dto);
            }
            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<ContractDTO> getByDni(String dni) {
        List<ContractDTO> list = new LinkedList<>();
        String function = "{?= call get_contract_by_dni(?)}";
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
            while (resultSet.next()) {
                ContractDTO dto = new ContractDTO();
                dto.setId(resultSet.getInt(1));
                dto.setPlate(resultSet.getString(2));
                dto.setPassport(resultSet.getString(3));
                dto.setStartDate(resultSet.getDate(4).toLocalDate());
                dto.setEndDate(resultSet.getDate(5).toLocalDate());
                dto.setDeliveryDate(resultSet.getDate(6).toLocalDate());
                dto.setPayMethod(ServicesLocator.payMethodServices().getByID(resultSet.getInt(7)));
                dto.setDriver(resultSet.getString(8));
                list.add(dto);
            }
            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
