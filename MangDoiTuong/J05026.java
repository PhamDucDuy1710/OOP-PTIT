import java.util.*;

class GV {
	private String ma, ten, bomon;

	GV(int ma, String ten, String bomon) {
		this.ma = String.format("GV%02d", ma);
		this.ten = ten;
		this.bomon = bomon;
	}
	public String getVT() {
		String a[] = bomon.toUpperCase().trim().split("\\s+");
		String res = "";
		for(String w : a) {
			res += w.charAt(0);
		} 
		return res;
	}
	public String getMa(){ 
		return ma;
	}
	public String getTen() {
		String a[] = ten.trim().split("\\s+");
		String t = a[a.length - 1];
		return t;
	}
	@Override
	public String toString() {
		return ma + " " + ten + " " + getVT();
	}
}

public class J05026 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<GV> a = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String ten = sc.nextLine();
			String bomon = sc.nextLine();
			GV x = new GV(i + 1, ten, bomon);
			a.add(x);
		}
		int t = Integer.parseInt(sc.nextLine());
		while(t-- >0) {
			String s = sc.nextLine();
			String m[] = s.toUpperCase().trim().split("\\s+");
			String res = "";
			for(String w : m) {
				res += w.charAt(0);
			}
			System.out.println("DANH SACH GIANG VIEN BO MON " + res + ":");
			for(GV i : a) {
				if(i.getVT().equals(res)) {
					System.out.println(i);
				}
			}
		}
	}
}