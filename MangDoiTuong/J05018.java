import java.util.*;

class HS {
	private String ten, ma, xl;
	private double dtb;

	HS(int ma, String ten, double diem[]) {
		this.ma = String.format("HS%02d", ma);
		this.ten = ten;

		double tongdiem = diem[0] * 2 + diem[1] * 2;
		for(int i = 2; i < 10; i++) {
			tongdiem += diem[i];
		}
		double tb = tongdiem / 12;
		this.dtb = Math.round(tb * 10.0) / 10.0;
		if(this.dtb >= 9.0) {
			this.xl = "XUAT SAC";
		}
		else if(this.dtb >= 8.0) {
			this.xl = "GIOI";
		}
		else if(this.dtb >= 7.0) {
			this.xl = "KHA";
		}
		else if(this.dtb >= 5.0) {
			this.xl = "TB";
		}
		else {
			this.xl = "YEU";
		}
	}
	public String getMa() {
		return ma;
	}
	public double getDiemTB() {
		return dtb;
	}
	@Override 
	public String toString() {
		return ma + " " + ten + " " + String.format("%.1f", dtb) + " " + xl;
	}
}

public class J05018 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<HS> a = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String ten = sc.nextLine();
			double diem[] = new double[10];
			for(int j = 0; j < 10; j++) {
				diem[j] = sc.nextDouble();
			}
			if(sc.hasNextLine()) {
				sc.nextLine();
			}
			HS x = new HS(i + 1, ten, diem);
			a.add(x);
		}
		Collections.sort(a, (x, y) -> {
			if(Double.compare(y.getDiemTB(), x.getDiemTB()) != 0) {
				return Double.compare(y.getDiemTB(), x.getDiemTB());
			}
			return x.getMa().compareTo(y.getMa());
		});
		for(HS i : a) {
			System.out.println(i);
		}
	}
}