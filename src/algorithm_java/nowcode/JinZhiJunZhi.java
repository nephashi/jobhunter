package algorithm.nowcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JinZhiJunZhi {

    public static long maxGongYueShu(long num1, long num2) {
        if(num1<num2){
            long temp=num1;
            num1=num2;
            num2=temp;
        }

        long remainder = num1%num2;
        long n1=num1,n2=num2;

        while(remainder!=0){
            num1=num2;
            num2=remainder;
            remainder=num1%num2;
        }
        return num2;
    }

    public static List<Integer> transfer(int m, int n) {
        List<Integer> ans = new ArrayList<>();
        while (m != 0) {
            ans.add(m % n);
            m /= n;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long sum = 0;
        long count = 0;
        int n = sc.nextInt();
        for (int i = 2; i < n; i++) {
            List<Integer> list = transfer(n, i);
            for (int e : list)
                sum += e;
            count++;
        }

        while (true) {
            long y = maxGongYueShu(sum, count);
            if (y == 1)
                break;
            sum /= y;
            count /= y;
        }
        System.out.println(sum + "/" + count);


    }

}
