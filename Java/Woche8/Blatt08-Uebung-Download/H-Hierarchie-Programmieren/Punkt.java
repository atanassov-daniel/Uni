import java.math.*;

/** Repraesentiert einen Punkt im zweidimensionalen Raum. Ein Punkt kann nicht mehr verändert werden, wenn er einmal erstellt worden ist(also gibt es nur Getter und keine Setter fuer die Attribute x und y). */
public class Punkt {
    private final BigDecimal x;
    private final BigDecimal y;

    public BigDecimal getX() {
        return this.x;
    }

    public BigDecimal getY() {
        return this.y;
    }

    /** Erzeugt einen Punkt aus zwei Attributen vom Typ BigDecimal */
    public Punkt(BigDecimal x, BigDecimal y) {
        this.x = x;
        this.y = y;
    }

    /** erzeugt einen Punkt aus zwei Koordinaten vom Typ double */
    public Punkt(double x, double y) {
        this.x = new BigDecimal(x);
        this.y = new BigDecimal(y);
    }

    /** @return die Koordinaten des Punkts in der Form (x,y) */
    @Override
    public String toString() {
        return "(" + this.getX() + "," + this.getY() + ")";
    }

    /** @return den euklidischen Abstand zwischen dem Punkt, auf dem die Methode aufgerufen wird und dem uebergebenen Punkt p2*/
    public BigDecimal abstand(Punkt p2) {
        /*  abstand = sqrt( (x2 - x1)^2 + (y2 - y1)^2 ) */
        BigDecimal x2MinusX1 = p2.getX().subtract(this.getX());
        BigDecimal y2MinusY1 = p2.getY().subtract(this.getY());
        BigDecimal x2MinusX1Hoch2 = x2MinusX1.multiply(x2MinusX1);
        BigDecimal y2MinusY1Hoch2 = y2MinusY1.multiply(y2MinusY1);
        BigDecimal abstandHoch2 = x2MinusX1Hoch2.add(y2MinusY1Hoch2);

        return BigDecimalUtility.sqrt(abstandHoch2);
        //! Beachten Sie, dass dieser Abstand nie negativ ist. 
    }

    /** returns true, wenn das übergebene Objekt obj vom Typ Punkt ist und die gleichen Koordinaten besitzt wie der Punkt, auf dem die Methode aufgerufen wird. */
    public boolean equals(Object obj) {
        if (obj instanceof Punkt compareTo) {
            return BigDecimalUtility.equalValues(this.getX(), compareTo.getX())
                    && BigDecimalUtility.equalValues(this.getY(), compareTo.getY());
        }
        return false;
    }

}
