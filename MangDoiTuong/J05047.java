import java.util.*;

class MH {
	private String ma, ten;
	private long sl, dg;

	MH(String ma, String ten, long sl, long dg) {
		this.ma = ma;
		this.ten = ten;
		this.sl = sl;
		this.dg = dg;
	}
	public long getCk() {
		int pt = 0;
		if(sl > 10) pt = 5;
		else if(sl >= 8) pt = 2;
		else if(sl >= 5) pt = 1;
		else pt = 0;
		return (dg * sl * pt) / 100;
 	}
 	public long getTt() {
 		return dg * sl - getCk();
 	}
 	@Override 
 	public String toString() {
 		return ma + " " + ten + " " + getCk() + " " + getTt();
 	}
}

public class J05047 {
	public static String getPre(String s) {
		String words[] = s.toUpperCase().trim().split("\\s+");
		String res = "" + words[0].charAt(0) + words[1].charAt(0);
		return res; 
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		HashMap<String, Integer> mp = new HashMap<>();
		ArrayList<MH> a = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String ten = sc.nextLine();
			long sl = Long.parseLong(sc.nextLine());
			long dg = Long.parseLong(sc.nextLine());

			String pre = getPre(ten);
			int cnt = mp.getOrDefault(pre, 0) + 1;
			mp.put(pre, cnt);
			String ma = String.format("%s%02d", pre, cnt);
			MH x = new MH(ma, ten, sl, dg);
			// System.out.println(x);
			a.add(x);
		}
		Collections.sort(a, (x, y) -> {
			return Long.compare(y.getCk(), x.getCk());
		});
		for(MH i : a) {
			System.out.println(i);
		}
	}
}