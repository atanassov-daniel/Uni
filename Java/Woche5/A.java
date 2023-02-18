class A {
    private int i1;
    private Integer i2;
    private short s;

    public A(Short s, int i) {
        this.i1 = s;
        this.i2 = i;
        this.s = s;
    }

    public void f(Integer i) {
        System.out.println("f1");
    }

    public void f(String s) {
        System.out.println("f2: " + s);
    }

    public void f(double d) {
        System.out.println("f3");
    }

    public void g(int i, float d) {
        System.out.println("g1");
    }

    public void g(Integer i, Long j) {
        System.out.println("g2");
    }

    public void g(int... is) {
        System.out.println("g3");
    }

    public void g(double... is) {
        System.out.println("g4");
    }

    public static void main(String[] args) {
        A a = new A((short) 1, 2);
        System.out.print("a   ");
        a.f(a.i1);
        System.out.print("b   ");
        a.f(a.i2);
        System.out.print("c   ");
        a.f(a.s);
        System.out.print("d   ");
        a.f(.0f);

        System.out.println("\n");

        System.out.print("e   ");
        a.g(1, 2);
        System.out.print("f   ");
        a.g(1, 2L);
        System.out.print("g   ");
        a.g(a.i2, Long.valueOf(2));
        System.out.print("h   ");
        a.g(1 ,2.0);
        System.out.print("i   ");
        a.g(1,2.0f);
    }
}