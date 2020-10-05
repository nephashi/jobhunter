package algorithm.nowcode;

import java.util.*;

public class JiuDianJiaGe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int start, end, price;
        int minDay = 0;
        int maxDay = 0;
        int[] money = new int[10000];
        while(input.hasNext()) {
            start = input.nextInt();
            end = input.nextInt();
            price = input.nextInt();
            for(int i = start; i <= end; i++) {
                money[i] = price;
            }
            if(minDay > start)
                minDay = start;
            if(maxDay < end)
                maxDay = end;
        }
        int min_id;
        for(int i = minDay; i <= maxDay; i++) {
            min_id = i;
            if(money[i] == 0)
                continue;
            while(money[i] == money[i + 1] && i + 1 <= maxDay)
                i++;
            System.out.print("[" +  min_id + "," + i + "," + money[i] + "]");
            if(i != maxDay)
                System.out.print(",");
        }
    }
}