public class VSeiteneffekte {
	public static void main(String[] args) {
		VWrapper w1 = new VWrapper();
		VWrapper w2 = w1;

		w1.i = 1;
		w2.i = 2;
		
		int x = 3;
		int[] a = { 1, 2 };

		f(w1, x, new int[] { 4, 5 });
		f(w2, x, a);
		//Speicherzustand hier zeichnen
	}

	public static void f(VWrapper w, int x, int[] a) {
		//Speicherzustand hier zeichnen
		x = a[0];
		a[0] = w.i;
		w.i = x;
	}
}
