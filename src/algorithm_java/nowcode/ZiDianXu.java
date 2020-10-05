package algorithm.nowcode;

import java.util.Scanner;

public class ZiDianXu {

    public static long getCountInBranch(long p, long n) {
        long sum = 1; //p节点
        // p的下层有10个数
        // n 需要小于当前 节点子节点最大值，也就是最右边节点
        for(long level = 10; n >= level * p; level *= 10)
        {
            //n 大于最右节点
            if(n >= level * p + level - 1)
            {
                sum += level;  //当前 节点子节点个数为level
            }else
            {
                // n 大于最左节点，n小于最右节点
                sum += (n - level * p + 1);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();

        long result = 1;

        while (true) {
            long p = getCountInBranch(result, n);
            if (p >= m) {
                m -= 1;
                if (m == 0)
                    break;
                result *= 10;
            } else {
                m -= p;
                result++;
            }
        }
        System.out.println(result);
    }

}
