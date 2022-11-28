public class Spieler {
    // e)
    Karte[] kartenhand;
    int kartenanzahl;
    String name;

    public String toString() {
        return name;
    }

    // f)
    Karte entferneKarte(int pos) {
        if (pos >= kartenanzahl)
            return null;

        Karte entfernteKarte = kartenhand[pos];
        if (entfernteKarte != null) {
            // if the next element is null, then just set the element at pos to null; copying the array won't be necessary anymore
            if (pos == kartenanzahl - 1) {
                kartenhand[pos] = null;
            } else {
                Karte[] kartenhandCopy = new Karte[kartenhand.length];
                // copy all elements of kartenhand before the removed one at pos
                for (int i = 0; i <= pos - 1; i++) {
                    kartenhandCopy[i] = kartenhand[i];
                }
                // copy all elements of kartenhand after the removed one at pos
                for (int i = pos; i < kartenhand.length - 1; i++) {
                    kartenhandCopy[i] = kartenhand[i + 1];
                }
                // add one null element at the end of kartenhand
                kartenhandCopy[kartenhand.length - 1] = null;

                kartenhand = kartenhandCopy;
            }
        }
        // if the card was null, then nothing should be done
        kartenanzahl--;
        return entfernteKarte;
    }

    // g)
    Karte passendeKarte(Farbe f) {
        for (int i = 0; i < kartenanzahl; i++) {
            if (kartenhand[i].farbe == f) {
                return entferneKarte(i);
            }
        }
        return null;
    }

    // h)
    Karte spieleKarte(Karte[] ks) {
        Karte ersteKarte = ks[0];
        if (ersteKarte == null) {
            // choose a random card from the players hand (all elements after kartenanzahl are null)
            int pos = (int) (Math.random() * (kartenanzahl - 1));
            return entferneKarte(pos);
        }

        Karte passendeKarte = passendeKarte(ersteKarte.farbe);
        if (passendeKarte == null) {
            int pos = (int) (Math.random() * (kartenanzahl - 1));
            return entferneKarte(pos);
        } else {
            return passendeKarte;
        }
    }

    // i)
    public static int hoechsteKarte(Karte[] ks) {
        Karte ersteKarte = ks[0];
        Farbe farbe = ersteKarte.farbe;
        int maxWert = Wert.valueOf(ersteKarte.wert.toString()).ordinal();
        int indexMax = 0;

        for (int i = 1; i < ks.length; i++) {
            Karte karte = ks[i];
            if (karte.farbe == farbe) {
                int currentWert = Wert.valueOf(karte.wert.toString()).ordinal();
                if (currentWert > maxWert) {
                    maxWert = currentWert;
                    indexMax = i;
                }
            }
        }

        return indexMax;
    }

    // j)
    public static Spieler spiel(Spieler... club) {
        Spielverwaltung.gibKarten(club, Karte.skatblatt());

        int anzahlSpieler = club.length;
        int indexGewinner = 0;

        for (int i = 0; i < 4; i++) {
            Karte[] gespielteKarten = new Karte[anzahlSpieler];

            if (indexGewinner != 0) {
                Spieler gewinnerLetzteRunde = club[indexGewinner];
                Spieler ersterSpieler = club[0];
                club[0] = gewinnerLetzteRunde;
                club[indexGewinner] = ersterSpieler;
            }

            for (int j = 0; j < anzahlSpieler; j++) {
                Spieler currentSpieler = club[j];
                Karte gespielteKarte = currentSpieler.spieleKarte(gespielteKarten);
                gespielteKarten[j] = gespielteKarte;
            }

            indexGewinner = hoechsteKarte(gespielteKarten);
        }

        return club[indexGewinner];
    }

    public static void main(String[] args) {
        Spieler[] club = Spielverwaltung.generiereClub(8);
        Spieler gewinner = spiel(club);
        System.out.println(gewinner);
    }
}