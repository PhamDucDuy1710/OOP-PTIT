import java.util.*;

class HS {
    private String ma, ten, xepLoai;
    private double diem;
    private int hang;

    HS(int ma, String ten, double diem) {
        this.ma = String.format("HS%02d", ma);
        this.ten = ten;
        this.diem = diem;

        if (diem < 5) {
            xepLoai = "Yeu";
        } else if (diem < 7) {
            xepLoai = "Trung Binh";
        } else if (diem < 9) {
            xepLoai = "Kha";
        } else {
            xepLoai = "Gioi";
        }
    }

    public double getDiem() {
        return diem;
    }

    public int getHang() {
        return hang;
    }

    public void setHang(int hang) {
        this.hang = hang;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + diem + " " + xepLoai + " " + hang;
    }
}

public class J05054 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        ArrayList<HS> a = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String ten = sc.nextLine();
            double diem = Double.parseDouble(sc.nextLine());

            a.add(new HS(i, ten, diem));
        }
        ArrayList<HS> b = new ArrayList<>(a);
        b.sort((x, y) -> Double.compare(y.getDiem(), x.getDiem()));
        for (int i = 0; i < n; i++) {
            if (i == 0 || b.get(i).getDiem() != b.get(i - 1).getDiem()) { b
                b.get(i).setHang(i + 1);
            } else {
                b.get(i).setHang(b.get(i - 1).getHang());
            }
        }
        for (HS x : a) {
            System.out.println(x);
        }
    }
}