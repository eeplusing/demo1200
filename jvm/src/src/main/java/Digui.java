

public class Digui {
	private Long i = 0L;

	public static void main(String[] a) {
		Digui d = new Digui();
		d.test(0, 0L);
	}

	public void test(int a, double b) {
		i++;
		System.out.println("=====" + i);
		test(a, b);
	}
}
