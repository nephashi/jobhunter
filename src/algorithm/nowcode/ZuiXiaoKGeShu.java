package algorithm.nowcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ZuiXiaoKGeShu {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            list.add(sc.nextInt());
        }
        int k = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        Collections.sort(list);
        for (int i = 0; i < k - 1; i++) {
            System.out.print(list.get(i));
            System.out.print(" ");
        }
        System.out.print(list.get(k - 1));

    }

}
