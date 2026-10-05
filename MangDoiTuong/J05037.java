import java.util.*;

class MH { 
	private String ma, ten, dv;
	private double dg, sl;

	MH(int ma, String ten, String dv, double dg, double sl) {
		this.ma = String.format("MH%02d", ma);
		this.ten = ten;
		this.dv = dv;
		this.dg = dg;
		this.sl = sl;
	}
	public double getPvc() {
		return (double) dg * sl * 0.05;
	}
	public double getTt() {
		return (double) dg * sl + getPvc();
	}
	public double getGb() {
		return getTt() * 1.02 / sl;
	}
	@Override 
	public String toString() {
		return ma + " " + ten + " " + dv + " " + (long) Math.round(getPvc()) + " " + (long) Math.round(getTt()) + " " + (long) Math.ceil(getGb() / 100.0) * 100;
	}
}

public class J05037 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<MH> a = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			String ten = sc.nextLine();
			String dv = sc.nextLine();
			double dg = Double.parseDouble(sc.nextLine());
			double sl = Double.parseDouble(sc.nextLine());
			MH x = new MH(i, ten, dv, dg, sl);
			a.add(x);
		}
		Collections.sort(a, (x, y) -> {
			return Double.compare(y.getGb(), x.getGb());
		});
		for(MH i : a) {
			System.out.println(i);
		}
	}
}