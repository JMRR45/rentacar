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
    private static AuxiliaryService brandService;
    private static AuxiliaryService categoryService;
    private static AuxiliaryService countryService;
    private static AuxiliaryService payMethodService;
    private static AuxiliaryService situationService;
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

    public static AuxiliaryService BrandServices() {
        if (brandService == null) {
            brandService = new AuxiliaryService(AuxiliaryService.AuxiliaryType.brand);
        }
        return brandService;
    }

    public static AuxiliaryService CategoryServices() {
        if (categoryService == null) {
            categoryService = new AuxiliaryService(AuxiliaryService.AuxiliaryType.category);
        }
        return categoryService;
    }

    public static AuxiliaryService CountryServices() {
        if (countryService == null) {
            countryService = new AuxiliaryService(AuxiliaryService.AuxiliaryType.country);
        }
        return countryService;
    }

    public static AuxiliaryService PayMethodServices() {
        if (payMethodService == null) {
            payMethodService = new AuxiliaryService(AuxiliaryService.AuxiliaryType.payMethod);
        }
        return payMethodService;
    }

    public static AuxiliaryService SituationServices() {
        if (situationService == null) {
            situationService = new AuxiliaryService(AuxiliaryService.AuxiliaryType.situation);
        }
        return situationService;
    }
}
