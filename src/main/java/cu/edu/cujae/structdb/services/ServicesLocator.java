package cu.edu.cujae.structdb.services;

/**
 * ServicesLocator works as a link to every service implemented in the system.<br>
 * Available Services:<br>
 * 1. {@link AuthenticationService}<br>
 * TODO: List Services
 */
public class ServicesLocator {
    private static ServicesLocator instance;

    private ServicesLocator() {
        ServicesLocator.Instance();
    }

    /**
     * Get the running instance of the ServicesLocator
     *
     * @return {@link ServicesLocator}
     */
    public static ServicesLocator Instance() {
        if (instance == null) {
            instance = new ServicesLocator();
        }
        return instance;
    }
}
