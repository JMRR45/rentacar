package cu.edu.cujae.structdb.services;

import cu.edu.cujae.structdb.dto.model.RolDTO;
import cu.edu.cujae.structdb.utils.FunctionBuilder;
import cu.edu.cujae.structdb.utils.FunctionType;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class RolService extends AbstractService {

    public RolService(String table) {
        super(table);
    }

    public void insert(RolDTO dto) {

    }

    public void remove(int id) {

    }

    public void update(RolDTO dto) {

    }

    public RolDTO getByID(int id) {
        RolDTO dto = new RolDTO();
        String function = FunctionBuilder.newFunction(true, FunctionType.get, table, 1, "id");
        try {
            Connection con = ServicesLocator.getConnection();
            con.setAutoCommit(false);
            CallableStatement call = con.prepareCall(function);
            call.registerOutParameter(1, Types.OTHER);
            call.setInt(2, id);
            call.execute();

            ResultSet resultSet = (ResultSet) call.getObject(1);
            if (!resultSet.isBeforeFirst()) {
                return null;
            }
            if (resultSet.next()) {
                dto.setId(resultSet.getInt(1));
                dto.setName(resultSet.getString(2));
                dto.setDescription(resultSet.getString(3));
            }
            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dto;
    }

    public List<RolDTO> getAll() {
        List<RolDTO> list = new LinkedList<>();
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
                RolDTO dto = new RolDTO();
                dto.setId(resultSet.getInt(1));
                dto.setName(resultSet.getString(2));
                dto.setDescription(resultSet.getString(3));
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
