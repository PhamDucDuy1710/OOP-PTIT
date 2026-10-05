import java.util.*;

class SinhVien {
	private String ma, ten, lop, mail;

	SinhVien(String ma, String ten, String lop, String mail) {
		this.ma = ma;
		this.ten = ten;
		this.lop = lop;
		this.mail = mail;	
	}
	public String getLop() {
		return lop;
	}
	public String getMa() {
		return ma;
	}
	@Override 
	public String toString() {
		return ma + " " + ten + " " + lop + " " + mail;
	}
}

public class J05021 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// int n = Integer.parseInt(sc.nextLine());
		ArrayList<SinhVien> a = new ArrayList<>();
		while(sc.hasNextLine()) {
			String ma = sc.nextLine();
			String ten = sc.nextLine();
			String lop = sc.nextLine();
			String mail = sc.nextLine();
			SinhVien x = new SinhVien(ma, ten, lop, mail);
			a.add(x);
		}
		Collections.sort(a, (x, y) -> {
			return x.getMa().compareTo(y.getMa());
		});
		for(SinhVien i : a) {
			System.out.println(i);
		}
	}
}