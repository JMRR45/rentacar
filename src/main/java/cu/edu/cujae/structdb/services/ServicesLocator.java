package cu.edu.cujae.structdb.services;

/**
 * ServicesLocator works as a link to every service implemented in the system.
 * Available Services:
 * TODO: List Services
 */
public class ServicesLocator {
    private static ServicesLocator instance;

    private ServicesLocator() {
        ServicesLocator.Instance();
    }

    /**
     * Get the running instance of the ServicesLocator
     * @return {@link ServicesLocator}
     */
    public static ServicesLocator Instance() {
        if (instance == null) {
            instance = new ServicesLocator();
        }
        return instance;
    }


}
