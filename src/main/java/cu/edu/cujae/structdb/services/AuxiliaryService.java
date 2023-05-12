package cu.edu.cujae.structdb.services;

import cu.edu.cujae.structdb.dto.model.AuxiliaryDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AuxiliaryService {
    public static class AuxiliaryType {
        public static int brand = 0;
        public static int category = 1;
        public static int country = 2;
        public static int payMethod = 3;
        public static int situation = 4;
    }
    private final List<String> insertFunctions;
    private final List<String> removeFunctions;
    private final List<String> getFunctions;
    private final List<String> getByIdFunctions;
    private final int type;
    public AuxiliaryService(int type) {
        this.type = type;

        insertFunctions = new ArrayList<>(5);
        removeFunctions = new ArrayList<>(5);
        getFunctions = new ArrayList<>(5);
        getByIdFunctions = new ArrayList<>(5);

        insertFunctions.add(AuxiliaryType.brand, "{call add_brand(?)}");             // Brand
        insertFunctions.add(AuxiliaryType.category, "{call add_category(?)}");       // Category
        insertFunctions.add(AuxiliaryType.country,"{call add_country(?)}");          // Country
        insertFunctions.add(AuxiliaryType.payMethod, "{call add_paymethod(?)}");     // PayMethod
        insertFunctions.add(AuxiliaryType.situation, "{call add_situation(?)}");     // Situation

        removeFunctions.add(AuxiliaryType.brand, "{call remove_brand(?)}");          // Brand
        removeFunctions.add(AuxiliaryType.category, "{call remove_category(?)}");    // Category
        removeFunctions.add(AuxiliaryType.country, "{call remove_country(?)}");      // Country
        removeFunctions.add(AuxiliaryType.payMethod, "{call remove_paymethod(?)}");  // PayMethod
        removeFunctions.add(AuxiliaryType.situation, "{call remove_situation(?)}");  // Situation

        getFunctions.add(AuxiliaryType.brand, "{call get_brands(?)}");               // Brand
        getFunctions.add(AuxiliaryType.category, "{call get_categories(?)}");        // Category
        getFunctions.add(AuxiliaryType.country, "{call get_countries(?)}");          // Country
        getFunctions.add(AuxiliaryType.payMethod, "{call get_paymethods(?)}");       // PayMethod
        getFunctions.add(AuxiliaryType.situation, "{call get_situations(?)}");       // Situation

        getByIdFunctions.add(AuxiliaryType.brand, "{call get_brand_by_id(?)}");              // Brand
        getByIdFunctions.add(AuxiliaryType.category, "{call get_category_by_id(?)}");        // Category
        getByIdFunctions.add(AuxiliaryType.country, "{call get_country_by_id(?)}");          // Country
        getByIdFunctions.add(AuxiliaryType.payMethod, "{call get_paymethod_by_id(?)}");      // PayMethod
        getByIdFunctions.add(AuxiliaryType.situation, "{call get_situation_by_id(?)}");      // Situation
    }

    public void insert(AuxiliaryDTO dto) {
        String function = insertFunctions.get(type);
        try {
            Connection con = ServicesLocator.getConnection();
            CallableStatement call = con.prepareCall(function);
            call.setString(1, dto.getName());

            call.execute();
            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remove(String name) {
        String function = removeFunctions.get(type);
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

    public List<AuxiliaryDTO> getAll() {
        List<AuxiliaryDTO> list = new LinkedList<>();
        String function = getFunctions.get(type);
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
                AuxiliaryDTO dto = new AuxiliaryDTO();
                dto.setId(resultSet.getInt(1));
                dto.setName(resultSet.getString(2));
                list.add(dto);
            }
            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public AuxiliaryDTO getByID(int id) {
        AuxiliaryDTO dto = new AuxiliaryDTO();
        String function = getByIdFunctions.get(type);
        try {
            Connection con = ServicesLocator.getConnection();
            con.setAutoCommit(false);
            CallableStatement call = con.prepareCall(function);
            call.registerOutParameter(1, Types.OTHER);
            call.setInt(1, id);
            call.execute();

            ResultSet resultSet = (ResultSet) call.getObject(1);
            if (resultSet == null) {
                return null;
            }
            if (resultSet.next()) {
                dto.setId(id);
                dto.setName(resultSet.getString(1));
            }
            call.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dto;
    }
}
