import java.util.*;

public class J05066 {
    static class NV {
        String name, role, id, sal;
        NV(String name, String role, String id, String sal) {
            this.name = name;
            this.role = role;
            this.id = id;
            this.sal = sal;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<NV> a = new ArrayList<>();
        int gd = 0, tp = 0, pp = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int sp = line.indexOf(' ');
            String code = line.substring(0, sp);
            String name = line.substring(sp + 1).trim();

            String role = code.substring(0, 2);
            String sal = code.substring(2, 4);
            String id = code.substring(4, 7);

            if (role.equals("GD")) {
                if (++gd > 1) role = "NV";
            } else if (role.equals("TP")) {
                if (++tp > 3) role = "NV";
            } else if (role.equals("PP")) {
                if (++pp > 3) role = "NV";
            }
            a.add(new NV(name, role, id, sal));
        }

        // Collections.sort là sort ổn định
        Collections.sort(a, (x, y) -> {
            int sx = Integer.parseInt(x.sal), sy = Integer.parseInt(y.sal);
            if (sx != sy) return sy - sx;                 // bậc lương giảm dần
            return Integer.parseInt(x.id) - Integer.parseInt(y.id); // số hiệu tăng dần
        });

        int m = Integer.parseInt(sc.nextLine().trim());
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            String key = sc.nextLine().trim().toLowerCase();
            for (NV e : a) {
                if (e.name.toLowerCase().contains(key)) {
                    sb.append(e.name).append(" ")
                      .append(e.role).append(" ")
                      .append(e.id).append(" ")
                      .append(e.sal).append("\n");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}