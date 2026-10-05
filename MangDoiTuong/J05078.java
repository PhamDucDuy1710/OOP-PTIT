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

    public String getMaPhong() {
        return ma.substring(3);
    }

    private int getHeSo() {
        char nhom = ma.charAt(0);
        int nam = Integer.parseInt(ma.substring(1, 3));

        int[][] hs = {
            {10, 12, 14, 20},
            {10, 11, 13, 16},
            {9, 10, 12, 14},
            {8, 9, 11, 13}
        };

        int dong = nhom - 'A';

        if (nam <= 3)
            return hs[dong][0];
        else if (nam <= 8)
            return hs[dong][1];
        else if (nam <= 15)
            return hs[dong][2];
        else
            return hs[dong][3];
    }

    public long getLuong() {
        return luongNgay * ngayCong * getHeSo() * 1000;
    }

    public void in() {
        System.out.println(ma + " " + ten + " " + getLuong());
    }
}

public class J05078 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Map<String, PhongBan> dsPhong = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] a = sc.nextLine().split(" ", 2);
            dsPhong.put(a[0], new PhongBan(a[0], a[1]));
        }

        int m = Integer.parseInt(sc.nextLine());

        ArrayList<NhanVien> dsNV = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            long luongNgay = Long.parseLong(sc.nextLine());
            long ngayCong = Long.parseLong(sc.nextLine());

            dsNV.add(new NhanVien(ma, ten, luongNgay, ngayCong));
        }

        String maPhong = sc.nextLine();

        System.out.println("Bang luong phong " + dsPhong.get(maPhong).getTen() + ":");

        for (NhanVien nv : dsNV) {
            if (nv.getMaPhong().equals(maPhong)) {
                nv.in();
            }
        }
    }
}