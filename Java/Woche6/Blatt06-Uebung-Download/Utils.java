import java.awt.*;

public class Utils {

    private Utils(){}

    public static boolean evaluateVariable(String elem, String... strings) {
        if (elem == null) {
            return false;
        }
        if (elem.equals("true")) {
            //variable is constant true
            return true;
        } else if (elem.equals("false")) {
            //variable is constant false
            return false;
        } else {
            return contains(elem,strings);
        }
    }

    /**
     * Gibt zurück, ob elem in strings enthalten ist
     * @param elem der String, nach dem gesucht werden soll
     * @param strings die Strings, die durchsucht werden sollen
     * @return ob elem in strings enthalten ist
     */
    public static boolean contains(String elem, String... strings) {
        if (strings == null || elem == null) {
            //strings is null, elem cannot be contained
            return false;
        }
        for (String string : strings) {
            if (elem.equals(string)) {
                //elem is in strings
                return true;
            }
        }
        //elem has not been found in strings
        return false;
    }

    /**
     * Gibt eine Fehlermeldung aus.
     * @param msg die Fehlermeldung, die ausgegeben werden soll
     */
    public static void error(String msg) {
        System.err.println(msg);
    }

    /**
     * Berechnet das Maximum der Argumente.
     * @param args die Werte, deren Maximum bestimmt werden soll
     * @return den maximalen Wert aller Argumente
     */
    public static int max(int... args) {
        if (args.length == 0) {
            error("Called max without arguments!");
        }
        int res = args[0];
        for (int i = 1; i < args.length; i++) {
            res = Math.max(res, args[i]);
        }
        return res;
    }
}
