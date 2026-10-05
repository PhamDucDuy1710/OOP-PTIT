import java.util.*;

class MatHang {
	private int ma;
	private String ten, nhom;
	private double gm, gb;

	MatHang(int ma, String ten, String nhom, double gm, double gb) {
		this.ma = ma;
		this.ten = ten;
		this.nhom = nhom;
		this.gm = gm;
		this.gb = gb;
	}
	public double getLn() {
		return gb - gm;
	}
	@Override
	public String toString() {
		return ma + " " + ten + " " + nhom + " " + String.format("%.2f", gb - gm);
	}
}

public class J05010 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<MatHang> a = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			String ten = sc.nextLine();
			String nhom = sc.nextLine();
			double gm = Double.parseDouble(sc.nextLine());
			double gb = Double.parseDouble(sc.nextLine());
			MatHang x = new MatHang(i, ten, nhom, gm, gb);
			a.add(x);
		}
		Collections.sort(a, (x, y) -> {
			double t1 = x.getLn();
			double t2 = y.getLn();
			return Double.compare(t2, t1);
		});
		for(MatHang i : a) {
			System.out.println(i);
		} 
	}
}