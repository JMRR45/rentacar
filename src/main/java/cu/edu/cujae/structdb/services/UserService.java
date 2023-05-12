package cu.edu.cujae.structdb.services;

import cu.edu.cujae.structdb.dto.model.UserDTO;
import cu.edu.cujae.structdb.utils.FunctionBuilder;
import cu.edu.cujae.structdb.utils.FunctionType;

import java.sql.*;

public class UserService extends AbstractService{

    public UserService(String table) {
        super(table);
    }

    public void insert(UserDTO dto) {

    }

    public void remove(int id) {

    }

    public void update(UserDTO dto) {

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
