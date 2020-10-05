package algorithm.real;

import java.util.*;

public class TouTiao825Q1 {

    public static void traverse(Set<Integer>[] bMatrix, boolean[] used, int[] painted, int cur, int paint) {
        if (used[cur] == true)
            return;
        painted[cur] = paint;
        used[cur] = true;
        for (int e : bMatrix[cur]) {
            traverse(bMatrix, used, painted, e, paint);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Set<Integer>[] input = new HashSet[n];
        for (int i = 0; i < n; i++) {
            Set<Integer> l = new HashSet<>();
            String[] line = sc.nextLine().split(" ");
            for (int j = 0; j < line.length - 1; j++) {
                l.add(Integer.valueOf(line[j]) - 1);
            }
            input[i] = l;
        }

        Set<Integer>[] bMatrix = new Set[n];
        for (int i = 0; i < n; i++)
            bMatrix[i] = new HashSet<>(input[i]);

        for (int i = 0; i < n; i++) {
            Set<Integer> l = input[i];
            for (int e : l) {
                bMatrix[e].add(i);
            }
        }


        boolean[] used = new boolean[n];
        int[] painted = new int[n];

        for (int i = 0; i < n; i++) {
            if (used[i] == false)
                traverse(bMatrix, used, painted ,i, i);
        }

        int count = 0;
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < painted.length; i++) {
            map.put(painted[i], true);
        }
        System.out.println(map.size());
    }
}
