/** LineSegment repraesentiert eine Strecke zwischen zwei Endpunkten
 * @author Daniel Atanassov und LaszloHinz
 */
import java.util.Random;

public class LineSegment {
    private Point a, b;

    /** Erzeugt eine neue Strecke durch die zwei Endpunkte
     * @param p1,p2 die beiden Endpunkte der neuen Strecke
    */
    public LineSegment(Point p1, Point p2) {
        this.setA(p1);
        this.setB(p2);
    }

    /**
     * Erzeugt eine neue Strecke durch die zwei Endpunkte
    @param x1,y1 die Koordinaten des einen Endpunkts
    @param x2,y2 die Koordinaten des zweiten Endpunkts
    */
    public LineSegment(int x1, int y1, int x2, int y2) {
        this.setA(new Point(x1, y1));
        this.setB(new Point(x2, y2));
    }

    /**
     * Erzeugt eine neue Strecke, wobei die Koordinaten der Endpunkte zufaellig aus dem Intervall 0 bis (max − 1) gewaehlt werden
    @param max max-Wert vom gewuenschten Intervall
    */
    public LineSegment(int max) {
        Random rn = new Random();
        this.setA(new Point(rn.nextInt(max), rn.nextInt(max)));
        this.setB(new Point(rn.nextInt(max), rn.nextInt(max)));
    }

    /**
    * Erzeugt eine neue Strecke, wobei die Koordinaten der Endpunkte zufellig aus dem Intervall 0 bis (max − 1) gewaehlt werden, wobei der zweite Endpunkt den Abstand length zum ersten Endpunkt hat
    * @param max max-Wert vom gewuenschten Intervall
    * @param length gewuenschter Abstand des zweiten Endpunkts vom ersten Endpunkt
    */
    public LineSegment(int max, int length){
        Random rn = new Random();
        int x1 = rn.nextInt(max);
        int y1 = rn.nextInt(max);
        this.setA(new Point(x1, y1));

        int x2, y2;
        do {
            double angle = rn.nextInt(360) * Math.PI / 180;
            x2 = (int) (x1 + length * Math.cos(angle));
            y2 = (int) (y1 + length * Math.sin(angle));
        } while (x2 >= max || y2 >= max || x2 <= 0 || y2 <= 0);
        
        this.setB(new Point(x2, y2));
    }

    /** @param a erster Endpunkt der Strecke */
    public void setA(Point a){
        this.a = a;
    }
    /** @return den ersten Endpunkt der Strecke */
    public Point getA(){
        return this.a;
    }
    /** @param b zweite Endpunkt der Strecke */
    public void setB(Point b){
        this.b = b;
    }
    /** @return den zweiten Endpunkt der Strecke */
    public Point getB(){
        return this.b;
    }

    /**@return die Strecke zwischen den Endpunkten (x1,y1) und (x2,y2) als String der Form "(x1,y1) -- (x2,y2)" */
    public String toString(){
        return String.format("%s -- %s", this.getA(), this.getB());
    }

    /** 
    * @param distance gewuenschte Entfernung der letzten Strecke vom Anfangspunkt
    * @param n Anzahl der gewuenschten parallelen Strecken
    * @return Ein Array von n horizontale, parallele Strecken, beginnend bei der Strecke (0,0) -- (distance,0) und endend mit der Strecke (0,distance) -- (distance,distance), mit Abstand ywischen den Strecken (distance/(n-1))(abgerundet) */
    public static LineSegment[] spawnParallel(int distance, int n){
        if(n <= 1) return null;
        LineSegment[] arr = new LineSegment[n];

        int abstand = (int) Math.floor(distance / (n-1));
        for (int i = 0; i < n; i++) {
            arr[i] = new LineSegment(0, abstand*i, distance, abstand*i);
        }

        return arr;
    }

    /**
    * 
    * @param l unendlich lange horizontale Gerade, die definiert durch zwei Endpunkte ist
    * @return true, falls die aktuelle Instanz von LineSegment einen Schnittpunkt mit der Horizontalen l hat
    */
    private boolean intersectHorizontal(LineSegment l){
        if(l.getA().y() != l.getB().y()) return false; // wenn die Gerade l nicht horizontal ist, ist egal

        if((this.getA().y() >= l.getA().y() && this.getB().y() <= l.getA().y()) || (this.getA().y() <= l.getA().y() && this.getB().y() >= l.getA().y())){return true;}
        return false;
    }

    /**
    * @param parallel Array mit unendlich langen horizontalen Geraden, die definiert durch zwei Endpunkte sind
    * @return true, falls die aktuelle Instanz von LineSegment einen Schnittpunkt mit mindestens eine der Horizontalen aus parallel hat
    */
    private boolean intersectHorizontal(LineSegment[] parallel){
        for(LineSegment line: parallel){
            if(intersectHorizontal(line) == true){
                return true;
            }
        }
        return false;
    }

    /**
    * @param parallel Array von horizontalen Geraden
    * @param random Array von n zufaelligen Strecken
    * @return 0.0, falls kein Schnittpunkt existiert;
    * sonst returns 2*(n/m), wobei m die Anzahl der Strecken aus random ist, die mit mindestens einer der Geraden aus parallel einen Schnittpunkt haben
    g) der Wert von computeValue naehert sich mit der Zunahme der Anzahl der existierenden Geraden dem Wert von PI an
    */
    public static double computeValue(LineSegment[] parallel, LineSegment[] random){
        int n = random.length;
        int m = 0;

        for(LineSegment lineToCheck: random){
            if(lineToCheck.intersectHorizontal(parallel)){
                m++;
            }
        }
        if(m == 0) return 0.0;
        return (double) 2 * n / m;
    }
}
