package cu.edu.cujae.structdb.persistence;

import cu.edu.cujae.structdb.utils.TimeLapse;

public class Contract {
    public enum PaymentMethod {CASH, CHECK, CREDITCARD;}

    private String plate;
    private String passport;
    private String dni;
    private TimeLapse lapse;
    private PaymentMethod payMethod;

    public String getPlate() {
        return plate;
    }

    public String getPassport() {
        return passport;
    }

    public String getDni() {
        return dni;
    }

    public TimeLapse getLapse() {
        return (TimeLapse) lapse.clone();
    }

    public PaymentMethod getPayMethod() {
        return payMethod;
    }
}
