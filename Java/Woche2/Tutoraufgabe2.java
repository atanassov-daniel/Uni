public class Tutoraufgabe2 {
    public static void main(String[] args) {
        int num1 = SimpleIO.getInt("Bitte geben Sie eine Zahl ein:");
        String operation = SimpleIO.getString("Bitte geben Sie eine Rechenoperation (ADD , SUB , MUL , DIV ) oder STOP ein:");
        int result = num1;

        // bei falscher Operation am Beginn wird trotydem um eine zweite Zahl gefragt, was eigentlich unnotig ist
        while (!operation.equals("STOP")) {
            int num2 = SimpleIO.getInt("Bitte geben Sie eine Zahl ein:");

            switch (operation) {
                case "ADD" -> result += num2;
                case "SUB" -> result -= num2;
                case "MUL" -> result *= num2;
                case "DIV" -> result /= num2;
                default -> {
                    return;
                }
            }

            SimpleIO.output("Aktuelles Ergebnis: " + result);
            operation = SimpleIO.getString("Bitte geben Sie eine Rechenoperation (ADD , SUB , MUL , DIV ) oder STOP ein:");
        }
        if (operation.equals("STOP")) {
            SimpleIO.output("Endergebnis: " + result);
        }
    }


}

