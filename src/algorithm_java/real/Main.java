package algorithm.real;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        sc.nextLine();
        String[] line = sc.nextLine().split(" ");
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < line.length; i++) {
            list.add(Integer.valueOf(line[i]));
        }

        int[] water = new int[n + 1];

        for (int i = 0; i < m; i++) {
            line = sc.nextLine().split(" ");
            List<Integer> order = new ArrayList<>();
            for (int j = 0; j < line.length; j++) {
                order.add(Integer.valueOf(line[j]));
            }

            if (order.get(0) == 1)
                System.out.println(water[order.get(1)]);
            else if (order.get(0) == 2) {
                int p = order.get(1);
                int q = order.get(2);
                while (true) {
                    if (p > n)
                        break;
                    if (list.get(p) - water[p] >= q) {
                        water[p] += q;
                        break;
                    } else {
                        water[p] = list.get(p);
                        q -= list.get(p) - water[p];
                        p += 1;
                    }
                }
            }
        }
    }

}
