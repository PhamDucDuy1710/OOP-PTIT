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

public class J05025 {
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
		Collections.sort(a, (x, y) -> {
			if(!x.getTen().equals(y.getTen())) {
				return x.getTen().compareTo(y.getTen());
			}
			return x.getMa().compareTo(y.getMa());
		});
		for(GV i : a) {
			System.out.println(i);
		}
	}
}