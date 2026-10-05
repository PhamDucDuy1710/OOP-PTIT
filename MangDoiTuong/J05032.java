import java.util.*;

class Person { 
	private String ten, ns;

	Person(String ten, String ns) {
		this.ten = ten;
		this.ns = ns;
	}
	public String getNs() {
		return ns;
	}
	@Override 
	public String toString() {
		return ten;
	}
}

public class J05032 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<Person> a = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String ten = sc.next();
			String ns = sc.next();
			Person x = new Person(ten, ns);
			a.add(x);
		}
		Collections.sort(a, (x, y) ->{
			String t1[] = x.getNs().split("/");
			String t2[] = y.getNs().split("/");
			String d1 = t1[2] + t1[1] + t1[0];
			String d2 = t2[2] + t2[1] + t2[0];
			return d1.compareTo(d2);
		});
		System.out.println(a.get(a.size() - 1));
		System.out.println(a.get(0));
	}
}