package algorithm.leetcode;

public class Problem58 {

    public static int lengthOfLastWord(String s) {
        String[] splits = s.split(" ");
        if (splits.length == 0)
            return 0;
        else
            return splits[splits.length - 1].length();
    }

    public static void main(String[] args) {
        lengthOfLastWord(" ");
    }

}
