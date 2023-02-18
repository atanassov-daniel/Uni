public class TestStrecke {
    public static void main(String[] args) {
        System.out.println("--------------------------------------------");
        System.out.println("Test 1 Strecke with:");
        Punkt p1 = TestUtils.neuerPunkt();
        Punkt p2 = TestUtils.neuerPunkt();
        Strecke strecke1 = new Strecke(p1, p2);

        System.out.println("toString():");
        System.out.println(strecke1);
        System.out.println("-----------");
        System.out.println(
                "Check if die LinksNormierung tatsaechlich funktioniert ->      Der Strecke wurde erstellt mit p1 = "
                        + p1 + " und p2 = " + p2);
        System.out.println("-----------");

        System.out.println("getP1():");
        System.out.println(strecke1.getP1());
        System.out.println("-----------");
        System.out.println("getP2():");
        System.out.println(strecke1.getP2());
        System.out.println("-----------");

        System.out.println("strecke1.startsFromp1():");
        System.out.println(strecke1.startsFromp1());
        System.out.println("-----------");
        System.out.println("strecke1.startsFromp2():");
        System.out.println(strecke1.startsFromp2());
        System.out.println("-----------");

        // g1.p1 = new Punkt(x2, y2); // doesn't work, just as expected to
        Punkt p0 = TestUtils.neuerPunkt();
        System.out.println("enthaelt(Punkt p0) mit p0 = " + p0 + ":");
        System.out.println(strecke1.enthaelt(p0));
        System.out.println("-----------");
        Punkt enthaltenInStrecke1 = null;
        for (int i = 0; i < 100000; i++) {
            p0 = TestUtils.neuerPunkt();
            /*  System.out.println("Versuch " + i + "  enthaelt(Punkt p0) mit p0 = " + p0 + ":");
            System.out.println(g1.enthaelt(p0));
            System.out.println("-----------"); */
            if (strecke1.enthaelt(p0) == true) {
                enthaltenInStrecke1 = p0;
                System.out.println("Versuch " + i + "  enthaelt(Punkt p0) mit p0 = " + p0 + ":");
                System.out.println(strecke1.enthaelt(p0));
                System.out.println("-----------");
                break;
            }
        }

        System.out.println("strecke1.verlaengern():");
        System.out.println(strecke1.verlaengern());
        System.out.println("-----------");

        System.out.println("strecke1.verlaengern(true) mit strecke1=" + strecke1 + " und wird verlengert ueber p2=" + p2
                + " hinaus, also p1=" + p1 + " bleibt konstant");
        System.out.println(strecke1.verlaengern(true));
        System.out.println("-----------");
        System.out.println("strecke1.verlaengern(false) mit strecke1=" + strecke1 + " und wird verlengert ueber p1="
                + p1 + " hinaus, also p2=" + p2 + " bleibt konstant");
        System.out.println(strecke1.verlaengern(false));
        System.out.println("-----------");

        Strecke identisch = new Strecke(p1, p2);
        Strecke identischReverse = new Strecke(p2, p1);
        System.out.println("strecke1.equals(identisch):");
        System.out.println(strecke1.equals(identisch));
        System.out.println("strecke1.equals(identischReverse):");
        System.out.println(strecke1.equals(identischReverse));
        System.out.println("-----------");

        if (enthaltenInStrecke1 != null) {
            Strecke similar = new Strecke(p1, enthaltenInStrecke1);
            System.out.println("strecke1.equals(nichtIdentischeStrecke):");
            System.out.println(strecke1.equals(similar)); // false
            System.out.println("-----------");
        }

    }
}
