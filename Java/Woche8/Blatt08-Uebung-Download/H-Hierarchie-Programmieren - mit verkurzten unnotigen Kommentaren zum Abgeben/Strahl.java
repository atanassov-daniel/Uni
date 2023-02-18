public sealed class Strahl extends Gerade permits Strecke {
    private final boolean beginntInP1;// wenn true, dann hat der Strahl p1 als Anfangspunkt, sonst p2

    /** Erzeugt ein neuer Strahl
    * @param a der Punkt, bei dem der Strahl beginnt
    * @param b Punkt, durch den der Strahl passiert
    */
    public Strahl(Punkt a, Punkt b) {
        super(a, b);

        beginntInP1 = this.getP1().equals(a) ? true : false;
    }

    /** @return true, wenn der Strahl am Punkt p1 beginnt */
    public boolean startsFromp1() {
        return beginntInP1;
    }

    /** @return true, wenn der Strahl am Punkt p2 beginnt */
    public boolean startsFromp2() {
        return beginntInP1 == false;
    }

    /** @return String der Form "Strahl beginnt von (x1,y1) und passiert durch (x2,y2) */
    @Override
    public String toString() {
        return "Strahl beginnt von " + (this.startsFromp1() ? this.getP1() : this.getP2()) + " und passiert durch " + (this.startsFromp1() ? this.getP2() : this.getP1());
    }

    /** @return die Gerade, die entsteht, wenn man den Strahl über den Punkt, an dem der Strahl beginnt, ins Unendliche hinaus verlängert. */
    public Gerade verlaengern() {
        return new Gerade(this.getP1(), this.getP2());
        // Erläutern Sie im PDF-Teil der Abgabe, ob und ggf. warum es in Ihrer Implementierung möglich ist, die zurückgegebene Gerade nachträglich über die Punkt-Attribute des Strahls zu verändern.
        // Antwort: Es ist nicht moeglich, die zurueckgegebene Gerade nachtraeglich ueber die Punkt-Attribute des Strahls zu veraendern, denn es wird eine komplett neue Gerade erzeugt. Und auch generell bei einer unterschiedlichen Implementierung waere eine Veraenderung ueber die Punkt-Attribute des Strahls nicht moeglich, denn diese sind final, koennen also nach ihrem ersten Setzen gar nicht mehr veraendert werden.
    }

    /** @return true, wenn p0 auf dem Strahl liegt */
    @Override
    public boolean enthaelt(Punkt p0) {
        // wenn der Punkt p0 nicht auf der Geraden durch p1 und p2 liegt, dann kann er auch nicht auf dem Strahl liegen
        if (super.enthaelt(p0) == false) {
            return false;
        }

        Punkt anfang = this.beginntInP1 ? this.getP1() : this.getP2();
        Punkt secondPunkt = this.beginntInP1 ? this.getP2() : this.getP1();
        int strahlNachOben = anfang.getY().compareTo(secondPunkt.getY());

        // p0 ist ja in der Gerade enthalten. Wenn der Anfangspunkt ueber den Endpunkt steht, d.h. der Strahl zeigt nach unten, dann liegt p0 genau dann im Strahl, wenn seine y-Koordinate kleiner gleich der Koordinate vom Anfangspunkt ist
        if (strahlNachOben == 1) {
            return p0.getY().compareTo(anfang.getY()) != 1; // also wenn p0 auf dem Anfang oder unter dem Anfang liegt, dann wird true returned
        }
        // Wenn der Anfangspunkt unter den Endpunkt steht, d.h. der Strahl zeigt nach oben, dann liegt p0 genau dann im Strahl, wenn seine y-Koordinate grosser gleich der Koordinate vom Anfangspunkt ist
        if (strahlNachOben == -1) {
            return p0.getY().compareTo(anfang.getY()) != -1; // also wenn p0 auf dem Anfang oder ober dem Anfang liegt, dann wird true returned
        }
        // wenn der Strahl parallel zur x-Achse ist, dann muss die x-Koordinate von p0 beruecksichtigt werden
        if (strahlNachOben == 0) {
            // wenn der Anfang links vom secondPunkt liegt, dann zeigt der Strahl nach rechts. D.h. wenn p0 auf dem Strahl liegt, muss seine x-Koordinate groesser gleich diese vom Anfangspunkt sein
            if (anfang.getX().compareTo(secondPunkt.getX()) == 1) {
                return p0.getX().compareTo(anfang.getX()) != -1;
            }
            // wenn der Anfang rechts vom secondPunkt liegt, dann zeigt der Strahl nach links. D.h. wenn p0 auf dem Strahl liegt, muss seine x-Koordinate kleiner gleich diese vom Anfangspunkt sein
            return p0.getX().compareTo(anfang.getX()) != 1;
        }
        return false;
    }

    /** @return true, wenn beide Strahl-Objekte den gleichen Strahl repräsentieren. */
    @Override
    public boolean equals(Object obj) {
        // Zwei Strahlen sind genau dann gleich, wenn beide denselben Anfangspunkt haben und auch in die gleiche Richtung zeigen
        if (obj instanceof Strahl strahl) {
            if (super.equals(strahl) == false) {
                return false;
            }

            Punkt anfangThis = this.beginntInP1 ? this.getP1() : this.getP2();
            Punkt anfangStrahl = strahl.beginntInP1 ? strahl.getP1() : strahl.getP2();
            // wenn die beiden Strahlen ein anderes Anfangspunkt haben, dann sind sie nicht gleich
            if (anfangThis.equals(anfangStrahl) == false) {
                return false;
            }

            // Liegt der Endpunkt vom zu vergleichenden Strahl nicht auf dem ersten Strahl, dann haben sie nicht dieselbe Richtung und sind somit nicht gleich
            Punkt secondPunktStrahl = strahl.beginntInP1 ? strahl.getP2() : strahl.getP1();
            if (this.enthaelt(secondPunktStrahl) == false) {
                return false;
            }
            // Wenn der Endpunkt vom zu vergleichenden Strahl auf dem ersten Strahl liegt, dann sind die Strahlen identisch(denn sie haben ja denselben Anfangspunkt und jetzt auch dieselbe Richtung)
            return true;
        } else {
            return false;
        }

    }
}