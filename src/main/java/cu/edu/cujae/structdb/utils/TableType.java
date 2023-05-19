package cu.edu.cujae.structdb.utils;

public enum TableType {
    brand, situation, model, category, country, paymethod, rol, user, fee;

    public static TableType fromString(String name) {
        TableType value = brand;
        switch (name) {
            case "brand" -> value = brand;
            case "situation" -> value = situation;
            case "model" -> value = model;
            case "category" -> value = category;
            case "country" -> value = country;
            case "paymethod" -> value = paymethod;
            case "rol" -> value = rol;
            case "user" -> value = user;
            case "fee" -> value = fee;
        }
        return value;
    }
}
