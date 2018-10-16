package algorithm.nowcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QiuHe {

    public static void inner(int cur, int n, int curSum, int sum, List<Integer> curList) {
        for (int i = cur; i <= n; i++) {
            curList.add(i);
            if (curSum + i == sum) {
                for (int j = 0; j < curList.size() - 1; j++) {
                    System.out.print(curList.get(j));
                    System.out.print(" ");
                }
                System.out.println(curList.get(curList.size() - 1));
            } else if (curSum + i < sum)
                inner(i + 1, n, curSum + i, sum, curList);
            curList.remove(curList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        inner(1, n, 0, m, new ArrayList<>());
    }
}
