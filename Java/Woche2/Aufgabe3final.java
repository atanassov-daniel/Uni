public class Aufgabe3final {
    public static void main(String[] args) {
        // ask user for input
        int day = SimpleIO.getInt("Bitte geben Sie die Tageskomponente des Startdatums ein.");
        int month = SimpleIO.getInt("Bitte geben Sie die Monatskomponente des Startdatums ein.");
        int year = SimpleIO.getInt("Bitte geben Sie die Jahreskomponente des Startdatums ein.");
        int t = SimpleIO.getInt("Bitte geben Sie die Anzahl an Tagen ein:");

        // check if the month, day of the month, year, and t are correct
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

        int daysLeftToChange = t; // how many days the current date needs to be moved in the future
        boolean shouldStop = false;

        // if the date should be moved with more than a year, directly change the year
        if (t / 365 >= 1) {
            year += t / 365;
            daysLeftToChange = t % 365;
            if (t % 365 == 0) { // if the date has to be moved with an entire year or two, etc. the loop isn't needed
                shouldStop = true;
            }
        }

        while (!shouldStop) {
            int lastDayOfMonth = switch (month) {
                case 2 -> 28;
                case 4, 6, 9, 11 -> 30;
                default -> 31;
            };

            // if there are more days to change than are left until the end of the month
            if (daysLeftToChange > lastDayOfMonth - day) {
                // fill up the remaining days of the month, and go to the first of the next month
                daysLeftToChange -= lastDayOfMonth - day + 1;

                day = 1;
                if (month == 12) year++;
                month = (month % 12) + 1; // increases the month to the next, if month is 12, then it becomes 1
                // lastDayOfMonth - dayCopy + 1  days were moved in the future on this iteration
            } else {
                // if the remaining days can be contained in the current month, then just day needs to be changed, the month remains the same, the program can end
                day += daysLeftToChange;
                shouldStop = true;
            }

        }
        // output the result
        SimpleIO.output(String.format("Das Datum %d.%d.%d befindet sich %d Tage nach dem Startdatum.", day, month, year, t));
    }
}