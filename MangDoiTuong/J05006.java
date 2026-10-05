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
	@Override 
	public String toString() {
		return ma + " " + ten + " " + gt + " " + ns + " " + dc + " " + mst + " " + nk;
	}
}

public class J05006 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < n; i++) {
			String ten = sc.nextLine();
			String gt = sc.nextLine();
			String ns = sc.nextLine();
			String dc = sc.nextLine();
			String mst = sc.nextLine();
			String nk = sc.nextLine();
			NhanVien a = new NhanVien(i + 1, ten, gt, ns, dc, mst, nk);
			System.out.println(a);
		}
	}
}