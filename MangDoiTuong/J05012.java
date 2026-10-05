import java.util.*;

class MatHang {
	private String ma, ten;
	private long sl, dg, ck;

	MatHang(String ma, String ten, long sl, long dg, long ck) {
		this.ma = ma;
		this.ten = ten;
		this.sl = sl;
		this.dg = dg;
		this.ck = ck;
	}
	public long getTong() {
		return sl * dg - ck;
	}
	@Override 
	public String toString() {
		return ma + " " + ten + " " + sl + " " + dg + " " + ck + " " + getTong();
	}
}

public class J05012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<MatHang> a = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String ma = sc.nextLine();
			String ten = sc.nextLine();
			long sl = Long.parseLong(sc.nextLine());
			long dg = Long.parseLong(sc.nextLine());
			long ck = Long.parseLong(sc.nextLine());
			MatHang x = new MatHang(ma, ten, sl, dg, ck);
			a.add(x);
		}
		Collections.sort(a, (x, y) -> {
			return (Long.compare(y.getTong(), x.getTong()));
		});
		for(MatHang i : a) {
			System.out.println(i);
		} 
	}
}