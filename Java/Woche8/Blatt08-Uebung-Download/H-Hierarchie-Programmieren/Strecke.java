public final class Strecke extends Strahl {
    public Strecke(Punkt a, Punkt b) {
        super(a, b);
        //TODO gut mit moeglichen Exceptions umgehen
    }

    /** 
    * @param swap falls true, wird die Verlaengerung ueber p2 hinaus vorgenommen; sonst ueber p1 hinaus
    * @return den Strahl, der entsteht, wenn man die Strecke über einen der Endpunkte ins Unendliche hinaus verlängert.
    */
    public Strahl verlaengern(boolean swap) {
        Punkt firstPoint = this.startsFromp1() ? this.getP1() : this.getP2();
        Punkt secondPoint = this.startsFromp1() ? this.getP2() : this.getP1();
        if (swap) {
            return new Strahl(firstPoint, secondPoint);
        }
        return new Strahl(secondPoint, firstPoint);
    }

    // i) Die Methode toString() muss überschrieben werden, denn eine Strecke hat unterschiedliche Eigenschaften von ein Objekt der Oberklasse Strahl, und die toString-Methode muss möglichst gut den aktuellen Objekt beschreiben.
    @Override
    public String toString() {
        return "Strecke zwischen " + this.getP1() + " und " + this.getP2();
    }

    //i) Die Methode Gerade verlaengern() muss nicht überschrieben werden. Strecke ist eine Unterklasse von Strahl, welche wiederum eine Unterklasse von Gerade ist. Strecke hat also genauso wie Strahl und Gerade die Attribute p1 und p2 für die zwei Punkte, durch die die Strecke definiert ist. Diese zwei Punkte können problemlos durch die Methode verlaengern() von der Oberklasse Strahl benutzt werden, um eine Gerade zu erzeugen, die durch p1 und p2 verläuft. verlaengern() braucht also nicht überschrieben zu werden
    //i) boolean enthaelt(Punkt p0) müsste überschrieben werden, denn sonst würde man gegebenenfalls ein falsches positives Ergebnis bekommen, wenn der Punkt p0 auf dem Strahl liegt, der durch p1 und p2 definiert ist, aber in dem Teil vom Strahl, der außerhalb der Grenzen der Strecke liegt.
    @Override
    public boolean enthaelt(Punkt p0) {
        return this.zwischenp1p2(p0);
    }

    //i) Die Methode boolean equals(Object obj) müsste auch überschrieben werden. Das liegt daran, dass die Gleichheit von zwei Strecken unterschiedlich von der Gleichheit von zwei Strahlen definiert ist. Nämlich waren zwei Strahlen gleich, wenn sie am gleichen Punkt anfangen und dann die gleiche Richtung haben. Bei Strecken hingegen müssen sowohl der Anfangspunkt als auch der Endpunkt gleich sein, bis auf ihre Reihenfolge.
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Strecke strecke) {
            //! was genau soll in diese Methode passieren mit dem Typ des als Argument gegebenen Object
            boolean firstPointIsTheSame = this.getP1().equals(strecke.getP1())
                    || this.getP1().equals(strecke.getP2());
            boolean secondPointIsTheSame = this.getP2().equals(strecke.getP2())
                    || this.getP2().equals(strecke.getP1());
            return firstPointIsTheSame && secondPointIsTheSame;
        }
        return false;
    }
}