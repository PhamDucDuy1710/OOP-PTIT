import java.util.*;

public class J05073 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String ma = sc.next();
            double donGia = sc.nextDouble();
            double soLuong = sc.nextDouble();
            double thue = 0;
            double vanChuyen = 0;
            switch (ma.charAt(0)) {
                case 'T':
                    thue = 0.29;
                    vanChuyen = 0.04;
                    break;

                case 'C':
                    thue = 0.10;
                    vanChuyen = 0.03;
                    break;

                case 'D':
                    thue = 0.08;
                    vanChuyen = 0.025;
                    break;

                case 'M':
                    thue = 0.02;
                    vanChuyen = 0.005;
                    break;
            }
            if (ma.charAt(ma.length() - 1) == 'C') {
                thue *= 0.95;
            }
            double tienHang = donGia * soLuong;
            double tongChiPhi = tienHang
                    + tienHang * thue
                    + tienHang * vanChuyen;
            double giaBan = tongChiPhi * 1.20 / soLuong;
            System.out.printf("%s %.2f%n", ma, giaBan);
        }
    }
}