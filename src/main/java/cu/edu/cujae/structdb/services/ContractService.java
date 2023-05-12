package cu.edu.cujae.structdb.services;

import cu.edu.cujae.structdb.dto.model.ContractDTO;
import cu.edu.cujae.structdb.utils.FunctionBuilder;
import cu.edu.cujae.structdb.utils.FunctionType;

import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class ContractService extends AbstractService{

    public ContractService(String table) {
        super(table);
    }

    public void insert(ContractDTO dto) {
        String function = FunctionBuilder.newFunction(false, FunctionType.insert, table, 7, null);
        try {
            Connection con = ServicesLocator.getConnection();
            CallableStatement call = con.prepareCall(function);
            call.setString(1, dto.getPlate());
            call.setDate(2, new Date(dto.getStartDate().toEpochDay()));
            call.setString(3, dto.getPassport());
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

    public void remove(String plate, LocalDate startDate) {
        String function = FunctionBuilder.newFunction(false, FunctionType.delete, table, 2, null);
        try {
            Connection con = ServicesLocator.getConnection();
            CallableStatement call = con.prepareCall(function);
            call.setString(1, plate);
            call.setDate(2, Date.valueOf(startDate));
            call.execute();

            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(ContractDTO dto) {
        String function = FunctionBuilder.newFunction(false, FunctionType.update, table, 7, null);
        try {
            Connection con = ServicesLocator.getConnection();
            CallableStatement call = con.prepareCall(function);
            call.setString(1, dto.getPlate());
            call.setDate(2, new Date(dto.getStartDate().toEpochDay()));
            call.setString(3, dto.getPassport());
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
        String function = FunctionBuilder.newFunction(true, FunctionType.get, table, 0, null);
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
                dto.setPlate(resultSet.getString(1));
                dto.setStartDate(resultSet.getDate(2).toLocalDate());
                dto.setPassport(resultSet.getString(3));
                dto.setEndDate(resultSet.getDate(4).toLocalDate());
                dto.setDeliveryDate(resultSet.getDate(5).toLocalDate());
                dto.setPayMethod(ServicesLocator.payMethodServices().getByID(resultSet.getInt(6)));
                dto.setDriver(resultSet.getString(7));
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
        String function = FunctionBuilder.newFunction(true, FunctionType.get, table, 1, "passport");
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
                dto.setPlate(resultSet.getString(1));
                dto.setStartDate(resultSet.getDate(2).toLocalDate());
                dto.setPassport(resultSet.getString(3));
                dto.setEndDate(resultSet.getDate(4).toLocalDate());
                dto.setDeliveryDate(resultSet.getDate(5).toLocalDate());
                dto.setPayMethod(ServicesLocator.payMethodServices().getByID(resultSet.getInt(6)));
                dto.setDriver(resultSet.getString(7));
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
        String function = FunctionBuilder.newFunction(true, FunctionType.get, table, 1, "plate");
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
                dto.setPlate(resultSet.getString(1));
                dto.setStartDate(resultSet.getDate(2).toLocalDate());
                dto.setPassport(resultSet.getString(3));
                dto.setEndDate(resultSet.getDate(4).toLocalDate());
                dto.setDeliveryDate(resultSet.getDate(5).toLocalDate());
                dto.setPayMethod(ServicesLocator.payMethodServices().getByID(resultSet.getInt(6)));
                dto.setDriver(resultSet.getString(7));
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
        String function = FunctionBuilder.newFunction(true, FunctionType.get, table, 1, "dni");
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
                dto.setPlate(resultSet.getString(1));
                dto.setStartDate(resultSet.getDate(2).toLocalDate());
                dto.setPassport(resultSet.getString(3));
                dto.setEndDate(resultSet.getDate(4).toLocalDate());
                dto.setDeliveryDate(resultSet.getDate(5).toLocalDate());
                dto.setPayMethod(ServicesLocator.payMethodServices().getByID(resultSet.getInt(6)));
                dto.setDriver(resultSet.getString(7));
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
