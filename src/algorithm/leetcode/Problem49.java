package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem49 {

    private static String genCharacCountString(String str) {
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 26; i++) {
            sb.append(count[i]);
            sb.append("#");
        }
        return sb.toString();
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ansMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String countStr = genCharacCountString(strs[i]);
            if (ansMap.containsKey(countStr)) {
                ansMap.get(countStr).add(strs[i]);
            } else {
                List<String> lst = new ArrayList<>();
                lst.add(strs[i]);
                ansMap.put(countStr, lst);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry: ansMap.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] data = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ans = groupAnagrams(data);
        System.out.println();
    }
}
