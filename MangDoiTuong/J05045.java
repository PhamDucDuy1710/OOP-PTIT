import java.util.*;

class NV {
	private String ma, ten, cv;
	private double ln, nc;

	NV(int ma, String ten, String cv, double ln, double nc) {
		this.ma = String.format("NV%02d", ma);
		this.ten = ten;
		this.ln = ln;
		this.nc = nc;
		this.cv = cv;
	}
	public double getPc() {
		switch (cv) {
			case "GD":
				return 500;
			case "PGD":
				return 400;
			case "TP":
				return 300;
			case "KT":
				return 250;
			default:
				return 100;
		}
	}
	public String getMa() {
		return ma;
	}
	public double getLt() {
		return ln * nc;
	}
	public double getTu() {
    	double ans = (getPc() + getLt()) * 2 / 3;

    	if(ans < 25000) {
        	return Math.round(ans / 1000.0) * 1000;
    	}
    	else {
        	return 25000;
    	}
	}
	public double getTn() {
		return getLt() + getPc();
	}
	public double getCl() {
		return getLt() + getPc() - getTu();
	}
	@Override
	public String toString() {
		return ma + " " + ten + " "
        + (long) getPc() + " "
        + (long) getLt() + " "
        + (long) Math.round(getTu() / 1000.0) * 1000 + " "
        + (long) getCl();
	}
}

public class J05045 {
	public static void main(String[]  args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<NV> a = new ArrayList<>();
		// long ans = 0;
		for(int i = 1; i <= n; i++) {
			String ten = sc.nextLine();
			String cv = sc.nextLine();
			double ln = Double.parseDouble(sc.nextLine());
			double nc = Double.parseDouble(sc.nextLine());
			NV x = new NV(i, ten, cv, ln, nc);
			a.add(x);
			// System.out.println(x);
			// ans += (long) Math.round(x.getTong());
		}
		Collections.sort(a, (x, y) -> {
			if(x.getTn() != y.getTn()) return Double.compare(y.getTn(), x.getTn());
			return x.getMa().compareTo(y.getMa());
		});
		for(NV i : a) {
			System.out.println(i);
		}
	}
}