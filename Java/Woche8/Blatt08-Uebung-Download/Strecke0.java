import java.math.*;

public final class Strecke0 extends Strahl {
    public Strecke0(Punkt a, Punkt b) {
        super(a, b);
        //TODO gut mit moeglichen Exceptions umgehen
    }

    /** 
    * @param swap falls true, wird die Verlaengerung ueber p2 hinaus vorgenommen; sonst ueber p1 hinaus
    * @return den Strahl, der entsteht, wenn man die Strecke über einen der Endpunkte ins Unendliche hinaus verlängert.
    */
    public Strahl verlaengern(boolean swap) {
        if (swap) {
            return new Strahl(this.getP1(), this.getP2());
        }
        return new Strahl(this.getP2(), this.getP1());
    }

    //i) Die Methode toString() muss überschrieben werden, denn eine Strecke hat unterschiedliche Eigenschaften von ein Objekt der Oberklassen Strahl, und die toString-Methode muss möglichst gut den aktuellen Objekt beschreiben.
    @Override
    public String toString() {
        return "Strecke zwischen " + this.getP1() + " und " + this.getP2();
    }

    //i) Die Methode Gerade verlaengern() muss nicht überschrieben werden. //! ICH MUSS TESTEN OB DAS TATSACHLICH SO IST ODER WEIL GERADE DIE OBERKLASSE DER OBERKLASSE IST DIE METHODE HIER NICHT FUNKTIONIEREN WIRD
    //i) boolean enthaelt(Punkt p0) müsste überschrieben werden, denn sonst würde man gegebenenfalls ein falsches positives Ergebnis bekommen, wenn der Punkt p0 auf dem Strahl liegt, der durch p1 und p2 definiert ist, aber in dem Teil vom Strahl, der außerhalb der Grenzen der Strecke liegt.
    @Override
    public boolean enthaelt(Punkt p0) {
        Punkt p1 = this.getP1();
        Punkt p2 = this.getP2();

        if (super.enthaelt(p0) == false) {
            return false;
        }

        // wenn die Strecke parallel zur x-Achse ist, dann liegt p0 in der Strecke genau dann, wenn p0 eine x-Koordinate hat, die im Interval [p1.x, p2.x] liegt
        if (p1.getY().compareTo(p2.getY()) == 0) {
            return (p0.getX().compareTo(p1.getX()) != -1 && p0.getX().compareTo(p2.getX()) != 1);
        }

        BigDecimal max = p1.getY().max(p2.getY());
        BigDecimal min = p1.getY().min(p2.getY());
        // damit p0 in der Strecke liegt, muss sein y-Wert zwischen den y-Werten von den Punkten p1 und p2 liegen, d.h. groesser gleich den Minimum (!= -1) und kleiner gleich dem Maximum der y-Werte von p1 und p2 sein ()
        return p0.getY().compareTo(min) != -1 && p0.getY().compareTo(max) != 1;
    }

    //i) Die Methode boolean equals(Object obj) müsste auch überschrieben werden. Das liegt daran, dass die Gleichheit von zwei Strecken unterschiedlich von der Gleichheit von zwei Strahlen definiert ist. Nämlich waren zwei Strahlen gleich, wenn sie am gleichen Punkt anfangen und dann die gleiche Richtung haben. Bei Strecken hingegen müssen sowohl der Anfangspunkt als auch der Endpunkt gleich sein, bis auf die Reihenfolge.
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Strecke0 strecke) {
            //! was genau soll in diese Methode passieren mit dem Typ des als Argument gegebenen Object
            boolean firstPointIsTheSame = this.getP1().equals(strecke.getP1()) || this.getP1().equals(strecke.getP2());
            boolean secondPointIsTheSame = this.getP2().equals(strecke.getP2()) || this.getP2().equals(strecke.getP1());
            return firstPointIsTheSame && secondPointIsTheSame;
        }
        return false;
    }

}
