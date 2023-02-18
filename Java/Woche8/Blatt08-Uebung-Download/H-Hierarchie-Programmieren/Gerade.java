import java.math.*;

/** @params p1, p2 die beiden Punkte, durch die die Gerade verlaeuft */
public sealed class Gerade permits Strahl {
    // Auch eine Gerade soll nicht mehr verändert werden können, wenn sie einmal erstellt wurde
    private final Punkt p1;
    private final Punkt p2;

    public Punkt getP1() {
        return this.p1;
    }

    public Punkt getP2() {
        return this.p2;
    }

    /** Konstruktor, der die zwei Punkte p1 und p2 setzt, durch die die Gerade verlaueft.
    * @throws SinglePointException mit dem Punkt wenn die beiden Punkte der Geraden die gleichen Koordinaten haben. */
    public Gerade(Punkt p1, Punkt p2) {
        if (p1.equals(p2)) {
            // throw new SinglePointException(p1);
            //! Exception handling
        }
        boolean p1Links = punkteNormieren(p1, p2);
        this.p1 = p1Links ? p1 : p2;
        this.p2 = p1Links ? p2 : p1;
    }

    /** sorgt dafuer, dass der erste Punkt einer Gerade stets links vom zweiten Punkt liegt. Liegen die Punkte genau untereinander, soll der erste Punkt stets unter dem zweiten liegen.
    * @return true, wenn der Punkt p1 links von dem Punkt p2 liegt (oder im Fall dass p1 und p2 direkt untereinander stehen, dass p1 unter p2 liegt) */
    private static boolean punkteNormieren(Punkt p1, Punkt p2) {
        /* Liegen die Punkte genau untereinander, soll der erste Punkt stets unter dem zweiten liegen. Zwei Punkte liegen genau dann untereinander, wenn sie dieselbe x-Koordinate besitzen. */
        if (p1.getX().equals(p2.getX())) {
            // wenn die y-Koordinate von p1 kleiner ist als die y-Koordinate von p2, dann liegt p1 unter p2 und die Methode soll true zurueckgeben
            if (p1.getY().compareTo(p2.getY()) == -1) {
                return true;
            }
            return false;
        }

        // Ein Punkt p1 liegt links von einem anderen Punkt p2, wenn die x-Koordinate von p1 kleiner als die von p2 ist
        if (p1.getX().compareTo(p2.getX()) == -1) {
            return true;
        }
        return false;
    }

    /** @return einen String der Form "Gerade durch (x1,y1) und (x2,y2)" */
    @Override
    public String toString() {
        return "Gerade durch " + this.getP1() + " und " + this.getP2();
    }

    //TODO Ergänzen Sie die Klasse Gerade um die folgenden drei Hilfsmethoden. Auf diese darf von der Klasse selbst und von Unterklassen, nicht aber von außerhalb zugegriffen werden, was über den entsprechenden Zugriffsmodifikator erreicht werden kann. //! entweder sollte ich zulassen, dass auch von andere Klassen im Paket zugegeriffen wird, oder ich sollte Gerade als ihr eigenes Paket erfassen
    /** @return true, wenn p0 auf der Geraden zwischen den Punkten p1 und p2 oder auf einem dieser beiden Punkte liegt */
    protected boolean zwischenp1p2(Punkt p0) { //TODO Zugriffsmodifikator
        // wenn der Wert von s zwischen 0 und 1 liegt, dann liegt der Punkt p0 zwischen p1 und p2, sonst liegt p0 immer noch auf der Geraden, aber ausserhalb den Punkten p1 und p2
        BigDecimal s = liegtAufGerade(this, p0);
        if (s == null) {
            return false;
        }
        return s.compareTo(new BigDecimal(0)) != -1 && s.compareTo(new BigDecimal(1)) != 1;
    }

    /** @return true, wenn p0 so auf der Geraden liegt, dass der Abstand zu p1 kleiner als zu p2 ist und p0 außerdem nicht zwischen p1 und p2 liegt */
    protected boolean vorp1(Punkt p0) { //TODO Zugriffsmodifikator
        // wenn der Punkt p0 zwischen p1 und p2 liegt oder wenn der Punkt p0 ueberhaupt nicht auf der Geraden leigt, muss false returned werden
        if (this.zwischenp1p2(p0) == true || liegtAufGerade(this, p0) == null) {
            return false;
        }
        if (p0.abstand(this.p1).compareTo(p0.abstand(this.p2)) == -1) {
            return true;
        }
        return false;
    }

    /** @return true, wenn p0 zwar auf der Geraden liegt, aber keine der ersten beiden Methoden beim Aufruf mit p0 als Parameter true zurückgibt */
    protected boolean hinterp2(Punkt p0) {//TODO Zugriffsmodifikator
        if (this.zwischenp1p2(p0) || this.vorp1(p0)) {
            return false;
        }
        return liegtAufGerade(this, p0) != null;
        // in diesem Fall liegt der Punkt p0 irgendwo auf den Teil der Gerade, der nicht zwischen p1 und p2 liegt, also vom unendlichen Teil der Gerade
    }

