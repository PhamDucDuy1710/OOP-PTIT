import java.util.*;
import java.text.*;
class KH {
	private String ma, ten, gt, ns, dc;

	KH(int ma, String ten, String gt, String ns, String dc) {
		this.ma = String.format("KH%03d", ma);
		this.ten = ten;
		this.gt = gt;
		this.ns = ns;
		this.dc = dc;
	}
	public String getNs() {
		return ns;
	}
	public String getTen() {
		String a[] = ten.toLowerCase().trim().split("\\s+");
		StringBuilder res = new StringBuilder();
		for(String w : a) {
			res.append(Character.toUpperCase(w.charAt(0))).append(w.substring(1)).append(" ");
		}
		return res.toString().trim();
	}
	@Override
	public String toString() {
		return ma + " " + getTen() + " " + gt + " " + dc + " " + ns;
	}
}

public class J05082 {
	public static void main(String[] args) throws ParseException{
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<KH> a = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String ten = sc.nextLine();
			String gt = sc.nextLine();
			String ns = sdf.format(sdf.parse(sc.nextLine()));
			String dc = sc.nextLine();
			KH x = new KH(i + 1, ten, gt, ns, dc);
			a.add(x);
		}
		Collections.sort(a, (x, y) ->{
			String t1[] = x.getNs().split("/");
			String t2[] = y.getNs().split("/");
			String d1 = t1[2] + t1[1] + t1[0];
			String d2 = t2[2] + t2[1] + t2[0];
			return d1.compareTo(d2);
		});
		for(KH i : a) {
			System.out.println(i);
		}
	}
}