import java.util.*;

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

public class J05008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Point[] a = new Point[n];
            for (int i = 0; i < n; i++) {
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                a[i] = new Point(x, y);
            }

            double sum = 0;
            for (int i = 0; i < n; i++) {
                Point p1 = a[i];
                Point p2 = a[(i + 1) % n];
                sum += (p1.getX() * p2.getY() - p2.getX() * p1.getY());
            }

            double area = Math.abs(sum) / 2.0;
            System.out.printf("%.3f\n", area);
        }
        sc.close();
    }
}