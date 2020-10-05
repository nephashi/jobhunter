package algorithm.leetcode;

import java.util.Stack;

public class Problem394 {

    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int j = 0;
                for (j = i; Character.isDigit(s.charAt(j)); j++);
                int repeat = Integer.valueOf(s.substring(i, j));
                int k = 0;
                Stack<Character> stack = new Stack<>();
                for (k = j; k < s.length(); k++) {
                    if (s.charAt(k) == '[')
                        stack.push('[');
                    if (s.charAt(k) == ']') {
                        stack.pop();
                        if (stack.empty())
                            break;
                    }
                }
                String sub = decodeString(s.substring(j + 1, k));
                for (int l = 0; l < repeat; l++)
                    sb.append(sub);
                i = k;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }

}
