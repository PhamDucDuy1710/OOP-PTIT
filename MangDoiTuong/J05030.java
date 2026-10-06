import java.util.*;

class SV {
	private String ma, ten, lop;
	private double d1, d2, d3;

	SV(String ma, String ten, String lop, double d1, double d2, double d3) {
		this.ma = ma;
		this.ten = ten;
		this.lop = lop;
		this.d1 = d1;
		this.d2 = d2;
		this.d3 = d3;
	}
	public String getMa(){ 
		return ma;
	}
	@Override 
	public String toString() {
		return ma + " " + ten + " " + lop + " " + d1 + " " + d2 + " " + d3;
	}
}

public class J05030 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<SV> a = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String ma = sc.nextLine();
			String ten = sc.nextLine();
			String lop = sc.nextLine();
			double d1 = Double.parseDouble(sc.nextLine());
			double d2 = Double.parseDouble(sc.nextLine());
			double d3 = Double.parseDouble(sc.nextLine());
			SV x = new SV(ma, ten, lop, d1, d2, d3);
			a.add(x);
		}
		Collections.sort(a, (x, y) -> {
			return x.getMa().compareTo(y.getMa());
		});
		int cnt = 1;
		for(SV i : a) {
			System.out.print(cnt + " ");
			System.out.println(i);
			cnt++;
		}
	}
}