package cu.edu.cujae.structdb.services;

import cu.edu.cujae.structdb.utils.Connection;

import java.sql.SQLException;

/**
 * ServicesLocator works as a link to every service implemented in the system.<br>
 * TODO: List Services
 */
public class ServicesLocator {
    private static TouristService touristService;
    /**
     * Open a new connection to the Database
     *
     * @return {@link java.sql.Connection}
     */
    public static java.sql.Connection getConnection() {
        Connection connection = null;
        try {
            connection = new Connection("localhost", "rentacar", "postgres", "rentacar");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection.getConnection();
    }

    public static TouristService TouristServices() {
        if (touristService == null) {
            touristService = new TouristService();
        }
        return touristService;
    }
}
