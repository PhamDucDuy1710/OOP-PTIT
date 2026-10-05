import java.util.*;

class SV {
	private String ten;
	private int c, s;

	SV(String ten, int c, int s) {
		this.ten = ten;
		this.c = c;
		this.s = s;
	}
	public int getS() {
		return s;
	}
	public int getC() {
		return c;
	}
	public String getTen() {
		return ten;
	}
	@Override 
	public String toString() {
		return ten + " " + c + " " + s;
	}
}

public class J05042 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<SV> a = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String ten = sc.nextLine();
			int c = sc.nextInt();
			int s = sc.nextInt();
			sc.nextLine();
			SV x = new SV(ten, c, s);
			a.add(x);
		}
		Collections.sort(a, (x, y) -> {
			if(x.getC() != y.getC()) return Integer.compare(y.getC(), x.getC());
			if(x.getS() != y.getS()) return Integer.compare(x.getS(), y.getS());
			return x.getTen().compareTo(y.getTen());
 		});
 		for(SV i : a) {
 			System.out.println(i);
 		}
	}
}