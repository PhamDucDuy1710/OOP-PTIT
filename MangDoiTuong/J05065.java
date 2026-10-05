import java.util.*;

class NV {
    private String ma, ten, cv, soHieu;
    private int bac;

    NV(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;

        cv = ma.substring(0, 2);
        bac = Integer.parseInt(ma.substring(2, 4));
        soHieu = ma.substring(4);
    }
    public String getCv() {
        return cv;
    }
    public int getBac() {
        return bac;
    }
    public String getSoHieu() {
        return soHieu;
    }
    public void chuyenNV() {
        cv = "NV";
    }
    @Override
    public String toString() {
        return ten + " " + cv + " " + soHieu + " "
                + String.format("%02d", bac);
    }
}

public class J05065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<NV> ds = new ArrayList<>();
        int gd = 0, tp = 0, pp = 0;
        for (int i = 0; i < n; i++) {
            String[] a = sc.nextLine().split(" ", 2);
            String ma = a[0];
            String ten = a[1];
            NV nv = new NV(ma, ten);
            String cv = ma.substring(0, 2);
            if (cv.equals("GD")) {
                gd++;
                if (gd > 1) {
                    nv.chuyenNV();
                }
            }
            else if (cv.equals("TP")) {
                tp++;
                if (tp > 3) {
                    nv.chuyenNV();
                }
            }
            else if (cv.equals("PP")) {
                pp++;
                if (pp > 3) {
                    nv.chuyenNV();
                }
            }
            ds.add(nv);
        }
        int m = Integer.parseInt(sc.nextLine());
        while (m-- > 0) {
            String query = sc.nextLine();
            ArrayList<NV> tmp = new ArrayList<>();
            for (NV nv : ds) {
                if (nv.getCv().equals(query)) {
                    tmp.add(nv);
                }
            }
            Collections.sort(tmp, new Comparator<NV>() {
                @Override
                public int compare(NV a, NV b) {
                    if (a.getBac() != b.getBac()) {
                        return b.getBac() - a.getBac();
                    }
                    return a.getSoHieu().compareTo(b.getSoHieu());
                }
            });
            for (NV nv : tmp) {
                System.out.println(nv);
            }
            System.out.println();
        }
    }
}