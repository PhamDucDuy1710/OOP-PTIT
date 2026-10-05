import java.util.*;

class DH {
	private String ten, ma;
	private long sl, dg;

	DH(String ten, String ma, long sl, long dg) {
		this.ten = ten;
		this.ma = ma;
		this.sl = sl;
		this.dg = dg;
	}
	public String getStt() {
		return ma.substring(1,4);
	}
	public long getG() {
		if(ma.charAt(ma.length() - 1) == '1') {
			return Math.round((double) sl * dg * 50 / 100);
		}
		else {
			return Math.round((double) sl * dg * 30 / 100);
		}
	}
	public long getTt() {
		return sl * dg - getG();
	}
	@Override 
	public String toString() {
		return ten + " " + ma + " " + getStt() + " " + getG() + " " + getTt();
	}
}

public class J05053 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<DH> a = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String ten = sc.nextLine();
			String ma = sc.nextLine();
			long dg = Long.parseLong(sc.nextLine());
			long sl = Long.parseLong(sc.nextLine());
			DH x = new DH(ten, ma, sl, dg);
			// System.out.println(x);
			a.add(x);
		}
		Collections.sort(a, (x, y) ->{
			return x.getStt().compareTo(y.getStt());
		});
		for(DH i : a) {
			System.out.println(i);
		}
	}
}