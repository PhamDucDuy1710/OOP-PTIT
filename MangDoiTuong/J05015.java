import java.util.*;

class Person {
	private String ten, nhom, tg;

	Person(String ten, String nhom, String tg) {
		this.ten = ten;
		this.nhom = nhom;
		this.tg = tg;
	}
	public String getId() {
		String s1[] = nhom.split(" ");
		String res = "";
		for(String i : s1) {
			res += i.charAt(0);
		}
		String s2[] = ten.split(" ");
		for(String i : s2) {
			res += i.charAt(0);
		}
		return res.toUpperCase();
	}
	public double getSpeed() {
		double h = Double.parseDouble(tg.substring(0, 1)) - 6;
		double s = Double.parseDouble(tg.substring(2, 4)) / 60;
		return (double) 120 / (s + h);
	}
	@Override
	public String toString() {
		return getId() + " " + ten + " " + nhom + " " + (int) Math.round(getSpeed()) + " Km/h";
	}
}

public class J05015 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<Person> a = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String ten = sc.nextLine();
			String nhom = sc.nextLine();
			String tg = sc.nextLine();
			Person x = new Person(ten, nhom, tg);
			a.add(x);
		}
		Collections.sort(a, (x, y) -> {
			return Double.compare(y.getSpeed(), x.getSpeed());
		});
		for(Person i : a) {
			System.out.println(i);
		}
	}
}