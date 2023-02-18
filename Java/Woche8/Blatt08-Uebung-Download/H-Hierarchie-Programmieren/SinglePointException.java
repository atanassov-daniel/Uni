/** Exception-Klasse, hat ein Attribut des Typs
Punkt, das nach der Erstellung nicht mehr veraendert werden kann. */
public class SinglePointException extends Exception {
    private final Punkt punkt;

    /** nimmt einen Parameter des Typs Punkt entgegen und setzt den Wert seines einzigen Attributs auf den Wert des übergebenen Parameters. */
    public SinglePointException(Punkt punkt) {
        this.punkt = punkt;
    }

    /** @return einen String der Form "Doppelte Benutzung des Punktes (x,y)" */
    @Override
    public String toString() {
        return "Doppelte Benutzung des Punktes " + this.punkt.toString();
    }
}
