/**
 * Buerger
 */
public class Buerger {
    private final String name;

    public Buerger(String name) {
        this.name = name;
        // this.name = name + ""; // error, weil schon initialisiert
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.name;
    }
    
}