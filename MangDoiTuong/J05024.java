import java.util.*;

class SinhVien {
    private String ma, ten, lop, mail;

    public SinhVien(String ma, String ten, String lop, String mail) {
        this.ma = ma;
        this.ten = ten;
        this.lop = lop;
        this.mail = mail;
    }

    public String getLop() {
        return lop;
    }

    public String getMa() {
        return ma;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + lop + " " + mail;
    }
}

public class J05024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine().trim());
        ArrayList<SinhVien> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine().trim();
            String ten = sc.nextLine().trim();
            String lop = sc.nextLine().trim();
            String mail = sc.nextLine().trim();
            a.add(new SinhVien(ma, ten, lop, mail));
        }

        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            String s = sc.nextLine().trim();
            String nganhUpper = s.toUpperCase();
            String maNganh = "";
            if (nganhUpper.equals("KE TOAN")) {
                maNganh = "DCKT";
            } else if (nganhUpper.equals("CONG NGHE THONG TIN")) {
                maNganh = "DCCN";
            } else if (nganhUpper.equals("AN TOAN THONG TIN")) {
                maNganh = "DCAT";
            } else if (nganhUpper.equals("VIEN THONG")) {
                maNganh = "DCVT";
            } else if (nganhUpper.equals("DIEN TU")) {
                maNganh = "DCDT";
            }

            System.out.println("DANH SACH SINH VIEN NGANH " + nganhUpper + ":");
            
            for (SinhVien sv : a) {
                if (sv.getMa().substring(3, 7).equals(maNganh)) {
                    if ((maNganh.equals("DCCN") || maNganh.equals("DCAT")) && sv.getLop().startsWith("E")) {
                        continue;
                    }
                    System.out.println(sv);
                }
            }
        }
        sc.close();
    }
}