import java.util.Scanner;

class KH {
    private String ma, loai;
    private int csc, csm;

    public KH(int stt, String loai, int csc, int csm) {
        this.ma = String.format("KH%02d", stt);
        this.loai = loai;
        this.csc = csc;
        this.csm = csm;
    }

    public int getHs() {
        switch (loai) {
            case "KD": return 3;
            case "NN": return 5;
            case "TT": return 4;
            case "CN": return 2;
            default:   return 0;
        }
    }

    public long getTt() {
        return (long)(csm - csc) * getHs() * 550;
    }

    public long getPt() {
        int x = csm - csc;
        if (x < 50) {
            return 0;
        } else if (x <= 100) {
            return Math.round((double) getTt() * 35 / 100);
        } else {
            return getTt();
        }
    }

    public long getTong() {
        return getTt() + getPt();
    }

    @Override
    public String toString() {
        return ma + " " + getHs() + " " + getTt() + " " + getPt() + " " + getTong();
    }
}

public class J05050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            String loai = sc.next();
            int csc = sc.nextInt();
            int csm = sc.nextInt();

            KH kh = new KH(i, loai, csc, csm);
            System.out.println(kh);
        }
        sc.close();
    }
}