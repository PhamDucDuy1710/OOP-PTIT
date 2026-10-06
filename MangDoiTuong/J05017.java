import java.util.*;

class KH {
	private int ma;
	private String ten;
	private double csc, csm;

	KH(int ma, String ten, double csc, double csm) {
		this.ma = ma;
		this.ten = ten;
		this.csc = csc;
		this.csm = csm;
	}
	public String getMa() {
		return String.format("KH%02d", ma);
	}
	public double getTong() {
		double n = csm - csc;
        if (n <= 50) {
            return n * 102;
        }
        if (n <= 100) {
            return (50 * 100 + (n - 50) * 150) * 1.03;
        }
        return (50 * 100 + 50 * 150 + (n - 100) * 200) * 1.05;
	}
	@Override
	public String toString() {
		return getMa() + " " + ten + " " + (int) Math.round(getTong());
	}
}
public class J05017 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<KH> a = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String ten = sc.nextLine();
			double csc = Double.parseDouble(sc.nextLine());
			double csm = Double.parseDouble(sc.nextLine());
			KH x = new KH(i + 1, ten, csc, csm);
			a.add(x);
		}
		Collections.sort(a, (x, y) -> { 
			return Double.compare(y.getTong(), x.getTong());
		});
		for(KH i : a) {
			System.out.println(i);
		}
		sc.close();
	}
}