    /** @return null, falls der Punkt p0 nicht auf der Gerade line liegt; sonst wenn p0 auf der Gerade line liegt, wird der Skalar s zurueckgegeben */
    private static BigDecimal liegtAufGerade(Gerade line, Punkt p0) {
        // rvX ist der Richtungsvektor vom Punkt p1 nach p2
        // der Stuetzvektor der Gerade ist einfach p1
        Punkt p1 = line.getP1();
        Punkt p2 = line.getP2();

        BigDecimal rvX = p2.getX().subtract(p1.getX());
        BigDecimal rvY = p2.getY().subtract(p1.getY());
        BigDecimal p0X = p0.getX();
        BigDecimal p0Y = p0.getY();

        /* Um herauszufinden, ob p0 auf der Gerade durch p1 und p2 liegt, loese folgendes Lineares Gleichungssystem (Formel aus der Schule dazu, ob ein Punkt auf einer Gerade im 2D-Raum liegt)
            p1.x + s*rvX = p0X <=> s*rvX = p0X - p1.x <=> s = (p0X - p1.x) / rvX
            p1.y + s*rvY = p0Y <=> s*rvY = p0Y - p1.y <=> s = (p0Y - p1.y) / rvY
        
        Falls das Ergebnis fuer s in beiden Gleichungen gleich ist, dann liegt das Punkt p0 auf der Geraden
        */

        // Gleichung der Form s*0 = p0X - p1.x -> Wenn (p0X - p1.x) == 0 ist, dann kann s jede reelle Zahl sein. Sonst gibt es keine Loesung fuer das LGS und der Punkt liegt nicht auf der Gerade
        boolean rvXgleich0 = BigDecimalUtility.equalValues(rvX, new BigDecimal(0));
        boolean rvYgleich0 = BigDecimalUtility.equalValues(rvY, new BigDecimal(0));
        if (rvXgleich0 || rvYgleich0) {
            boolean s1Undefiniert = rvXgleich0
                    && BigDecimalUtility.equalValues(p0X.subtract(p1.getX()), new BigDecimal(0)) == false;
            boolean s2Undefiniert = rvYgleich0
                    && BigDecimalUtility.equalValues(p0Y.subtract(p1.getY()), new BigDecimal(0)) == false;

            // wenn s1 oder s2 nicht definiert ist, dann hat das LGS keine Loesung
            if (s1Undefiniert || s2Undefiniert) {
                return null;
            }
            if (rvXgleich0 && rvYgleich0) { // return eine beliebige Zahl
                return new BigDecimal(1);
            }
            if (rvXgleich0) { // s1 ist eine beliebige Zahl, also ist die Loesung des LGS der Schnitt von s1 und s2, also s2
                return p0Y.subtract(p1.getY()).divide(rvY, 30, RoundingMode.HALF_EVEN);
            }
            if (rvYgleich0) { // s2 ist eine beliebige Zahl, also ist die Loesung des LGS der Schnitt von s1 und s2, also s1
                return p0X.subtract(p1.getX()).divide(rvX, 30, RoundingMode.HALF_EVEN);
            }
        }

        BigDecimal s1 = p0X.subtract(p1.getX()).divide(rvX, 30, RoundingMode.HALF_EVEN);
        BigDecimal s2 = p0Y.subtract(p1.getY()).divide(rvY, 30, RoundingMode.HALF_EVEN);

        if (BigDecimalUtility.equalValues(s1, s2) == false) {
            return null;
        }
        return s1;
    }

    /** @return true, wenn p0 auf der Geraden liegt */
    public boolean enthaelt(Punkt p0) {
        // return this.zwischenp1p2(p0) || this.vorp1(p0) || this.hinterp2(p0);
        return liegtAufGerade(this, p0) != null;
    }

    public boolean equals(Object obj) {
        //! Gestalten Sie Ihre Implementierung mit Blick auf die folgenden Aufgabenteile bereits so, dass alle durchgeführten Abfragen, bei denen dies Sinn ergibt, symmetrisch sowohl für this als auch für obj durchgeführt werden.
        //! Im Hinweis steht Folgendes:
        //! Nutzen Sie die Methode obj.getClass(), um die Klasse eines Objekts obj zu bestimmen. Der Rückgabewert der Methode ist vom Typ Class. Mit obj1.getClass().equals(obj2.getClass()) können Sie prüfen, ob die Objekte obj1 und obj2 von exakt derselben Klasse sind. Wäre bspw. die Klasse von obj1 Unterklasse der Klasse von obj2, würde dieser Ausdruck zu false auswerten.
        //! Ich glaube, das bedeutet, dass diese Methode nur fuer tatsaechliche Gerade-Objekte funktionieren muss und nicht auch fuer Unterklassen davon
        if (obj instanceof Gerade gerade) {
            if (this.getClass().equals(gerade.getClass())) {
                return this.enthaelt(gerade.getP1()) && this.enthaelt(gerade.getP2());// wenn beide Punkte von der zu vergleichenden Gerade auch in der ersten Gerade liegen, dann sind die Geraden gleich
            }
        }
        return false;
    }
}