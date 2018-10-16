package algorithm.nowcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CanGuan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] tables = new long[n];
        long[][] customer = new long[m][2];

        for (int i = 0; i < n; i++)
            tables[i] = sc.nextLong();

        for (int i = 0; i < m; i++) {
            customer[i][0] = sc.nextLong();
            customer[i][1] = sc.nextLong();
        }

        Arrays.sort(tables);
        Arrays.sort(customer, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if (o1[1] < o2[1])
                    return 1;
                else if (o1[1] > o2[1])
                    return -1;
                else if (o1[1] > o2[1])
                    return 1;
                else if (o1[1] < o2[1])
                    return -1;
                else
                    return 0;
            }
        });

        long total = 0;

        ArrayList<Long> tabless = new ArrayList<>();
        for (int i = 0; i < n; i++)
            tabless.add(tables[i]);

        for (int i = 0; i < m; i++) {
            long num = customer[i][0];
            int table = -1;
            if (num <= tabless.get(0)) {
                table = 0;
            } else if (num <= tabless.get(tabless.size() - 1)) {
                int l = 1, r = tabless.size() - 1;
                while (true) {
                    int mid = (l + r) / 2;
                    if (tabless.get(mid - 1) < num && tabless.get(mid) >= num) {
                        table = mid;
                        break;
                    } else if (tabless.get(mid - 1) >= num) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
            }
            if (table != -1) {
                total += customer[i][1];
                tabless.remove(table);
            }
            if (tabless.size() == 0)
                break;
        }

        System.out.println(total);
    }
}
