public final class Strecke extends Strahl {
    public Strecke(Punkt a, Punkt b) {
        super(a, b);
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

    @Override
    public String toString() {
        return "Strecke zwischen " + this.getP1() + " und " + this.getP2();
    }

    @Override
    public boolean enthaelt(Punkt p0) {
        return this.zwischenp1p2(p0);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Strecke strecke) {
            boolean firstPointIsTheSame = this.getP1().equals(strecke.getP1()) || this.getP1().equals(strecke.getP2());
            boolean secondPointIsTheSame = this.getP2().equals(strecke.getP2()) || this.getP2().equals(strecke.getP1());
            return firstPointIsTheSame && secondPointIsTheSame;
        }
        return false;
    }
}