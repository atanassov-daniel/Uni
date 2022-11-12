public class LaszloHinz {
    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();

        int d = 27;
        int m = 2;
        int y = 2022;
        int t = 448;

//Datumsberechnung
        for (int i = 0; i < t; i++) {
            d++;
            switch (m) {
                case 1, 3, 5, 7, 8, 10, 12 -> {
                    if (d == 32) {
                        d = 1;
                        m++;
                    }
                }
                case 4, 6, 9, 11 -> {
                    if (d == 31) {
                        d = 1;
                        m++;
                    }
                }
                case 2 -> {
                    if (d == 29) {
                        d = 1;
                        m++;
                    }
                }
                default -> {
                    SimpleIO.output("Fehler");
                    return;
                }
            }
            if (m == 13) {
                m = 1;
                y++;
            }
        }
        String ausgabe = "Das Datum " + d + "." + m + "." + y + " befindet sich " + t + " Tage nach dem Startdatum.";
        System.out.println(ausgabe);
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
