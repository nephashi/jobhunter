package algorithm.nowcode;

import java.util.*;

public class JinZhiZhuanHuan {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(10, "A");
        map.put(11, "B");
        map.put(12, "C");
        map.put(13, "D");
        map.put(14, "E");
        map.put(15, "F");

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        boolean negative = false;

        if (m < 0) {
            negative = true;
            m = m * -1;
        }

        List<Integer> w = new ArrayList<>();
        while (m != 0) {
            w.add(m % n);
            m /= n;
        }
        if (negative)
            System.out.print("-");
        for (int i = w.size() - 1; i >= 0; i--) {
            if (w.get(i) < 10)
                System.out.print(w.get(i));
            else
                System.out.print(map.get(w.get(i)));
        }
    }

}
