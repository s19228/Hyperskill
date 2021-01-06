/**
 * @author Gryka Konrad S19228
 */

package zad1;

import java.math.BigDecimal;
import java.util.HashMap;

public class Calc {

    private String[] args;

    private static final HashMap<String, Activity> activities = new HashMap<>();

    String doCalc(String cmd) {
        BigDecimal result;
        try {
            args = cmd.split("\\s+");
            result = activities.get(args[1]).calculate(new BigDecimal(args[0]), new BigDecimal(args[2]));

            return result.toString();

        } catch (ArithmeticException e) {
            return "Invalid command to calc";
        }
    }

    static {
        activities.put("+", new Add());
        activities.put("-", new Subtract());
        activities.put("*", new Multiply());
        activities.put("/", new Divide());
    }

    static HashMap<String, Activity> getActivities() {
        return activities;
    }
}