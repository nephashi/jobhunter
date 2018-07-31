package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem95 {

    public static List<TreeNode> inner(int[] nums) {
        List<TreeNode> rst = new ArrayList<>();
        if (nums.length == 0) {
            rst.add(null);
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                int[] leftNums = new int[i];
                for (int j = 0; j < i; j++) {
                    leftNums[j] = nums[j];
                }
                int[] rightNums = new int[nums.length - i - 1];
                for (int j = i + 1; j < nums.length; j++) {
                    rightNums[j - i - 1] = nums[j];
                }
                List<TreeNode> leftRoots = inner(leftNums);
                List<TreeNode> rightRoots = inner(rightNums);
                for (int j = 0; j < leftRoots.size(); j++) {
                    for (int k = 0; k < rightRoots.size(); k++) {
                        TreeNode root = new TreeNode(nums[i]);
                        root.left = leftRoots.get(j);
                        root.right = rightRoots.get(k);
                        rst.add(root);
                    }
                }
            }
        }
        return rst;
    }

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        return inner(nums);
    }

    public static void main(String[] args) {
       List<TreeNode> roots = generateTrees(5);
       System.out.println();
    }

}
