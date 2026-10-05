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

    public double getDiem() {
        if(ma.charAt(2) == '1') return 0.5;
        else if(ma.charAt(2) == '2') return 1.0;
        else return 2.5;
    }

    public double getTongXT() {
        return d1 * 2 + d2 + d3 + getDiem();
    }
    public double getTong() {
        return d1 * 2 + d2 + d3;
    }

    public String getTt() {
        if(getTongXT() >= 24)
            return "TRUNG TUYEN";
        else
            return "TRUOT";
    }

    public String format(double x) {
        if(x == (long)x)
            return String.valueOf((long)x);
        return String.valueOf(x);
    }

    @Override
    public String toString() {
        return ma + " " + ten + " "
                + format(getDiem()) + " "
                + format(getTong()) + " "
                + getTt();
    }
}

public class J05057  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        // ArrayList<TS> a = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            double d1 = Double.parseDouble(sc.nextLine());
            double d2 = Double.parseDouble(sc.nextLine());
            double d3 = Double.parseDouble(sc.nextLine());

            TS x = new TS(ma, ten, d1, d2, d3);
            System.out.println(x);
        }
    }
}