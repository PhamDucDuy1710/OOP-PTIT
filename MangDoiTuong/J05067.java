import java.util.*;

class MH {
	private String ma;
	private long sl;

	MH(String ma, long sl) {
		this.ma = ma;
		this.sl = sl;
	}
	public String getTen() {
		String t = ma.substring(ma.length() - 2);
		switch (t) {
			case "BP":
				return "British Petro";
			case "ES":
				return "Esso"; 
			case "SH":
				return "Shell";
			case "CA":
				return "Castrol";
			case "MO":
				return "Mobil";
			case "TN":
				return "Trong Nuoc";
			default:
				return "";
		}
	}
	public long getThue() {
		String t = ma.substring(ma.length() - 2);
		String c = ma.substring(0, 1);
		if(c.equals("X") && !t.equals("TN")) {
			return Math.round((double) 128000 * sl * 0.03);
		}
		else if(c.equals("D") && !t.equals("TN")) {
			return Math.round((double) 11200 * sl * 0.035);
		}
		else if(c.equals("N") && !t.equals("TN")) {
			return Math.round((double) 9700 * sl * 0.02);
		}
		else if(c.equals("X") && t.equals("TN")) {
			return 0;
		}
		else if(c.equals("D") && t.equals("TN")) {
			return 0;
		}
		else {
			return 0;
		}
	}
	public long getDon() {
		String c = ma.substring(0, 1);
		if(c.equals("X")) return 128000;
		else if(c.equals("D")) return 11200;
		else return 9700;
	}
	public long getTien() {
		String c = ma.substring(0, 1);
		if(c.equals("X")) return 128000 * sl;
		else if(c.equals("D")) return 11200 * sl;
		else return 9700 * sl;
	}
	public long getTt() {
		return getTien() + getThue();
	}
	@Override
	public String toString() {
		return ma + " " + getTen() + " " + getDon() + " " + getThue() + " " + getTt();
	}
}

public class J05067 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < n; i++) {
			String ma = sc.next();
			long sl = sc.nextLong();
			MH x = new MH(ma, sl);
			System.out.println(x);
		}
	}
}