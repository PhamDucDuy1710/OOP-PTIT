import java.util.*;

class MH { 
	private String ma, ten, loai;

	MH(String ma, String ten, String loai) {
		this.ma = ma;
		this.ten = ten;
		this.loai = loai;
	}
	public String getMa() {
		return ma;
	}
	public String getTen() {
		return ten;
	}
	public String getLoai() {
		return loai;
	}
}

public class J05076 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<MH> a = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String ma = sc.nextLine();
			String ten = sc.nextLine();
			String loai = sc.nextLine();
			MH x = new MH(ma, ten, loai);
			a.add(x);
		}
		int m = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < m; i++) {
			String ma = sc.next();
			long slN = sc.nextLong();
			long dg = sc.nextLong();
			long slX = sc.nextLong();
			for(MH mh : a) {
				if(mh.getMa().equals(ma)) {
					long nhap = slN * dg;

					int ln;
					if(mh.getLoai().equals("A")) {
						ln = 8;
					}
					else if(mh.getLoai().equals("B")) {
						ln = 5;
					}
					else {
						ln = 2;
					}
					long xuat = slX * dg * (100 + ln) / 100;
					System.out.println(mh.getMa() + " " + mh.getTen() + " " + nhap + " " + xuat);
					break;
				}
			}
		}
	}
}