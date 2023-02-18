public class A {
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

    public void f(Object o) {
        System.out.println("f2");
    }

    public void f(String s) {
        System.out.println("f3: " + s);
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

    public void g(Object... os) {
        System.out.println("g4");
    }

    public static void main(String[] args) {
        A a = new A((short) 1, 2);
        a.f(a.i1); //a)
        a.f(a.i2); //b)
        a.f(a.s); //c)
        a.f(.0f); //d)
        a.f(a); //e)
        a.g(1, 2); //f)
        a.g(1, 2L); //g)
        a.g(a.i2, Long.valueOf(2)); //h)
        a.g(1, 2.0); //i)
        a.g(1, 2.0f); //j)
    }
}
