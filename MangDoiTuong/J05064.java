import java.util.*;

class GV {
	private String ma, ten;
	private long lcb;

	GV(String ma, String ten, long lcb) {
		this.ma = ma;
		this.ten = ten;
		this.lcb = lcb;
	}
	public int getBac() {
		return Integer.parseInt(ma.substring(2));
	}
	public int getPc() {
		String t = ma.substring(0, 2);
		switch (t) {
			case "HT":
				return 2000000;
			case "HP":
				return 900000;
			case "GV":
				return 500000;
			default:
				return 0;
		}
	}
	public long getLuong() {
		return lcb * getBac() + getPc();
	}
	@Override	
	public String toString() {
		return ma + " " + ten + " " + getBac() + " " + getPc() + " " + getLuong();
	}
}

public class J05064 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int ht = 0;
		int hp = 0;
		for(int i = 0; i < n; i++) {
			String ma = sc.nextLine();
			String ten = sc.nextLine();
			long lcb = Long.parseLong(sc.nextLine());
			String chucVu = ma.substring(0, 2);
			if (chucVu.equals("HT")) {
				if (ht == 1) {
					continue;
				}
				ht++;
			}
			if (chucVu.equals("HP")) {
				if (hp == 2) {
					continue;
				}
				hp++;
			}
			GV a = new GV(ma, ten, lcb);
			System.out.println(a);
		}
	}
}