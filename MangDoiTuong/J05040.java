import java.util.*;

class NV {
	private String ma, ten, cv;
	private double ln, nc;

	NV(int ma, String ten, double ln, double nc, String cv) {
		this.ma = String.format("NV%02d", ma);
		this.ten = ten;
		this.ln = ln;
		this.nc = nc;
		this.cv = cv;
	}
	public double getPc() {
		switch (cv) {
			case "GD":
				return 250000;
			case "PGD":
				return 200000;
			case "TP":
				return 180000;
			case "NV":
				return 150000;
			default:
				return 0;
		}
	}
	public double getLt() {
		return ln * nc;
	}
	public double getThuong() {
		if(nc >= 25) return getLt() * 0.2;
		if(nc >= 22) return getLt() * 0.1;
		else return 0;
	}
	public double getTong() {
		return getPc() + getLt() + getThuong();
	}
	@Override
	public String toString() {
		return ma + " " + ten + " " + (long) Math.round(getLt()) + " " + (long) Math.round(getThuong()) + " " + (long) Math.round(getPc()) + " " + (long) Math.round(getTong());
	}
}

public class J05040 {
	public static void main(String[]  args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		// long ans = 0;
		for(int i = 1; i <= n; i++) {
			String ten = sc.nextLine();
			double ln = Double.parseDouble(sc.nextLine());
			double nc = Double.parseDouble(sc.nextLine());
			String cv = sc.nextLine();
			NV x = new NV(i, ten, ln, nc, cv);
			System.out.println(x);
			// ans += (long) Math.round(x.getTong());
		}
		// System.out.println("Tong chi phi tien luong: " + ans);
	}
}
