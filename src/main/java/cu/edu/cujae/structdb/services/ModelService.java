package cu.edu.cujae.structdb.services;

import cu.edu.cujae.structdb.dto.model.ModelDTO;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ModelService {
    public void insert(ModelDTO dto) {
        String function = "{call add_model(?, ?)}";
        try {
            Connection con = ServicesLocator.getConnection();
            CallableStatement call = con.prepareCall(function);
            call.setString(1, dto.getName());
            call.setInt(2, dto.getBrand().getId());

            call.execute();
            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remove(String name) {
        String function = "{call remove_model(?)}";
        try {
            Connection con = ServicesLocator.getConnection();
            CallableStatement call = con.prepareCall(function);
            call.setString(1, name);
            call.execute();

            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
                dto.setId(resultSet.getInt(1));
                dto.setName(resultSet.getString(2));
                dto.setBrand(ServicesLocator.brandServices().getByID(resultSet.getInt(3)));
                list.add(dto);
            }
            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ModelDTO getByID(int id) {
        ModelDTO dto = new ModelDTO();
        String function = "{?= call get_model_by_id(?)}";
        try {
            Connection con = ServicesLocator.getConnection();
            con.setAutoCommit(false);
            CallableStatement call = con.prepareCall(function);
            call.registerOutParameter(1, Types.OTHER);
            call.setInt(2, id);
            call.execute();

            ResultSet resultSet = (ResultSet) call.getObject(1);
            if (resultSet == null) {
                return null;
            }
            if (resultSet.next()) {
                dto.setId(id);
                dto.setName(resultSet.getString(1));
                dto.setBrand(ServicesLocator.brandServices().getByID(resultSet.getInt(2)));
            }
            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dto;
    }
}
