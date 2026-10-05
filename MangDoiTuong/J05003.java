import java.util.*;
import java.text.*;

class Student {
	private String id, name, lop, date;
	private double gpa;

	Student(int id, String name, String lop, String date, double gpa) {
		this.id = id + "";
		while(this.id.length() < 3) this.id = "0" + this.id;
		this.id = "B20DCCN" + this.id;
		this.name = name;
		this.lop = lop;
		this.date = date;
		this.gpa = gpa;
	}
	@Override 
	public String toString() {
		return id + " " + name + " " + lop + " " + date + " " + String.format("%.2f", gpa);
	}
}

public class J05003 {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		int n = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < n; i++) {
			String name = sc.nextLine();
			String lop = sc.nextLine();
			String date = sdf.format(sdf.parse(sc.nextLine()));
			double gpa = Double.parseDouble(sc.nextLine());
			Student a = new Student(i + 1, name, lop, date, gpa);
			System.out.println(a);
		}
	}
}