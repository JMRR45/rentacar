package cu.edu.cujae.structdb.persistence;

public class User {
    public enum AccessLevel {ADMIN, WORKER}

    private int id;
    private String name;
    private Integer password;
    private AccessLevel accessLevel;

    public String getName() {
        return name;
    }

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }
}
