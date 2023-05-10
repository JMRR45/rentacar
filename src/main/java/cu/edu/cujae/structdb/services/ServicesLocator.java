package cu.edu.cujae.structdb.services;

import cu.edu.cujae.structdb.utils.Connection;

import java.sql.SQLException;

/**
 * ServicesLocator works as a link to every service implemented in the system.<br>
 * TODO: List Services
 */
public class ServicesLocator {
    private static TouristService touristService;
    private static CarService carService;
    private static DriverService driverService;
    private static ContractService contractService;
    private static ModelService modelService;
    private static AuxiliarService brandService;
    private static AuxiliarService categoryService;
    private static AuxiliarService countryService;
    private static AuxiliarService payMethodService;
    private static AuxiliarService situationService;
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

    public static CarService CarServices() {
        if (carService == null) {
            carService = new CarService();
        }
        return carService;
    }

    public static DriverService DriverServices() {
        if (driverService == null) {
            driverService = new DriverService();
        }
        return driverService;
    }

    public static ContractService ContractServices() {
        if (contractService == null) {
            contractService = new ContractService();
        }
        return contractService;
    }

    public static ModelService ModelServices() {
        if (modelService == null) {
            modelService = new ModelService();
        }
        return modelService;
    }

    public static AuxiliarService BrandServices() {
        if (brandService == null) {
            brandService = new AuxiliarService(AuxiliarService.AuxiliarType.brand);
        }
        return brandService;
    }

    public static AuxiliarService CategoryServices() {
        if (categoryService == null) {
            categoryService = new AuxiliarService(AuxiliarService.AuxiliarType.category);
        }
        return categoryService;
    }

    public static AuxiliarService CountryServices() {
        if (countryService == null) {
            countryService = new AuxiliarService(AuxiliarService.AuxiliarType.country);
        }
        return countryService;
    }

    public static AuxiliarService PayMethodServices() {
        if (payMethodService == null) {
            payMethodService = new AuxiliarService(AuxiliarService.AuxiliarType.payMethod);
        }
        return payMethodService;
    }

    public static AuxiliarService SituationServices() {
        if (situationService == null) {
            situationService = new AuxiliarService(AuxiliarService.AuxiliarType.situation);
        }
        return situationService;
    }
}
