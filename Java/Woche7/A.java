public class A {
    public final String x;

    public A() { // Signatur : A()
        this(" written in A()");
    }

    public A(int p1) { // Signatur : A(int )
        this(" written in A( int )");
    }

    public A(String x) { // Signatur : A( String )
        this.x = x;
    }

    public void f(A p1) { // Signatur : A.f(A)
        System.out.println(" called A.f(A)");
    }
}