/**
* Klasse, die einen Switch implementiert. Ein Switch hat genau zwei Nachfolger. Jeder Nachfolger kann jeweils entweder ein Switch sein oder null. Immer ist nur einer der Nachfolger aktiv, d.h. die Kugel bei der Murmelbahn wird in Richtung des aktiven Switches weitergeleitet. Bei den Switches sind auch zyklische Verbindungen erlaubt.
*/
public class Switch {
    private Switch succ0, succ1;
    private Switch vorfolger; // simuliert ein "drittes" Nachfolger wenn noetig
    private Switch nextActive; // zeigt welcher der beiden Nachfolger gerade aktiv ist
    private boolean alreadyCounted; // zeigt ob bei countSwitches ein Switch bereits gezaehlt wurde

    //! delete this
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //! delete until here

    //!!! should there even be setters to set particular Nachfolger from outside
    public Switch getSucc0() {
        return this.succ0;
    }

    public Switch getSucc1() {
        return this.succ1;
    }

    public void setSucc0(Switch succ0) {
        this.succ0 = succ0;
    }

    public void setSucc1(Switch succ1) {
        this.succ1 = succ1;
    }

    public Switch getVorfolger() {
        return this.vorfolger;
    }

    public void setVorfolger(Switch vorfolger) {
        this.vorfolger = vorfolger;
    }
    //!! see comment above

    /**
    * Erzeugt ein neues Switch mit zwei Nachfolger
    * @param succ0 das erste Switch-Nachfolger vom neuen Switch-Objekt, zu dem die erste ankommende Murmel weitergeleitet wird
    * @param succ1 das zweite Switch-Nachfolger vom neuen Switch-Objekt
    */
    public Switch(Switch succ0, Switch succ1) {
        this.nextActive = succ0;
        this.succ0 = succ0;
        this.succ1 = succ1;
    }

    /** 
    * Erzeugt ein Straight, d.h. ein Switch mit nur einem Nachfolger
    * @param succ Nachfolger-Element vom neuen Switch-Objekt, zu dem jede ankommende Murmel weitergeleitet wird
    */
    public Switch(Switch succ) {
        this.nextActive = succ;
        this.succ0 = succ;
        this.succ1 = null;
    }

    /**
    * Erzeugt ein neues Multi-Switch, d.h. ein Switch der sich so verhaelt, als haette er drei Nachfolger
    * @param succ0 das erste Switch-Nachfolger vom neuen Switch-Objekt, zu dem die erste ankommende Murmel weitergeleitet wird
    * @param succ1 das zweite Switch-Nachfolger vom neuen Switch-Objekt
    * @param succ2 das "dritte" Switch-Nachfolger vom neuen Switch-Objekt
    */
    public Switch(Switch succ0, Switch succ1, Switch succ2) {
        this.nextActive = succ0;
        this.succ0 = succ0;
        this.succ1 = succ1;
        this.vorfolger = succ2;
    }

    /**
    * Setzt die Attribute des Switch, auf dem die Methode aufgerufen wird, so, dass beim nächsten Aufruf von next() der jeweils andere Nachfolger zurückgegeben wird.
    @return den Switch, zu dem die nächste Kugel geleitet wird
    */
    public Switch next() {
        Switch currentlyActive = this.nextActive;
        if (currentlyActive == this.succ0) {
            this.nextActive = this.succ1;
        } else if (currentlyActive == this.succ1) {
            if (this.vorfolger == null) {
                this.nextActive = this.succ0;
            } else {
                this.nextActive = this.vorfolger;
            }
        } else if (currentlyActive == this.vorfolger) {
            this.nextActive = this.succ0;
        }

        return currentlyActive;
    }

    /** 
    * Die durch den aktuellen Switch-Objekt und seine Nachfolger erzeugte Murmelbahn wird durchlaufen. Sobald ein Ende der Bahn erreicht wird, wird
    * @return der letzte vor dem Ende durchlaufene Switch zurueckgegeben */
    public Switch findLast() {
        return findLast(this);
    }

