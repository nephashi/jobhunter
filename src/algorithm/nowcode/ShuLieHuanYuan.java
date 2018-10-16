package algorithm.nowcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShuLieHuanYuan {

    public static void innerPermutation(List<Integer> absent, boolean[] used,
                                        List<Integer> curList, List<List<Integer>> permutation) {
        if (curList.size() >= absent.size()) {
            permutation.add(new ArrayList<Integer>(curList));
            return;
        }
        for (int i = 0; i < absent.size(); i++) {
            if (!used[i]) {
                curList.add(absent.get(i));
                used[i] = true;
                innerPermutation(absent, used, curList, permutation);
                curList.remove(curList.size() - 1);
                used[i] = false;
            }
        }


    }

    public static void permutation(List<Integer> absent, List<List<Integer>> permutation) {
        boolean[] used = new boolean[absent.size()];
        innerPermutation(absent, used, new ArrayList<>(), permutation);
    }

    public static int numPair(int[] candidate) {
        int count = 0;
        for (int i = 0; i < candidate.length; i++) {
            for (int j = i + 1; j < candidate.length; j++) {
                if (candidate[i] < candidate[j])
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] array = new int[n];
        boolean[] b = new boolean[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
            if (array[i] != 0)
                b[array[i] - 1] = true;
        }

        List<Integer> absent = new ArrayList<>();
        for (int i = 0; i < b.length; i++)
            if (!b[i])
                absent.add(i + 1);

        List<List<Integer>> permu = new ArrayList<>();

        permutation(absent, permu);

        int count = 0;
        for (int i = 0; i < permu.size(); i++) {
            int[] candidate = new int[n];
            int t = 0;
            for (int j = 0; j < n; j++) {
                if (array[j] != 0)
                    candidate[j] = array[j];
                else {
                    candidate[j] = permu.get(i).get(t);
                    t++;
                }
            }
            if (numPair(candidate) == k) {
                count++;
            }
        }
        System.out.println(count);
    }

}