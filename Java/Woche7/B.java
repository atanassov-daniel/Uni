public class B extends A {
    public final String x;

    public B() { // Signatur : B()
        this(" written in B()");
    }

    public B(int p1) { // Signatur : B(int )
        this(" written in B( int )");
    }

    public B(A p1) { // Signatur : B(A)
        this(" written in B(A)");
    }

    public B(B p1) { // Signatur : B(B)
        this(" written in B(B)");
    }

    public B(String x) { // Signatur : B( String )
        super(" written in B( String )");
        this.x = x;
    }

    public void f(A p1) { // Signatur : B.f(A)
        System.out.println(" called B.f(A)");
    }

    public void f(B p1) { // Signatur : B.f(B)
        System.out.println(" called B.f(B)");
    }
}
