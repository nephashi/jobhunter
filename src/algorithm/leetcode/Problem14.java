package algorithm.leetcode;

public class Problem14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int index = 0;
        while (true) {
            try {
                char target = strs[0].charAt(index);
                boolean flag = true;
                for (String s : strs) {
                    if(s.charAt(index) != target) {
                        flag = false;
                        break;
                    }
                }
                if(!flag) break;
                index++;
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        return strs[0].substring(0, index);
    }

    public static void main(String[] args) {
        longestCommonPrefix(new String[]{"a","b"});
    }
}
