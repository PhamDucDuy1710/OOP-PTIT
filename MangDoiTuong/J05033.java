import java.util.*;

class Gio {
	private int h, m, s;

	Gio(int h, int m, int s) {
		this.h = h;
		this.m = m;
		this.s = s;
	}
	public int getH() {
		return h;
	}
	public int getM() {
		return m;
	}
	public int getS() {
		return s;
	}
	@Override 
	public String toString() {
		return h + " " + m + " " + s;
	}
}

public class J05033 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<Gio> a = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			int h = sc.nextInt();
			int m = sc.nextInt();
			int s = sc.nextInt();
			Gio x = new Gio(h, m, s);
			a.add(x);
		}
		Collections.sort(a, (x, y) ->{
			int h1 = x.getH(), h2 = y.getH();
			int m1 = x.getM(), m2 = y.getM();
			int s1 = x.getS(), s2 = y.getS();
			if(h1 != h2) return Integer.compare(h1, h2);
			if(m1 != m2) return Integer.compare(m1, m2);
			return Integer.compare(s1, s2);
		});
		for(Gio i : a) {
			System.out.println(i);
		}
	}
}