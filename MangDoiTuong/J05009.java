import java.util.*;

class ThiSinh {
	private int ma;
	private String ten, date;
	private double d1, d2, d3;

	ThiSinh(int ma, String ten, String date, double d1, double d2, double d3) {
		this.ma = ma;
		this.ten = ten;
		this.date = date;
		this.d1 = d1;
		this.d2 = d2;
		this.d3 = d3;
	}
	public int getMa(){
        return this.ma;
    }
	public double tong(){
        return d1 + d2 + d3;
    }
	@Override 
	public String toString() {
		return ma + " " + ten + " " + date + " " + String.format("%.1f", d1 + d2 + d3);
	}
}

public class J05009 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		double maxx = -1e9;
		ArrayList<ThiSinh> a = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			String ten = sc.nextLine();
			String date = sc.nextLine();
			double d1 = Double.parseDouble(sc.nextLine());
			double d2 = Double.parseDouble(sc.nextLine());
			double d3 = Double.parseDouble(sc.nextLine());
			ThiSinh x = new ThiSinh(i, ten, date, d1, d2, d3);
			maxx = Math.max(maxx, x.tong());
			a.add(x);
		}
		Collections.sort(a, (x, y) -> {
			double t1 = x.tong();
			double t2 = y.tong();
			if(t1 == t2) return x.getMa() - y.getMa();
			return Double.compare(t1, t2);
		});
		for(ThiSinh i : a) {
			if(i.tong() == maxx) System.out.println(i);
		}	
	}
}