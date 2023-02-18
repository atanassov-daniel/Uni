class TestGerade {
    public static void main(String[] args) {
        System.out.println("--------------------------------------------");
        System.out.println("Test 1 Gerade with:");
        Punkt p1 = TestUtils.neuerPunkt();
        Punkt p2 = TestUtils.neuerPunkt();
        Gerade g1 = new Gerade(p1, p2);

        System.out.println("toString():");
        System.out.println(g1);
        System.out.println("-----------");
        System.out.println(
                "Check if die LinksNormierung tatsaechlich funktioniert ->      Die gerade wurde erstellt mit p1 = "
                        + p1 + " und p2 = " + p2);
        System.out.println("-----------");

        System.out.println("getP1():");
        System.out.println(g1.getP1());
        System.out.println("-----------");
        System.out.println("getP2():");
        System.out.println(g1.getP2());
        System.out.println("-----------");
        // g1.p1 = new Punkt(x2, y2); // doesn't work, just as expected to
        Punkt p0 = TestUtils.neuerPunkt();
        System.out.println("enthaelt(Punkt p0) mit p0 = " + p0 + ":");
        System.out.println(g1.enthaelt(p0));
        System.out.println("-----------");
        for (int i = 0; i < 100000; i++) {
            p0 = TestUtils.neuerPunkt();
            /*  System.out.println("Versuch " + i + "  enthaelt(Punkt p0) mit p0 = " + p0 + ":");
            System.out.println(g1.enthaelt(p0));
            System.out.println("-----------"); */
            if (g1.enthaelt(p0) == true) {
                System.out.println("Versuch " + i + "  enthaelt(Punkt p0) mit p0 = " + p0 + ":");
                System.out.println(g1.enthaelt(p0));
                System.out.println("-----------");
                break;
            }
        }

        Gerade gleichG1 = new Gerade(p1, p2);
        System.out.println("g1.equals(gleichG1), wobei g1=" + g1 + " und gleichG1=" + gleichG1 + ":");
        System.out.println(g1.equals(gleichG1));
        System.out.println("-----------");
        gleichG1 = new Gerade(p2, p1);
        System.out.println("g1.equals(gleichG1), wobei g1=" + g1 + " und gleichG1=" + gleichG1 + ":");
        System.out.println(g1.equals(gleichG1));
        System.out.println("-----------");

        // So kann bspw. die x-Achse durch die Punkte (0, 0) und (1, 0), aber ebenso durch die Punkte (1, 0) und (2, 0) repräsentiert werden.
        Gerade g2 = new Gerade(new Punkt(0, 0), new Punkt(1, 0));
        Gerade identischG2 = new Gerade(new Punkt(1, 0), new Punkt(2, 0));
        System.out.println("g2.equals(identischG2), wobei g2=" + g2 + " und identischG2=" + identischG2 + ":");
        System.out.println(g2.equals(identischG2));
        System.out.println("-----------");

        /* 
        System.out.println("--------------------------------------------");
        System.out.println("Test 2 Gerade throw Exception when two identical points get passed as an argument:");
        Gerade g1 = new Gerade(new Punkt(x1, y1), new Punkt(x1, y1));
        */
    }
}