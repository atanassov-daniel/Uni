public class BubbleSort {
	public static void sort(int[] a) {
		for (int n = 0; n < a.length; n++) {
			for (int i = 0; i < a.length - n; i++) {
				if (i == a.length - n - 1)
					continue;
				if (a[i] > a[i + 1]) {
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
				}
			}
		}
	}
}
