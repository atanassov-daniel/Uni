/**
 * Program for drawing a square fractal.
 */
public class Squares {

    /**
     * @param args Contains the parameters for the drawing. The first 
     *             (mandatory) is the recursion level. The second (optional) 
     *             is the base length of the first square. The default value 
     *             for this length is 100 if it is not specified. Each 
     *             parameter must be positive.
     */
    public static void main(String[] args) {
        int level;
        int length = 100;
        switch (args.length) {
            case 2:
                length = Integer.parseInt(args[1]);
                // fall-through
            case 1:
                level = Integer.parseInt(args[0]);
                break;
            default:
                System.out.println(
                        "Es muessen zwischen 1 und 2 Parameter angegeben werden "
                                + "(Level und eventuell Basislaenge)!");
                return;
        }
        if (level < 1) {
            System.out.println("Das Rekursionslevel muss positiv sein!");
            return;
        }
        if (length < 1) {
            System.out.println("Die Basislaenge muss positiv sein!");
            return;
        }
        Canvas c = new Canvas();
        Squares.paintFractal(c, level, length);
        c.refresh();
    }

    /**
     * Draws a square fractal with the specified recursion level and base length 
     * on the specified canvas.
     * @param c The canvas to draw the tree on.
     * @param level The current recursion level.
     * @param length The current length.
     */
    private static void paintFractal(Canvas c, int level, double length) {
        if (level <= 0) {
            return;
        }
        c.square(length);

        c.move(-length / 2, -length / 2);
        paintFractal(c, level - 1, length / 2);

        c.move(0, length);
        paintFractal(c, level - 1, length / 2);

        c.move(length, 0);
        paintFractal(c, level - 1, length / 2);

        c.move(0, -length);
        paintFractal(c, level - 1, length / 2);

        c.move(-length / 2, length / 2);
    }

}
