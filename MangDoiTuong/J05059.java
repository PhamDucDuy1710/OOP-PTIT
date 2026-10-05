import java.util.*;

class TS {
    private String ma, ten;
    private double d1, d2, d3;

    TS(String ma, String ten, double d1, double d2, double d3) {
        this.ma = ma;
        this.ten = ten;
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
    }

    public String getMa() {
        return ma;
    }

    public double getUuTien() {
        if(ma.charAt(2) == '1')
            return 0.5;
        else if(ma.charAt(2) == '2')
            return 1.0;
        else
            return 2.5;
    }

    public double getTong() {
        return d1 * 2 + d2 + d3 + getUuTien();
    }

    public String format(double x) {
        if(x == (long)x)
            return String.valueOf((long)x);
        return String.valueOf(x);
    }

    public String getTt(double diemChuan) {
        if(getTong() >= diemChuan)
            return "TRUNG TUYEN";
        return "TRUOT";
    }

    @Override
    public String toString() {
        return ma + " " + ten + " "
                + format(getUuTien()) + " "
                + format(getTong());
    }
}

public class J05059 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        ArrayList<TS> a = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            double d1 = Double.parseDouble(sc.nextLine());
            double d2 = Double.parseDouble(sc.nextLine());
            double d3 = Double.parseDouble(sc.nextLine());

            a.add(new TS(ma, ten, d1, d2, d3));
        }

        int chiTieu = Integer.parseInt(sc.nextLine());
        Collections.sort(a, (x, y) -> {
            if(x.getTong() != y.getTong())
                return Double.compare(y.getTong(), x.getTong());

            return x.getMa().compareTo(y.getMa());
        });
        double diemChuan = a.get(chiTieu - 1).getTong();

        System.out.printf("%.1f%n", diemChuan);
        for(TS x : a) {
            System.out.println(x + " " + x.getTt(diemChuan));
        }
    }
}