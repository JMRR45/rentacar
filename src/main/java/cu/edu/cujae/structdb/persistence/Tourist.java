package cu.edu.cujae.structdb.persistence;

public class Tourist {
    public enum Sex {MALE, FEMALE}

    private String passport;
    private int age;
    private String name;
    private String phoneNumber;
    private Sex sex;
    private String country;

    public String getPassport() {
        return passport;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Sex getSex() {
        return sex;
    }

    public String getCountry() {
        return country;
    }
}
