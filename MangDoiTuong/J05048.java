import java.util.*;

class MH {
	private String ma;
	private long sl;

	MH(String ma, long sl) {
		this.ma = ma;
		this.sl = sl;
	}
	public String getNhom() {
		return ma.substring(0,1);
	}
	public long getXuat() {
		if(ma.charAt(0) == 'A') {
			return Math.round(sl * 0.6);
		}
		else {
			return Math.round(sl * 0.7);
		}
	}
	public long getDg() {
		if(ma.charAt(ma.length() - 1) == 'Y') {
			return 110000;
		}
		else {
			return 135000;
		}
	}
	public long getTien() {
		return getXuat() * getDg();
	}
	public long getThue() {
		char d = ma.charAt(0);
		char c = ma.charAt(ma.length() - 1);
		if(d == 'A' && c == 'Y') return Math.round(getTien() * 0.08);
		else if(d == 'A' && c == 'N') return Math.round(getTien() * 0.11);
		else if(d == 'B' && c == 'Y') return Math.round(getTien() * 0.17);
		else return Math.round(getTien() * 0.22);
 	}
 	@Override 
 	public String toString() {
 		return ma + " " + sl + " " + getXuat() + " " + getDg() + " " + getTien() + " " + getThue();
 	}
}

public class J05048 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<MH> a = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String ma = sc.nextLine();
			long sl = Long.parseLong(sc.nextLine());
			MH x = new MH(ma, sl);
			// System.out.println(x);
			a.add(x);
		}
		Collections.sort(a, (x, y) -> {
			return Long.compare(y.getThue(), x.getThue());
		});
		String s = sc.nextLine();
		for(MH i : a) {
			if(i.getNhom().equals(s)) {
				System.out.println(i);
			}
		}
	}
}