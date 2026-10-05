import java.util.*;

class DN {
	private String ma, ten;
	private int ssv;

	DN(String ma, String ten, int ssv) {
		this.ma = ma;
		this.ten = ten;
		this.ssv = ssv;
	}
	public int getSv() {
		return ssv;
	}
	public String getMa() {
		return ma;
	}
	@Override
	public String toString() {
		return ma + " " + ten + " " + ssv;
	}
}
public class J05028 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<DN> a = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String ma = sc.nextLine();
			String ten = sc.nextLine();
			int ssv = Integer.parseInt(sc.nextLine());
			DN x = new DN(ma, ten, ssv);
			a.add(x);
		}
		Collections.sort(a, (x, y) ->{
			if(x.getSv() != y.getSv()) {
				return Integer.compare(y.getSv(), x.getSv());
			} 
			return x.getMa().compareTo(y.getMa());
		});
		for(DN i : a) {
			System.out.println(i);
		}
	}
}
