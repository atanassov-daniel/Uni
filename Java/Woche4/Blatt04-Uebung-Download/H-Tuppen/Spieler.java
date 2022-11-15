public class Spieler {
/* e) Schreiben Sie eine Klasse Spieler mit einem Attribut kartenhand, das ein Array mit Elementen vom Typ Karte ist. 
Ausserdem soll ein zweites Attribut die aktuelle Kartenanzahl des Spielers enthalten und ein drittes Attribut den Namen des Spielers. Wählen Sie für diese beiden Attribute sinnvolle Typen. */
    Karte[] kartenhand;
    int kartenanzahl;
    String name;
/*
Schreiben Sie ausserdem die Methode String toString() in der Klasse Spieler, die für jedes Objekt vom Typ Spieler den Namen des Spielers als String ausgibt. Sie können hier und in allen folgenden Teilaufgaben davon ausgehen, dass die Attribute eines Objekts vom Typ Spieler stets sinnvoll gesetzt sind, wenn auf diesem eine Methode aufgerufen wird oder es als Parameter übergeben wird. */
    public String toString() {
        // System.out.println(name);
        return name;
    }

/* f) Methode entferneKarte(int pos) soll das Objekt an Position pos in kartenhand zurückgeben und den entsprechenden Eintrag auf null setzen. Falls es die Position pos in kartenhand nicht gibt, darf sich die Methode beliebig verhalten. 
Das Array kartenhand kann auch vor dem Aufruf der Methode schon null-Einträge haben. Bei n null-Einträgen stehen diese aber immer gesammelt hinten in den letzten n Einträgen des Arrays. Stellen Sie sicher, dass diese Eigenschaft auch nach jedem Aufruf der Methode entferneKarten wieder gilt. */
Karte entferneKarte(int pos) {
    //! if needed, make sure this null position doesn't get printed out
    // if(pos >= kartenhand.length) return null; //TODO
    if(pos >= kartenanzahl) return null; //TODO
    Karte entfernteKarte = kartenhand[pos];
    if(entfernteKarte != null) {
        // if the next element is null, then just set the element at pos to null; copying the array won't be necessary anymore
        if(pos == kartenanzahl - 1){
        // if(kartenhand[pos+1] == null){
            kartenhand[pos] = null;
        } else {
            Karte[] kartenhandCopy = new Karte[kartenhand.length];
            //! see if pos starts at 0 or 1 and change the implementation accordingly
                // copy all elements of kartenhand before the removed one at pos
            for(int i = 0; i <= pos - 1; i++){
                kartenhandCopy[i] = kartenhand[i];
            }
            // copy all elements of kartenhand after the removed one at pos
            for(int i = pos; i < kartenhand.length - 1; i++) {
                kartenhandCopy[i] = kartenhand[i + 1];
            }
            // add one null element at the end of kartenhand
            kartenhandCopy[kartenhand.length - 1] = null;
            // kartenhand[pos] = null;
            kartenhand = kartenhandCopy;
        }
    }
    // if the card was null, then nothing should be done
    kartenanzahl--;
    return entfernteKarte;
}

/* g) Methode, die nach Möglichkeit eine Karte der Farbe f aus kartenhand zurückgibt und aus der Kartenhand entfernt. Wenn keine Karte der passenden Farbe vorliegt, soll null zurückgegeben und die Kartenhand nicht verändert werden. */
Karte passendeKarte(Farbe f) {
    for (int i = 0; i < kartenhand.length; i++) {
        if(kartenhand[i].farbe == f) {
            return entferneKarte(i);
        }
    }
    return null;
}

/* h) Die Methode bekommt das Array ks der bereits gespielten Karten übergeben. Auch für dieses Array gilt die in Teilaufgabe f) beschriebene Eigenschaft, dass zwar null-Einträge enthalten sein können, diese aber stets am Ende des Arrays stehen. (Das übergebene Array stellt den aktuellen Stich dar, in den jeder Spieler genau eine Karte spielt.) */
Karte spieleKarte(Karte[] ks) {
/* Sie können davon ausgehen, dass das Array kartenhand bei Aufruf dieser Methode mindestens eine Karte enthält.  */
/* Abhängig vom Eingabeparameter ks soll eine Karte aus kartenhand entfernt und zurückgegeben werden: */
/* Wenn in ks noch keine Karte enthalten ist, soll eine beliebige Karte (nicht null) gewählt werden. (Der Spieler eröffnet den Stich mit seiner Karte und legt damit fest, welche Farbe in diesem Stich bedient werden muss.) */
    Karte ersteKarte = ks[0];
    if(ersteKarte == null) {
        // choose a random card from the players hand (all elements after aktuelleAnzahl are null)
        int pos = (int)(Math.random()*(kartenanzahl - 1));
        return entferneKarte(pos);
    }
/* Wenn in ks eine oder mehr Karten enthalten sind, soll nach Möglichkeit eine Karte gewählt werden, die dieselbe Farbe hat wie die Karte in ks an Position 0, ansonsten eine beliebige Karte (nicht null). (Entweder der Spieler bedient die Farbe mit seiner Karte und hat somit eine Chance den Stich zu gewinnen oder der Spieler kann die geforderte Farbe nicht bedienen und wirft eine Karte ab.)  */
//! benutze hier passendeKarte()
    for (int i = 0; i < kartenanzahl; i++) {
        if(kartenhand[i].farbe == ersteKarte.farbe) {
            return entferneKarte(i);
        }
    }
    int pos = (int)(Math.random()*(kartenanzahl - 1));
    return entferneKarte(pos);
}

/* i) statische Methode hoechsteKarte
Bei Aufruf dieser Methode sollen alle Karten in ks durchgegangen werden und die Position der höchsten Karte in ks zurückgegeben werden. Als höchste Karte kommen neben der ersten gespielten Karte nur solche Karten in Betracht, die dieselbe Farbe wie die erste gespielte Karte haben. (Nur die Karte, mit der ein Stich eröffnet wurde und Karten, die die geforderte Farbe bedient haben, können den Stich gewinnen. Abgeworfene Karten können niemals einen Stich gewinnen.) Unter diesen Karten bestimmt sich die höchste gemäss der eingangs genannten Ordnung. */
public static int hoechsteKarte(Karte[] ks) {
/* (Das übergebene Array ks stellt den vollständigen Stich dar, dessen Gewinner nun ermittelt werden muss. ) Sie können davon ausgehen, dass ks mindestens eine Karte und keine null-Einträge enthält. */
    Karte ersteKarte = ks[0];
    Farbe farbe = ersteKarte.farbe;
    int maxWert = Wert.valueOf(ersteKarte.wert.toString()).ordinal();
    int indexMax = 0;

    for (int i = 1; i < ks.length; i++) {
        Karte karte = ks[i];
        if (karte.farbe == farbe) {
            //! what if the values in the enum Wert get their order changed
            int currentWert = Wert.valueOf(karte.wert.toString()).ordinal();
            if (currentWert > maxWert) {
                maxWert = currentWert;
                indexMax = i;
            }
        }
    }

    return indexMax;
}
/* j) statische Methode Spieler: Der Methode werden ein oder mehrere Objekte vom Typ Spieler übergeben. Für diese soll eine Runde Tuppen simuliert werden. Sie können davon ausgehen, dass höchstens acht Objekte übergeben werden, von denen keines null ist. (Bei neun oder mehr Spielern würde ein Skatblatt nicht mehr ausreichen.) */
    public static Spieler spiel(Spieler... club) {
/* Zunächst müssen die spielbezogenen Attribute der übergebenen Spieler richtig gesetzt werden. Rufen Sie dazu die statische Methode void gibKarten(Spieler[] spieler, Karte[] stapel) aus der Klasse Spielverwaltung mit club und einem frischen skatblatt auf. (Hier werden den Spielern ihre je vier Karten in der korrekten Weise ausgeteilt.) */
        Spielverwaltung.gibKarten(club, Karte.skatblatt());
/* Das Spiel läuft dann wie folgt ab: Beginnend mit dem ersten Spieler in club spielt jeder Spieler genau eine Karte in den Stich. Dabei müssen die in Teilaufgabe h)
geschilderten Bedienregeln befolgt werden. */
        int anzahlSpieler = club.length;
        int indexGewinner = 0;

        for (int i = 0; i < 4; i++) {
            Karte[] gespielteKarten = new Karte[anzahlSpieler];

            if(indexGewinner != 0) {
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
/* Der Gewinner des Stichs eröffnet den nächsten Stich. Alle vier Stiche werden nach den gleichen Regeln gespielt wie der erste. Der Gewinner des vierten Stichs ist der Gewinner des Spiels und soll von der Methode zurückgegeben werden. Nutzen Sie die in den vorherigen Teilaufgaben implementierten Methoden. */
            indexGewinner = hoechsteKarte(gespielteKarten);
        }

        return club[indexGewinner];
    }
/* Ergänzen Sie die Klasse Spieler um eine main-Methode mit der bekannten Signatur. Rufen Sie darin zunächst die statische Methode Spieler[] generiereClub(int spieleranzahl) aus der Klasse Spielverwaltung auf. Übergeben Sie das erzeugte Array dann der Methode spiel und geben Sie den von ihr zurückgegebenen Spieler per System.out.println() aus. */
    public static void main(String[] args) {
        //* wir sollen laut Aufgabenstellung generiereClub eine Spieleranzahl übergeben. Welche sollen wir dafür übernehmen? Können wir die Höchstzahl an Spielern, 8, übergeben und überflüssige Spielerplätze mit null belegen? -> ihr könnt generiereClub in der Main mit einem beliebigen int i: 0<i<9 aufrufen.
        Spieler[] club = Spielverwaltung.generiereClub(8);
        Spieler gewinner = spiel(club);
        System.out.println(gewinner);
    }
}