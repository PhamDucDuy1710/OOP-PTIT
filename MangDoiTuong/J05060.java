import java.util.*;

class ThiSinh {
    private String ma, ten, ns;
    private double lt, th;

    ThiSinh(int ma, String ten, String ns, double lt, double th) {
        this.ma = String.format("PH%02d", ma);
        this.ten = ten;
        this.ns = ns;
        this.lt = lt;
        this.th = th;
    }

    public int getTuoi() {
        int namSinh = Integer.parseInt(ns.substring(6));
        return 2021 - namSinh;
    }

    public double getThuong() {
        if(lt >= 8 && th >= 8)
            return 1;
        else if(lt >= 7.5 && th >= 7.5)
            return 0.5;
        else
            return 0;
    }

    public int getDiem() {
        double diem = (lt + th) / 2 + getThuong();

        if(diem > 10)
            diem = 10;

        return (int)Math.round(diem);
    }

    public String getLoai() {
        int diem = getDiem();

        if(diem < 5)
            return "Truot";
        else if(diem <= 6)
            return "Trung binh";
        else if(diem == 7)
            return "Kha";
        else if(diem == 8)
            return "Gioi";
        else
            return "Xuat sac";
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + getTuoi() + " "
                + getDiem() + " " + getLoai();
    }
}

public class J05060 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        ArrayList<ThiSinh> a = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            String ten = sc.nextLine();
            String ns = sc.nextLine();
            double lt = Double.parseDouble(sc.nextLine());
            double th = Double.parseDouble(sc.nextLine());

            a.add(new ThiSinh(i, ten, ns, lt, th));
        }

        for(ThiSinh x : a) {
            System.out.println(x);
        }
    }
}