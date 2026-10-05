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

public class J05022 {
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
			System.out.println("DANH SACH SINH VIEN LOP " + s + ":");
			for(SinhVien i : a) {
				if(i.getLop().equals(s)) {
					System.out.println(i);
				}
			} 
		}
	}
}