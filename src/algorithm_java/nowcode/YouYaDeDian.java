package algorithm.nowcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class YouYaDeDian {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<int[]> lst = new ArrayList<>();
        for (int i = 0; i <= Math.sqrt(n); i++) {
            if (Math.pow((int)Math.sqrt(n - i * i), 2) == (n - i * i)) {
                lst.add(new int[]{i, (int)Math.sqrt(n - i * i)});
            }
        }
        int sum = 0;
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i)[0] == 0 || lst.get(i)[1] == 0)
                sum += 2;
            else
                sum += 4;
        }
        System.out.println(sum);
    }

}
