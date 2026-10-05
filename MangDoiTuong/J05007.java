import java.util.*;

class NhanVien {
	private String ma, ten, gt, ns, dc, mst, nk;
	NhanVien(int ma, String ten, String gt, String ns, String dc, String mst, String nk) {
		this.ma = ma + "";
		while(this.ma.length() < 5) this.ma = "0" + this.ma;
		this.ten = ten;
		this.gt = gt;
		this.ns = ns;
		this.dc = dc;
		this.mst = mst;
		this.nk = nk; 
	}	
	public String getNs() {
		return ns;
	}
	@Override 
	public String toString() {
		return ma + " " + ten + " " + gt + " " + ns + " " + dc + " " + mst + " " + nk;
	}
}

public class J05007 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<NhanVien> a = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String ten = sc.nextLine();
			String gt = sc.nextLine();
			String ns = sc.nextLine();
			String dc = sc.nextLine();
			String mst = sc.nextLine();
			String nk = sc.nextLine();
			NhanVien x = new NhanVien(i + 1, ten, gt, ns, dc, mst, nk);
			a.add(x);
		}
		Collections.sort(a, (x, y) -> {
			String tmp1[] = x.getNs().split("/");
			String tmp2[] = y.getNs().split("/");
			String s = tmp1[2] + tmp1[1] + tmp1[0];
			String t = tmp2[2] + tmp2[1] + tmp2[0];
			return s.compareTo(t);
		});
		for(NhanVien i : a) {
			System.out.println(i);
		}
	}
}