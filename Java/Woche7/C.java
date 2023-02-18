public class C {
    public static void main(String[] args) {
        // a)
        A v1 = new A(100); // (1)
        System.out.println("v1.x: " + v1.x);

        A v2 = new B(100); // (2)
        System.out.println("v2.x: " + v2.x);
        System.out.println("((B) v2 ).x: " + ((B) v2).x);

        B v3 = new B(v2); // (3)
        System.out.println("((A) v3 ).x: " + ((A) v3).x);
        System.out.println("v3.x: " + v3.x);
        
        B v4 = new B(); // (4)
        System.out.println("((A) v4 ).x: " + ((A) v4).x);
        System.out.println("v4.x: " + v4.x);
        
        // b)
        v1.f(v1); // (1)
        v1.f(v2); // (2)
        v1.f(v3); // (3)
        
        v2.f(v1); // (4)
        v2.f(v2); // (5)
        
        v2.f(v3); // (6)
        v3.f(v1); // (7)
        v3.f(v2); // (8)
        v3.f(v3); // (9)
        
    }
}