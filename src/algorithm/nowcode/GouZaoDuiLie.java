package algorithm.nowcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GouZaoDuiLie {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = n; j >= 1; j--) {
                list.add(0, j);
                int last = list.remove(list.size() - 1);
                list.add(0, last);
            }
            for (int j = 0; j < list.size() - 1; j++) {
                System.out.print(list.get(j));
                System.out.print(" ");
            }
            System.out.println(list.get(list.size() - 1));
        }
    }

}
