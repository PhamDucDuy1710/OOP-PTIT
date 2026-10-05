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

public class J05023 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<SinhVien> a = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String ma = sc.nextLine();
			String ten = sc.nextLine();
			String lop = sc.nextLine();
			String mail = sc.nextLine();
			SinhVien x = new SinhVien(ma, ten, lop, mail);
			a.add(x);
		}
		int t = Integer.parseInt(sc.nextLine());
		while(t-- >0) {
			String s = sc.nextLine();
			String k = s.substring(2);
			System.out.println("DANH SACH SINH VIEN KHOA " + s + ":");
			for(SinhVien i : a) {
				String m = i.getLop().substring(1,3);
				if(m.equals(k)) {
					System.out.println(i);
				}
			} 
		}
	}
}