import java.util.*;

class PhongBan {
    private String ma, ten;

    public PhongBan(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }
}

class NhanVien {
    private String ma, ten;
    private long luongNgay, ngayCong;

    public NhanVien(String ma, String ten, long luongNgay, long ngayCong) {
        this.ma = ma;
        this.ten = ten;
        this.luongNgay = luongNgay;
        this.ngayCong = ngayCong;
    }

    private int getHeSo() {
        char nhom = ma.charAt(0);
        int nam = Integer.parseInt(ma.substring(1, 3));

        int[][] heSo = {
            {10, 12, 14, 20},
            {10, 11, 13, 16},
            {9, 10, 12, 14},
            {8, 9, 11, 13}
        };

        int dong = nhom - 'A';

        if (nam <= 3) return heSo[dong][0];
        if (nam <= 8) return heSo[dong][1];
        if (nam <= 15) return heSo[dong][2];
        return heSo[dong][3];
    }

    public long getLuong() {
        return luongNgay * ngayCong * getHeSo() * 1000;
    }

    public String getMaPhong() {
        return ma.substring(3);
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + getLuong();
    }

    public void in(PhongBan pb) {
        System.out.println(ma + " " + ten + " " + pb.getTen() + " " + getLuong());
    }
}

public class J05077 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Map<String, PhongBan> dsPhong = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] a = sc.nextLine().split(" ", 2);
            dsPhong.put(a[0], new PhongBan(a[0], a[1]));
        }

        int m = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < m; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            long luongNgay = Long.parseLong(sc.nextLine());
            long ngayCong = Long.parseLong(sc.nextLine());

            NhanVien nv = new NhanVien(ma, ten, luongNgay, ngayCong);

            nv.in(dsPhong.get(nv.getMaPhong()));
        }
    }
}
