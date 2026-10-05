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

public class J05080 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        ArrayList<LopHP> ds = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String ten = sc.nextLine();
            String nhom = sc.nextLine();
            String gv = sc.nextLine();

            ds.add(new LopHP(ma, ten, nhom, gv));
        }

        int m = Integer.parseInt(sc.nextLine());

        while (m-- > 0) {
            String Ten = sc.nextLine();

            ArrayList<LopHP> tmp = new ArrayList<>();
            for (LopHP x : ds) {
                if (x.getGv().equals(Ten)) {
                    tmp.add(x);
                }
            }
            Collections.sort(tmp, new Comparator<LopHP>() {
                @Override
                public int compare(LopHP a, LopHP b) {
                    if(!a.getMa().equals(b.getMa())) return a.getMa().compareTo(b.getMa());
                    return a.getNhom().compareTo(b.getNhom());
                }
            });
            System.out.println(
                "Danh sach cho giang vien " + Ten + ":"
            );
            for (LopHP x : tmp) {
                System.out.println(x.getMa() + " " + x.getTen() + " " + x.getNhom());
            }
        }
    }
}