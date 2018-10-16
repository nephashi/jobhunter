package algorithm.nowcode;

import java.util.*;
public class JiHe{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m + n; i ++){
            set.add(sc.nextInt());
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        for(int i = 0; i < list.size(); i ++)
            if (i == list.size() - 1)
                System.out.print(list.get(i));
            else
                System.out.print(list.get(i) + " ");
    }
}