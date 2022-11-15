public class Karte {
    Farbe farbe;
    Wert wert;

    /* So soll bspw. für das Herz-Ass (mit dem Farbe-Attribut Farbe.HERZ und dem Wert-Attribut Wert.ASS) der String HERZASS ausgegeben werden. Sie können hier und in allen folgenden Teilaufgaben davon ausgehen, dass die Attribute eines Objekts vom Typ Karte stets sinnvoll gesetzt sind, wenn auf diesem eine Methode aufgerufen wird oder es als Parameter übergeben wird. */
    public String toString() {
        /* Um die String-Repräsentation eines enum-Objekts zu erhalten, können Sie die Methode toString() auf Objekten eines enum-Typs nutzen. Bspw. ist Farbe.HERZ.toString() der String "HERZ" */
        return farbe.toString() + wert.toString();
    }

    /* c) Ergänzen Sie die Klasse Karte um eine statische Methode Karte neueKarte(Farbe f, Wert w), die ein neues Objekt vom Typ Karte mit den übergebenen Attributen erzeugt und zurückgibt. */
    public static Karte neueKarte(Farbe f, Wert w) {
        Karte neueKarte = new Karte();
        neueKarte.farbe = f;
        neueKarte.wert = w;
        return neueKarte;
    }

    /* d) Ergänzen Sie die Klasse Karte um die statische Methode int kombinationen(), die die Anzahl der verschiedenen Farbe-Wert-Kombinationen zurückgibt. Gestalten Sie Ihre Implementierung so, dass die Ausgabe auch dann noch korrekt ist, wenn sich die zugrundeliegenden enum-Klassen geändert haben.*/
    public static int kombinationen() {
        int anzahlFarben = Farbe.values().length;
        int anzahlWerte = Wert.values().length;
        return anzahlFarben * anzahlWerte; // bei den gegebenen enums sollte das 8*4=32 betragen
    }
    /* d)(Forts.)  Nutzen Sie die Methode kombinationen(), um eine weitere statische Methode Karte[] skatblatt() in der Klasse Karte zu schreiben. Diese soll ein Array mit Elementen vom Typ Karte zurückgeben, in dem sich für jede Farbe-Wert-Kombination genau eine entsprechende Karte befindet. Das Array soll keine weiteren Elemente haben, insbesondere keine null-Elemente.  */
    public static Karte[] skatblatt() {
        /* ein Array mit Elementen vom Typ Karte zurückgeben, in dem sich für jede Farbe-Wert-Kombination genau eine entsprechende Karte befindet. Das Array soll keine weiteren Elemente haben, insbesondere keine null-Elemente. */
        int size = kombinationen();
        Karte[] kartenArray = new Karte[size];

        int i = 0;
        for (Farbe farbe : Farbe.values()) {
            for (Wert wert : Wert.values()) {
                Karte neueKarte = new Karte();
                neueKarte.farbe = farbe;
                neueKarte.wert = wert;
                kartenArray[i] = neueKarte;
                i++;
            }
        }
        return kartenArray;
    }
}
