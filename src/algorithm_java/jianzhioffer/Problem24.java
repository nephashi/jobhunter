package algorithm.jianzhioffer;

import java.util.Arrays;

public class Problem24 {
    public  static boolean verifySequenceOfBST(int[] sequence) {
        int len = sequence.length;
        int i = 0;
        int root = sequence[len - 1];
        for(; i < len - 1; i++) {
            if (sequence[i] > root) {
                break;
            }
        }
        //i:右子树第一个位置
        for (int j = i; j < len; j++) {
            if (sequence[j] < root)
                return false;
        }
        boolean left = true, right = true;
        if (i > 0)
            left = verifySequenceOfBST(Arrays.copyOfRange(sequence, 0, i));
        if (i < len - 1)
            right = verifySequenceOfBST(Arrays.copyOfRange(sequence, i, len - 1));
        return left && right;
    }

    public static void main(String[] args) {
        System.out.println(verifySequenceOfBST(new int[] {7,4,6,5}));
    }
}