    private static Switch findLast(Switch element) {
        Switch nextElement = element.next();
        if (nextElement == null) {
            return element;
        } else {
            return findLast(nextElement);
        }
    }

    private Switch[] directSuccessors() {
        if (this.succ0 == null && this.succ1 == null) {
            return new Switch[0];
        }
        if (this.succ0 == null) {
            return new Switch[] { this.succ1 };
        }
        if (this.succ1 == null) {
            return new Switch[] { this.succ0 };
        }
        return new Switch[] { this.succ0, this.succ1 };
    }

    /**
    * Berechnet die Anzahl der verschiedenen Switch-Objekte (nicht null), die von dem Switch, auf dem die Methode aufgerufen wird, aus erreichbar sind.
    * @return die berechnete Anzahl
    */
    public int countSwitches() {
        int count = countSwitches(this);
        reverseCountSwitches(this);
        return count;
    }

    private static int countSwitches(Switch element) {
        element.alreadyCounted = true;
        int count = 1; // Ein Switch t ist von einem Switch s aus erreichbar, wenn t==s ist, also ist das Objekt sebst von sich selbst erreichbar
        Switch[] directSuccessors = element.directSuccessors();
        if (directSuccessors.length == 0) {
            return 1;
        }
        for (Switch successor : directSuccessors) {
            if (successor.alreadyCounted == false) {
                successor.alreadyCounted = true;
                count += countSwitches(successor);
            } // wenn der Nachfolger schon gezaehlt wurde, dann tue nichts, denn seine erreichbaren Nachfolger sollten bereits gezaehlt worden sein
        }
        return count;
    }

    /**
    * bei der Methode countSwitches() wurde bei jedem gezaehlten Element das Attribut alreadyCounted zu true gesetzt, damit ein bereits gezaehltes Element nicht wieder gezaehlt wird (welche auch von einem anderen Switch getroffen werden). Diese Methode reverseCountSwitches setzt das Attribut alreadyCounted von den gezaehlten Elementen wieder zu false, damit bei einem erneuten Aufruf der Funktion countSwitches das richtige Ergebnis rauskommt (sonst wuerden die Elemente mit den Attribut alreadyCounted nicht gezaehlt werden und somit jedes Mal ein unterschiedliches Ergebnis rauskommen)
    */
    private static void reverseCountSwitches(Switch element) {
        element.alreadyCounted = false;

        Switch[] directSuccessors = element.directSuccessors();
        for (Switch successor : directSuccessors) {
            if (successor.alreadyCounted) {
                successor.alreadyCounted = false;
                reverseCountSwitches(successor);
            }
        }
    }

