import java.util.*;

class MH {
	private String ma, ten, dv;
	private int gm, gb;

	MH(int ma, String ten, String dv, int gm, int gb) {
		this.ma = String.format("MH%03d", ma);
		this.ten = ten;
		this.dv = dv;
		this.gm = gm;
		this.gb = gb;
	}
	public String getMa() {
		return ma;
	}
	public int getLn() {
		return gb - gm;
	}
	@Override 
	public String toString() {
		return ma + " " + ten + " " + dv + " " + gm + " " + gb + " " + getLn();
	}
}

public class J05081 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<MH> a = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			String ten = sc.nextLine();
			String dv = sc.nextLine();
			int gm = Integer.parseInt(sc.nextLine());
			int gb = Integer.parseInt(sc.nextLine());
			MH x = new MH(i, ten, dv, gm, gb);
			a.add(x);
		}
		Collections.sort(a, (x, y) -> {
			if(x.getLn() != y.getLn()) return Integer.compare(y.getLn(), x.getLn());
			return x.getMa().compareTo(y.getMa());
		});
		for(MH i : a) {
			System.out.println(i);
		}
	}
}