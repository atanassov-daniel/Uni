public class TestStrahl {
    public static void main(String[] args) {
        System.out.println("--------------------------------------------");
        System.out.println("Test 1 Strahl with:");
        Punkt p1 = TestUtils.neuerPunkt();
        Punkt p2 = TestUtils.neuerPunkt();
        Strahl strahl1 = new Strahl(p1, p2);

        System.out.println("toString():");
        System.out.println(strahl1);
        System.out.println("-----------");
        System.out.println(
                "Check if die LinksNormierung tatsaechlich funktioniert ->      Der Strahl wurde erstellt mit p1 = "
                        + p1 + " und p2 = " + p2);
        System.out.println("-----------");

        System.out.println("getP1():");
        System.out.println(strahl1.getP1());
        System.out.println("-----------");
        System.out.println("getP2():");
        System.out.println(strahl1.getP2());
        System.out.println("-----------");

        System.out.println("strahl1.startsFromp1():");
        System.out.println(strahl1.startsFromp1());
        System.out.println("-----------");
        System.out.println("strahl1.startsFromp2():");
        System.out.println(strahl1.startsFromp2());
        System.out.println("-----------");
        
        // g1.p1 = new Punkt(x2, y2); // doesn't work, just as expected to
        Punkt p0 = TestUtils.neuerPunkt();
        System.out.println("enthaelt(Punkt p0) mit p0 = " + p0 + ":");
        System.out.println(strahl1.enthaelt(p0));
        System.out.println("-----------");
        for(int i = 0; i < 100000; i++){
            p0 = TestUtils.neuerPunkt();
           /*  System.out.println("Versuch " + i + "  enthaelt(Punkt p0) mit p0 = " + p0 + ":");
            System.out.println(g1.enthaelt(p0));
            System.out.println("-----------"); */
            if(strahl1.enthaelt(p0) == true) {
                System.out.println("Versuch " + i + "  enthaelt(Punkt p0) mit p0 = " + p0 + ":");
                System.out.println(strahl1.enthaelt(p0));
                System.out.println("-----------");
                break;
            }
        }

        System.out.println("strahl1.verlaengern():");
        System.out.println(strahl1.verlaengern());
        System.out.println("-----------");

    }
}
