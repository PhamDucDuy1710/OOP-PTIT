import java.util.*;

class Player {
	private String ma, ten, gr, gv;
	private int time;

	Player(String ma, String ten, String gv, String gr) {
		this.ma = ma;
		this.ten = ten;
		this.time = 60 * (Integer.parseInt(gr.substring(0, 2)) - Integer.parseInt(gv.substring(0,2))) 
					+ (Integer.parseInt(gr.substring(3)) - Integer.parseInt(gv.substring(3)));
	}
	public int getGio() {
		return this.time;
	}
	public String getTime() {
		int h = time / 60;
		int m = time % 60;
		return String.format("%d gio %d phut", h, m);
	}
	@Override 
	public String toString() {
		return ma + " " + ten + " " + getTime(); 
	}
}
public class J05011 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<Player> a = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String ma = sc.nextLine();
			String ten = sc.nextLine();
			String gv = sc.nextLine();
			String gr = sc.nextLine();
			Player x = new Player(ma, ten, gv, gr);
			a.add(x);
		}
		Collections.sort(a, (x, y) -> {
			return Integer.compare(y.getGio(), x.getGio());
		});	
		for(Player i : a) {
			System.out.println(i);
		}
	}
}