package algorithm.nowcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TouTiaoXiaoZhao {

    public static int findIdx(List<Integer> nums, int startIdx) {
        if (startIdx == nums.size() - 1) return -1;
        if (nums.get(startIdx + 1) - nums.get(startIdx) <= 10) {
            return 1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++)
            nums.add(sc.nextInt());

        Collections.sort(nums);

        int more = 0;

        for (int i = 0; i < nums.size();) {
            boolean find = false;
            int hard2Idx = findIdx(nums, i);
            if (hard2Idx != -1) {
                int hard3Idx = findIdx(nums, hard2Idx);
                if (hard3Idx != -1) {
                    find = true;
                    nums.remove(hard3Idx);
                    nums.remove(hard2Idx);
                    nums.remove(i);
                }
            }
            if (!find)
                i++;
        }
        for (int i = 0; i < nums.size();) {
            boolean find = false;
            int hard1 = nums.get(i);
            int hard2Idx = findIdx(nums, i);
            if (hard2Idx != -1) {
                find = true;
                nums.remove(hard2Idx);
                nums.remove(i);
            }
            if (!find) {
                i++;
            } else {
                more++;
            }
        }
        more += (nums.size() * 2);
        System.out.println(more);
    }
}
