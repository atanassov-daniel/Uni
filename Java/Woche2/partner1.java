public class LaszloHinz1 {
    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();

        int day = 27;
        int month = 2;
        int year = 2022;
        int t = 448;

        boolean wrongMonth = month <= 0 || month > 12;
        boolean wrongDay = wrongMonth || day <= 0 || switch (month) {
            case 2 -> day > 28;
            case 4, 6, 9, 11 -> day > 30;
            case 1, 3, 5, 7, 8, 10, 12 -> day > 31;
            default -> true;
        };
        if (wrongMonth || wrongDay || year < 0 || t < 0) {
            SimpleIO.output("Falsche Eingaben! Bitte versuchen Sie es erneut!");
            return;
        }

        int daysLeftToChange = t;
        boolean shouldStop = false;

        if (t / 365 >= 1) {
            year += t / 365;
            daysLeftToChange = t % 365;
            if (t % 365 == 0) {
                shouldStop = true;
            }
        }

        while (!shouldStop) {
            int lastDayOfMonth = switch (month) {
                case 2 -> 28;
                case 4, 6, 9, 11 -> 30;
                default -> 31;
            };

            if (daysLeftToChange > lastDayOfMonth - day) {
                daysLeftToChange -= lastDayOfMonth - day + 1;

                day = 1;
                if (month == 12) year++;
                month = (month % 12) + 1;
            } else {
                day += daysLeftToChange;
                shouldStop = true;
            }
        }

        System.out.println(String.format("Das Datum %d.%d.%d befindet sich %d Tage nach dem Startdatum.", day, month, year, t));

        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
