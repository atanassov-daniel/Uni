/** Point repraesentiert einen (2-dimensionalen) Punkt. */
public record Point(int x, int y) {
    /** @return das aktuelle Objekt mit Koordinaten x und y als String der Form "(x,y)" */
    public String toString() {
        return String.format("(%d,%d)", this.x, this.y);
    }

    /** @return die 2-Norm des aktuellen Punktes */
    public double norm2() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }
}
