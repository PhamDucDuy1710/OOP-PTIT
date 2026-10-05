import java.util.*;
import java.text.*;

class SinhVien {
	private String ma, ten, lop, date;
	private double gpa;

	SinhVien(int ma, String ten, String lop, String date, double gpa) {
		this.ma = ma + "";
		while(this.ma.length() < 3) this.ma = "0" + this.ma;
		this.ma = "B20DCCN" + this.ma;
		this.ten = ch(ten);
		this.lop = lop;
		this.date = date;
		this.gpa = gpa;
	}
	public double getGpa() {
		return gpa;
	}
	public String ch(String s) {
		String words[] = s.toLowerCase().trim().split("\\s+");
		StringBuilder sb = new StringBuilder();
		for(String w : words) {
			sb.append(Character.toUpperCase(w.charAt(0))).append(w.substring(1)).append(" ");
		}
		return sb.toString().trim();
	}
	@Override
	public String toString() {
		return ma + " " + ten + " " + lop + " " + date + " " + String.format("%.2f", gpa);
	}
}

public class J05005 {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<SinhVien> a = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String ten = sc.nextLine();
			String lop = sc.nextLine();
			String date = sdf.format(sdf.parse(sc.nextLine()));
			Double gpa = Double.parseDouble(sc.nextLine());
			SinhVien x = new SinhVien(i + 1, ten, lop, date, gpa);
			a.add(x);
		}
		Collections.sort(a, (s, t) -> {
			return Double.compare(t.getGpa(), s.getGpa());
		});
		for(SinhVien i : a) {
			System.out.println(i);
		}
	}
}