import java.util.*;

class LopHP {
    private String ma, ten, nhom, gv;

    LopHP(String ma, String ten, String nhom, String gv) {
        this.ma = ma;
        this.ten = ten;
        this.nhom = nhom;
        this.gv = gv;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getNhom() {
        return nhom;
    }

    public String getGv() {
        return gv;
    }
}

public class J05079 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        ArrayList<LopHP> ds = new ArrayList<>();

        // Nhập danh sách lớp học phần
        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            String nhom = sc.nextLine();
            String gv = sc.nextLine();

            ds.add(new LopHP(ma, ten, nhom, gv));
        }

        int m = Integer.parseInt(sc.nextLine());

        while (m-- > 0) {
            String maMon = sc.nextLine();

            ArrayList<LopHP> tmp = new ArrayList<>();

            // Lọc các lớp thuộc môn cần tìm
            for (LopHP x : ds) {
                if (x.getMa().equals(maMon)) {
                    tmp.add(x);
                }
            }

            // Sắp xếp nhóm tăng dần
            Collections.sort(tmp, new Comparator<LopHP>() {
                @Override
                public int compare(LopHP a, LopHP b) {
                    return a.getNhom().compareTo(b.getNhom());
                }
            });

            // In tên môn
            System.out.println(
                "Danh sach nhom lop mon " + tmp.get(0).getTen() + ":"
            );

            // In nhóm + giảng viên
            for (LopHP x : tmp) {
                System.out.println(x.getNhom() + " " + x.getGv());
            }
        }
    }
}
