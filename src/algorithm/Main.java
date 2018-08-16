package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().split(" ");
        String[] line2 = sc.nextLine().split(" ");
        int numTower = Integer.valueOf(line1[0]);
        if (numTower == 0) {
            return;
        }
        int maxOp = Integer.valueOf(line1[1]);
        int[] heights = new int[line2.length];
        for (int i = 0; i < line2.length; i++) {
            heights[i] = Integer.valueOf(line2[i]);
        }

        int minValue = Integer.MAX_VALUE;
        List<int[]> minOps = null;
        List<int[]> ops = new ArrayList<>();
        for (int i = 0; i < maxOp; i++) {
            int minHeight = Integer.MAX_VALUE;
            int minIdx= -1;
            int maxHeight = Integer.MIN_VALUE;
            int maxIdx = 1;
            for (int j = 0; j < heights.length; j++) {
                if (heights[j] > maxHeight) {
                    maxHeight = heights[j];
                    maxIdx = j;
                }
                if (heights[j] < minHeight) {
                    minHeight = heights[j];
                    minIdx = j;
                }
            }
            ops.add(new int[]{maxIdx + 1, minIdx + 1});
            heights[maxIdx]--;
            heights[minIdx]++;
            minHeight = Integer.MAX_VALUE;
            minIdx= -1;
            maxHeight = Integer.MIN_VALUE;
            maxIdx = -1;
            for (int j = 0; j < heights.length; j++) {
                if (heights[j] > maxHeight) {
                    maxHeight = heights[j];
                    maxIdx = j;
                }if (heights[j] < minHeight) {
                    minHeight = heights[j];
                    minIdx = j;
                }
            }
            if (maxHeight - minHeight < minValue) {
                minValue = maxHeight - minHeight;
                minOps = new ArrayList<>(ops);
            }
        }
        System.out.println("" + minValue + " " + minOps.size());
        for (int i = 0; i < minOps.size(); i++) {
            System.out.println("" + minOps.get(i)[0] + " " + minOps.get(i)[1]);
        }
    }
}
