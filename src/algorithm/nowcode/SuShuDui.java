package algorithm.nowcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SuShuDui {

    public static int isPrime(int n) {    //返回1表示判断为质数，0为非质数，在此没有进行输入异常检测
        double n_sqrt;
        if (n == 1) return 0;
        if (n == 2 || n == 3) return 1;
        if (n % 6 != 1 && n % 6 != 5) return 0;
        n_sqrt = Math.floor(Math.sqrt((float) n));
        for (int i = 5; i <= n_sqrt; i += 6) {
            if (n % (i) == 0 | n % (i + 2) == 0) return 0;
        }
        return 1;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++)
            if (isPrime(i) == 1)
                list.add(i);

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            hashMap.put(list.get(i), 1);
            if (hashMap.containsKey(n - list.get(i))) {
                count++;
            }
        }
        System.out.println(count);

    }

}
