import java.util.*;
import java.text.*;
import java.util.concurrent.TimeUnit;
class KH {
	private int id, fee;
	private String name, room;
	private Date checkIn, checkOut;

	KH(int id, String name, String room, String checkIn, String checkOut, int fee) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		this.id = id;
		this.name = name;
		this.room = room;
		this.checkIn = simpleDateFormat.parse(checkIn);
		this.checkOut = simpleDateFormat.parse(checkOut);
		this.fee = fee;
	}
	public String getId() {
		return String.format("KH%02d", id);
	}
	public int getDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		long d = checkOut.getTime() - checkIn.getTime();
		long day = TimeUnit.MILLISECONDS.toDays(d);
		return (int) day + 1;
	}
	private int getPrice() {
		int n = Integer.parseInt(room.substring(0, 1));
		switch (n) {
			case 1:
				return 25;
			case 2: 
				return 34;
			case 3:
				return 50;
			case 4:
				return 80;
			default:
				return 0;
		}
	}
	public int getTong() {
		return getDay() * getPrice() + fee;
	}
	@Override
	public String toString() {
		return getId() + " " + name + " " + room + " " + getDay()  + " " + getTong();
	}
}

public class J05016 {
	public static void main(String[] args) throws ParseException  {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		ArrayList<KH> a = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			String name = sc.nextLine();
			String room = sc.nextLine();
			String checkIn = sc.nextLine();
			String checkOut = sc.nextLine();
			int fee = Integer.parseInt(sc.nextLine());
			KH x = new KH(i + 1, name, room, checkIn, checkOut, fee);
			a.add(x);
		}
		Collections.sort(a, (x, y) -> {
			return Integer.compare(y.getTong(), x.getTong());
		});
		for(KH i : a) {
			System.out.println(i);
		}
	}
}