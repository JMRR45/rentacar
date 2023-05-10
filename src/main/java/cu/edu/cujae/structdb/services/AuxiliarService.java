package cu.edu.cujae.structdb.services;

import cu.edu.cujae.structdb.dto.crud.AuxiliarDTO;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AuxiliarService {
    public enum AuxiliarType { brand, category, country, payMethod, situation }
    private final HashMap<AuxiliarType, String> insertFunctions;
    private final HashMap<AuxiliarType, String> removeFunctions;
    private final HashMap<AuxiliarType, String> getFunctions;
    private final AuxiliarType type;
    public AuxiliarService(AuxiliarType type) {
        this.type = type;

        insertFunctions = HashMap.newHashMap(5);
        removeFunctions = HashMap.newHashMap(5);
        getFunctions = HashMap.newHashMap(5);

        insertFunctions.put(AuxiliarType.brand, "{call add_brand(?)}");             // Brand
        insertFunctions.put(AuxiliarType.category, "{call add_category(?)}");       // Category
        insertFunctions.put(AuxiliarType.country, "{call add_country(?)}");         // Country
        insertFunctions.put(AuxiliarType.payMethod, "{call add_paymethod(?)}");     // PayMethod
        insertFunctions.put(AuxiliarType.situation, "{call add_situation(?)}");     // Situation

        removeFunctions.put(AuxiliarType.brand, "{call remove_brand(?)}");          // Brand
        removeFunctions.put(AuxiliarType.category, "{call remove_category(?)}");    // Category
        removeFunctions.put(AuxiliarType.country, "{call remove_country(?)}");      // Country
        removeFunctions.put(AuxiliarType.payMethod, "{call remove_paymethod(?)}");  // PayMethod
        removeFunctions.put(AuxiliarType.situation, "{call remove_situation(?)}");  // Situation

        getFunctions.put(AuxiliarType.brand, "{call get_brands(?)}");               // Brand
        getFunctions.put(AuxiliarType.category, "{call get_categories(?)}");        // Category
        getFunctions.put(AuxiliarType.country, "{call get_countries(?)}");          // Country
        getFunctions.put(AuxiliarType.payMethod, "{call get_paymethods(?)}");       // PayMethod
        getFunctions.put(AuxiliarType.situation, "{call get_situations(?)}");       // Situation
    }

    public void insert(AuxiliarDTO dto) {
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

    public List<AuxiliarDTO> getAll() {
        List<AuxiliarDTO> list = new LinkedList<>();
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
                AuxiliarDTO dto = new AuxiliarDTO();
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
}
