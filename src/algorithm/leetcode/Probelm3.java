package algorithm.leetcode;

import java.util.HashMap;

public class Probelm3 {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxlen = 0;
        int len = 0;
        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == null) {
                len++;
                map.put(s.charAt(i), i);
            } else {
                int repeateIndex = map.get(s.charAt(i));
                for (int k = i - len; k <= repeateIndex; k++) {
                    map.put(s.charAt(k), null);
                }
                if(len > maxlen) maxlen = len;
                len = i - repeateIndex;
                map.put(s.charAt(i), i);
            }
        }
        if(len > maxlen) {
            maxlen = len;
        }
        return maxlen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

}
