public class Karte {
    Farbe farbe;
    Wert wert;

    public String toString() {
        return farbe.toString() + wert.toString();
    }

    public static Karte neueKarte(Farbe f, Wert w) {
        Karte neueKarte = new Karte();
        neueKarte.farbe = f;
        neueKarte.wert = w;
        return neueKarte;
    }

    // d)
    public static int kombinationen() {
        int anzahlFarben = Farbe.values().length;
        int anzahlWerte = Wert.values().length;
        return anzahlFarben * anzahlWerte;
    }

    public static Karte[] skatblatt() {
        int size = kombinationen();
        Karte[] kartenArray = new Karte[size];

        int i = 0;
        for (Farbe farbe : Farbe.values()) {
            for (Wert wert : Wert.values()) {
                kartenArray[i] = neueKarte(farbe, wert);
                i++;
            }
        }
        return kartenArray;
    }
}