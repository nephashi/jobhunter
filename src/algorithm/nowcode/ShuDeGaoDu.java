package algorithm.nowcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ShuDeGaoDu {

    static int maxDepth = 0;

    public static void maxSearch(HashMap<Integer, List<Integer>> hashMap, int curNode, int curDepth) {
        if (hashMap.get(curNode).size() == 0) {
            if (curDepth > maxDepth) {
                maxDepth = curDepth;
            }
        } else {
            for (int i = 0; i < hashMap.get(curNode).size(); i++) {
                maxSearch(hashMap, hashMap.get(curNode).get(i), curDepth + 1);
            }
        }
    }

    public static void main(String[] args) {
        maxDepth = 0;
        Scanner sc = new Scanner(System.in);
        int numNode = sc.nextInt();
        sc.nextLine();
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < numNode; i++) {
            hashMap.put(i, new ArrayList<>());
        }
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] splits = line.split(" ");
            if (hashMap.get(Integer.valueOf(splits[0])).size() < 2)
                hashMap.get(Integer.valueOf(splits[0])).add(Integer.valueOf(splits[1]));
        }
        maxSearch(hashMap, 0, 1);
        System.out.println(maxDepth);
    }

}
