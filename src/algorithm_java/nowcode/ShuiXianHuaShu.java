package algorithm.nowcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShuiXianHuaShu {

    public static boolean isTri(int target) {
        List<Integer> tmp = new ArrayList<>();
        int p = target;
        while (p != 0) {
            tmp.add(p % 10);
            p /= 10;
        }
        int sum = 0;
        for (int i = 0; i < tmp.size(); i++) {
            sum += Math.pow(tmp.get(i), 3);
        }
        return sum == target;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<int[]> input = new ArrayList<>();
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            input.add(new int[]{a, b});
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            List<Integer> r = new ArrayList<>();
            for (int j = input.get(i)[0]; j <= input.get(i)[1]; j++) {
                if (isTri(j))
                    r.add(j);
            }
            ans.add(r);
        }

        for (int i = 0; i < ans.size(); i++) {
            if (ans.get(i).size() == 0) {
                System.out.println("no");
            } else {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < ans.get(i).size(); j++) {
                    sb.append(ans.get(i).get(j));
                    if (j != ans.get(i).size() - 1)
                        sb.append(" ");
                }
                System.out.println(sb.toString());
            }

        }
    }

}
