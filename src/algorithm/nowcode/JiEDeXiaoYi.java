package algorithm.nowcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JiEDeXiaoYi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long input = sc.nextLong();

        Queue<Long> queue = new LinkedList<>();
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(input, 0);

        queue.offer(input);
        while (!queue.isEmpty()) {
            long cur = queue.poll();
            long a = (4 * cur + 3) % 1000000007;
            long b = (8 * cur + 7) % 1000000007;
            if (a == 0 || b == 0) {
                System.out.println(map.get(cur) + 1);
                return;
            } else {
                if (!map.containsKey(a) && map.get(cur) < 100000) {
                    map.put(a, map.get(cur) + 1);
                    queue.offer(a);
                }
                if (!map.containsKey(b) && map.get(cur) < 100000) {
                    map.put(b, map.get(cur) + 1);
                    queue.offer(b);
                }
            }
        }
        System.out.println(-1);
    }

}
