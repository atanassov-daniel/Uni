public class TSeiteneffekte {
	public static void main(String[] args) {
		TWrapper[] ws = new TWrapper[2];
		ws[0] = new TWrapper();
		ws[1] = new TWrapper();

		ws[0].value = 2;
		ws[1].value = 1;

		f(ws[1], new TWrapper[] { ws[1], ws[0] });

		// Speicherzustand hier zeichnen
	}

	public static void f(TWrapper w1, TWrapper[] ws) {
		int sum = 0;

		// Speicherzustand hier zeichnen

		for (int j = 0; j < ws.length; j++) {
			TWrapper w = ws[j];
			sum += w.value;
			w.value = j + 2;
		}

		// Speicherzustand hier zeichnen

		w1 = ws[1];
		w1.value = -sum;
	}
}