    /**//* Testen des Programms */
    public static void main(String[] args) {
        //* Test 1: Abbildung 1 (a) Straight Switch with just s1
        Switch straight_s1 = new Switch(null);
        straight_s1.setName("s1");;
        System.out.println("s1.findLast(): " + straight_s1.findLast().name + " ==? s1 expected");
        System.out.println("s1.findLast(): " + straight_s1.findLast().name + " ==? s1 expected");
        System.out.println("s1.next(): " + straight_s1.next() + " ==? null expected");
        System.out.println("s1.directSuccessors: " + straight_s1.directSuccessors().length + " ==? 0 expected");
        System.out.println("s1.countSwitches(): " + straight_s1.countSwitches() + " ==? 1 expected");

        //* Test 2: Abbildung 1 (b) 
        Switch s4 = new Switch(null);
        s4.setName("s4");
        Switch s3 = new Switch(null, s4);
        s3.setName("s3");
        Switch s234 = new Switch(s3, s4);
        s234.setName("s2");

        System.out.println();
        System.out.println();
        System.out.println("Test 2 Beginn");

        System.out.println();
        System.out.println("Last " + s234.findLast().name + " ==? s3 expected");
        System.out.println("Last " + s234.findLast().name + " ==? s4 expected");
        System.out.println("Last " + s234.findLast().name + " ==? s4 expected");
        System.out.println("Last " + s234.findLast().name + " ==? s4 expected");
        System.out.println("Last " + s234.findLast().name + " ==? s3 expected");
        System.out.println("Last " + s234.findLast().name + " ==? s4 expected");
        System.out.println("Last " + s234.findLast().name + " ==? s4 expected");
        System.out.println("Last " + s234.findLast().name + " ==? s4 expected");
        System.out.println();

        System.out.println("s2.next() " + s234.next().name + " ==? s3 expected");
        System.out.println("s2.next() " + s234.next().name + " ==? s4 expected");
        System.out.println("s2.next() " + s234.next().name + " ==? s3 expected");
        System.out.println("s2.next() " + s234.next().name + " ==? s4 expected");
        System.out.println("s2.next() " + s234.next().name + " ==? s3 expected");
        System.out.println("s2.next() " + s234.next().name + " ==? s4 expected");

        System.out.println("s2.directSuccessors(): " + s234.directSuccessors().length + " ==? 2 expected (s3, s4)");
        System.out.println("s2.directSuccessors(): " + s234.directSuccessors().length + " ==? 2 expected (s3, s4)");
        System.out.println("s2.directSuccessors(): " + s3.directSuccessors().length + " ==? 1 expected (s4)");
        System.out.println("s2.directSuccessors(): " + s3.directSuccessors().length + " ==? 1 expected (s4)");
        System.out.println("s2.directSuccessors(): " + s4.directSuccessors().length + " ==? 0 expected");
        System.out.println("s2.directSuccessors(): " + s4.directSuccessors().length + " ==? 0 expected");

        System.out.println("s2.countSwitches(): " + s234.countSwitches() + " ==? 3 expected (s2, s3, s4)");
        System.out.println("s2.countSwitches(): " + s234.countSwitches() + " ==? 3 expected (s2, s3, s4)");
        System.out.println("s3.countSwitches(): " + s3.countSwitches() + " ==? 2 expected (s3, s4)");
        System.out.println("s4.countSwitches(): " + s4.countSwitches() + " ==? 1 expected (s4)");
        System.out.println("s3.countSwitches(): " + s3.countSwitches() + " ==? 2 expected (s3, s4)");
        System.out.println("s4.countSwitches(): " + s4.countSwitches() + " ==? 1 expected (s4)");

        //* Test 3: Abbildung 1 (c)
        System.out.println();
        System.out.println();
        System.out.println("Test 3 Beginn");

        Switch s9 = new Switch(null);
        s9.setName("s9");
        Switch s8 = new Switch(s9);
        s8.setName("s8");
        Switch s6 = new Switch(s8);
        s6.setName("s6");
        Switch s7 = new Switch(s6, s9);
        s7.setName("s7");

        Switch s56789 = new Switch(s6, s7);
        s56789.setName("s5");
        s8 = s56789.getSucc0().getSucc0();
        s8.setSucc1(s56789); // jetzt zeigt s8 sowohl auf s9 als auch auf dem "Kopf" s5 (s56789)

        System.out.println("s5.countSwitches(): " + s56789.countSwitches() + " ==? 5 expected"); // 5
        System.out.println("s5.countSwitches(): " + s56789.countSwitches() + " ==? 5 expected"); // 5
        s8 = s56789.getSucc0().getSucc0();
        System.out.println("Nachfolger von s8: " + s8.directSuccessors().length + " ==? 2 expected"); // 2
        System.out.println("Nachfolger von s5: " + s56789.directSuccessors().length + " ==? 2 expected"); // 2
        System.out.println("Nachfolger von s6: " + s56789.getSucc0().directSuccessors().length + " ==? 1 expected"); // 1 Nachfolger
        System.out.println("Nachfolger von s7: " + s56789.getSucc1().directSuccessors().length + " ==? 2 expected"); // 2 Nachfolger
    }
}