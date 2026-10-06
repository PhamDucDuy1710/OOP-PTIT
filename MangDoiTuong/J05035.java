import java.util.*;

class SV {
	private int stt;
	private String ma, ten, lop, dc, dn;

	SV(int stt, String ma, String ten, String lop, String dc, String dn) {
		this.stt = stt;
		this.ma = ma;
		this.ten = ten;
		this.lop = lop;
		this.dc = dc;
		this.dn = dn;
	}
	public String getTen() {
		return ten;
	}
	public String getMa() {
		return ma;
	}
	public String getDn() {
		return dn;
	}
	@Override
	public String toString() {
		return stt + " " + ma + " " + ten + " " + lop + " " + dc + " " + dn;
	}
}
public class J05035 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<SV> a = new ArrayList<>();
		for(int i = 1; i <= n; i++) { 
			String ma = sc.nextLine();
			String ten = sc.nextLine();
			String lop = sc.nextLine();
			String dc = sc.nextLine();
			String dn = sc.nextLine();
			SV x = new SV(i, ma, ten, lop, dc, dn);
			a.add(x);
		}
		Collections.sort(a, (x, y) -> {
			return x.getMa().compareTo(y.getMa());
		});
		int t = Integer.parseInt(sc.nextLine());
		while (t-- >0) {
			String s = sc.nextLine();
			for(SV i : a) {
				if(i.getDn().equals(s)) {
					System.out.println(i);
				}
			}
		}
	}
}