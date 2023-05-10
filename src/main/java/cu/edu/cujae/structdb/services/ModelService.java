package cu.edu.cujae.structdb.services;

import cu.edu.cujae.structdb.dto.crud.ModelDTO;
import cu.edu.cujae.structdb.dto.crud.TouristDTO;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ModelService {
    public void insert(String name) {

    }

    public void remove(String name) {

    }

    public List<ModelDTO> getAll() {
        List<ModelDTO> list = new LinkedList<>();
        String function = "{?= call get_models()}";
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
                ModelDTO dto = new ModelDTO();
                dto.setPassport(resultSet.getString(1));
                dto.setName(resultSet.getString(2));
                dto.setAge(resultSet.getInt(3));
                dto.setSex(resultSet.getString(4));
                dto.setContact(resultSet.getString(5));
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
