package algorithm.nowcode;

import java.util.*;

public class HunHeYanLiao {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            final int SUM = in.nextInt();
            int[] colors = new int[SUM];
            for (int i = 0; i < SUM; i++)
                colors[i] = in.nextInt();
            Arrays.sort(colors);
            System.out.println(minColor(colors));
        }
    }

    static int minColor(int[] colors) {
        int max = 1 << 30;
        int right = colors.length - 1;
        while (right >= 0 && colors[right] != 0) {
            while (max > colors[right])
                max >>= 1;
            while (right > 0 && colors[right - 1] >= max) {
                colors[right - 1] ^= colors[right];
                insertSort(colors, right - 1);
            }
            right--;
        }
        return right >= 0 ? colors.length - right - 1 : colors.length;
    }

    // 将一个数插入到有序数组中 ArrayList底层使用数组实现，不如直接使用数组
    // 使用LinkedList可以减少直接插入排序的移位操作
    static void insertSort(int[] nums, int index) {
        int temp = nums[index];
        if (temp <= nums[0]) {
            for (int i = index; i > 0; i--)
                nums[i] = nums[i - 1];
            nums[0] = temp;
            return;
        }
        for (int i = index - 1; i >= 0; i--) {
            if (temp > nums[i]) {
                for (int j = index; j > i + 1; j--)
                    nums[j] = nums[j - 1];
                nums[i + 1] = temp;
                return;
            }
        }
    }
}