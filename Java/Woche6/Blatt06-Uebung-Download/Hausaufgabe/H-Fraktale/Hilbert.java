public class Hilbert {
    static void hilbertLinks(Canvas c, int ordnung, int length) {
        if (ordnung == 0) {
            return;
        }
        // Zunaechst wird eine Drehung um -90 Grad durchgefuehrt.
        c.rotate(-90);
        // Dann wird eine Hilbert-Rechts-Kurve (ordnung - 1)-ter Ordnung gezeichnet.
        hilbertRechts(c, ordnung - 1, length);
        // Anschliessend eine gerade Linie
        c.drawForward(length);
        // Dann eine 90 Grad Drehung
        c.rotate(90);
        // Eine Hilbert-Links-Kurve (ordnung - 1)-ter Ordnung
        hilbertLinks(c, ordnung - 1, length);
        // Eine gerade Linie
        c.drawForward(length);
        // Eine Hilbert-Links-Kurve (ordnung - 1)-ter Ordnung
        hilbertLinks(c, ordnung - 1, length);
        // Eine 90 Grad Drehung
        c.rotate(90);
        // Wieder eine gerade Linie
        c.drawForward(length);
        // Eine Hilbert-Rechts-Kurve (ordnung - 1)-ter Ordnung gezeichnet.
        hilbertRechts(c, ordnung - 1, length);
        // Die naechste Kurve setzt dann im Winkel von -90 Grad an.
        c.rotate(-90);
    }

    static void hilbertRechts(Canvas c, int ordnung, int length) {
        if (ordnung == 0) {
            return;
        }
        // Zunaechst wird eine Drehung um 90 Grad durchgefuehrt.
        c.rotate(90);
        // Dann wird eine Hilbert-Links-Kurve (ordnung - 1)-ter Ordnung gezeichnet.
        hilbertLinks(c, ordnung - 1, length);
        // Anschliessend eine gerade Linie
        c.drawForward(length);
        // Dann eine -90 Grad Drehung
        c.rotate(-90);
        // Eine Hilbert-Rechts-Kurve (ordnung - 1)-ter Ordnung
        hilbertRechts(c, ordnung - 1, length);
        // Eine gerade Linie
        c.drawForward(length);
        // Eine Hilbert-Rechts-Kurve (ordnung - 1)-ter Ordnung
        hilbertRechts(c, ordnung - 1, length);
        // Eine -90 Grad Drehung
        c.rotate(-90);
        // Wieder eine gerade Linie
        c.drawForward(length);
        // Eine Hilbert-Links-Kurve (ordnung - 1)-ter Ordnung
        hilbertLinks(c, ordnung - 1, length);
        // Die naechste Kurve setzt dann im Winkel von 90 Grad an.
        c.rotate(90);
    }

    public static void main(String[] args) {
        int ordnung = 6;
        int length = 5;
        boolean links = true;
        switch (args.length) {
            case 3 -> {
                if (args[2].equals("r")) {
                    links = false;
                } else if (!args[2].equals("l")) {
                    System.out.println("Unbekannter parameter " + args[2]);
                    System.out.println("Nutze Standardwert l");
                }
                length = Integer.parseInt(args[1]);
                ordnung = Integer.parseInt(args[0]);
            }
            case 2 -> {
                length = Integer.parseInt(args[1]);
                ordnung = Integer.parseInt(args[0]);
            }
            case 1 -> {
                ordnung = Integer.parseInt(args[0]);
            }
            default -> {
                System.out.println(
                        "Verwende Standardwerte: Ordnung 6, Laenge 5, links.");
                System.out.println(
                        "Verwendung: java Hilbert [ordnung [laenge [(l|r)]]]");
            }
        }
        if (ordnung < 0) {
            System.out.println("Die Rekursionsordnung muss nicht-negativ sein!");
            return;
        }
        if (length < 1) {
            System.out.println("Die Laenge muss positiv sein!");
            return;
        }
        Canvas c = new Canvas();
        if (links) {
            Hilbert.hilbertLinks(
                    c,
                    ordnung,
                    length);
        } else {
            Hilbert.hilbertRechts(
                    c,
                    ordnung,
                    length);
        }
        c.refresh();
    }
}