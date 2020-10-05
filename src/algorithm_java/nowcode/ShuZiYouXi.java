package algorithm.nowcode;

import java.util.Arrays;
import java.util.Scanner;

public class ShuZiYouXi {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
            {
                a[i] = in.nextInt();
            }
            //调用Arrays的sort方法可直接对数组进行排序
            Arrays.sort(a);
            int base = 0;
            for (int i = 0; i < n; i++)
            {
                if (a[i]>base+1)
                {
                    break;
                }
                base=base+a[i];
            }
            System.out.println(base+1);
        }

    }
}
