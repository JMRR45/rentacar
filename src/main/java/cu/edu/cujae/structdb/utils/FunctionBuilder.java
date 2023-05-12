package cu.edu.cujae.structdb.utils;

public class FunctionBuilder {

    public static String newFunction(boolean hasReturn, FunctionType type, String table, int parameters, String criteria) {
        String function = hasReturn ? "{?= call " : "{call ";

        switch (type) {
            case insert -> function += "insert_";
            case delete -> function += "delete_";
            case update -> function += "update_";
            case get -> function += "get_";
        }

        if (type == FunctionType.get) {
            if (criteria == null) {
                function += "all_";
                function += table;
            } else {
                function += table;
                function += "_";
                function += "by_" + criteria;
            }
        }

        if (type == FunctionType.get) {

        }

        function += "(";
        for (int i = 0; i < parameters; i++) {
            function += "?";
            if (i != parameters - 1) {
                function += ", ";
            }
        }
        function += ")}";
        return function;
    }
}
