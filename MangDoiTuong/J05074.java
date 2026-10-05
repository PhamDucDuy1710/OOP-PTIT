import java.util.*;

class SV {
    private String ma, ten, lop;
    private int diem;

    SV(String ma, String ten, String lop) {
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getLop() {
        return lop;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public int getDiem() {
        return diem;
    }
}

public class J05074 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        ArrayList<SV> a = new ArrayList<>();

        // Nhập sinh viên
        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            String lop = sc.nextLine();

            a.add(new SV(ma, ten, lop));
        }

        // Nhập điểm danh
        for (int i = 0; i < n; i++) {
            String m = sc.next();
            String dd = sc.next();

            int d = 10;

            for (char c : dd.toCharArray()) {
                if (c == 'x') {
                    continue;
                } else if (c == 'm') {
                    d -= 1;
                } else {
                    d -= 2;
                }
            }

            if (d < 0) {
                d = 0;
            }

            // Tìm sinh viên và lưu điểm
            for (SV sv : a) {
                if (sv.getMa().equals(m)) {
                    sv.setDiem(d);
                    break;
                }
            }
        }

        // In theo thứ tự sinh viên ban đầu
        for (SV sv : a) {
            System.out.print(
                sv.getMa() + " " +
                sv.getTen() + " " +
                sv.getLop() + " " +
                sv.getDiem()
            );

            if (sv.getDiem() == 0) {
                System.out.println(" KDDK");
            } else {
                System.out.println();
            }
        }
    }
}