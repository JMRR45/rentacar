package cu.edu.cujae.structdb.services;

import cu.edu.cujae.structdb.dto.model.UserDTO;
import cu.edu.cujae.structdb.utils.FunctionBuilder;
import cu.edu.cujae.structdb.utils.FunctionType;
import cu.edu.cujae.structdb.utils.exception.DeleteCurrentUserException;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserService extends AbstractService {

    public UserService(String table) {
        super(table);
    }


    public void insert(UserDTO dto) {
        String function = FunctionBuilder.newFunction(false, FunctionType.insert, table, 2, null);
        try {
            Connection con = ServicesLocator.getConnection();
            CallableStatement call = con.prepareCall(function);
            call.setString(1, dto.getUsername());
            call.setInt(2, dto.getRol().getId());

            call.execute();
            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remove(int  id) throws DeleteCurrentUserException{
        if (ServicesLocator.authService().isCurrentUser(id)) {
            throw new DeleteCurrentUserException();
        }

        String function = FunctionBuilder.newFunction(false, FunctionType.delete, table, 1, null);
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

    public void update(UserDTO dto) {
        String function = FunctionBuilder.newFunction(false, FunctionType.update, table, 4, null);
        try {
            Connection con = ServicesLocator.getConnection();
            CallableStatement call = con.prepareCall(function);
            call.setInt(1, dto.getId());
            call.setString(2, dto.getUsername());
            call.setString(3, dto.getPassword());
            call.setInt(4, dto.getRol().getId());

            call.execute();
            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<UserDTO> getAll() {
        List<UserDTO> list = new LinkedList<>();
        String function = FunctionBuilder.newFunction(true, FunctionType.get, table, 0, null);
        try {
            Connection con = ServicesLocator.getConnection();
            con.setAutoCommit(false);
            CallableStatement call = con.prepareCall(function);
            call.registerOutParameter(1, Types.OTHER);
            call.execute();

            ResultSet resultSet = (ResultSet) call.getObject(1);
            if (!resultSet.isBeforeFirst()) {
                return null;
            }
            while (resultSet.next()) {
                UserDTO dto = new UserDTO();
                dto.setId(resultSet.getInt(1));
                dto.setUsername(resultSet.getString(2));
                dto.setPassword(resultSet.getString(3));
                dto.setRol(ServicesLocator.rolServices().getByID(resultSet.getInt(4)));
                list.add(dto);
            }
            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public UserDTO getByUsername(String username) {
        UserDTO dto = new UserDTO();
        String function = FunctionBuilder.newFunction(true, FunctionType.get, table, 1, "username");
        try {
            Connection con = ServicesLocator.getConnection();
            con.setAutoCommit(false);
            CallableStatement call = con.prepareCall(function);
            call.registerOutParameter(1, Types.OTHER);
            call.setString(2, username);
            call.execute();
            ResultSet resultSet = (ResultSet) call.getObject(1);
            if (!resultSet.isBeforeFirst()) {
                return null;
            }
            if (resultSet.next()) {
                dto.setId(resultSet.getInt(1));
                dto.setUsername(resultSet.getString(2));
                dto.setPassword(resultSet.getString(3));
                dto.setRol(null);
            }
            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dto;
    }
}
