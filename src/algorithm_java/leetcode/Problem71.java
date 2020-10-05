package algorithm.leetcode;

import java.util.Stack;

public class Problem71 {

    public static String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        sb.append(path.substring(0, 1));
        for (int i = 1; i < path.length(); i++) {
            if (!(path.charAt(i) == '/' && path.charAt(i) == path.charAt(i - 1))) {
                sb.append(path.substring(i, i + 1));
            }
        }
        path = sb.toString();
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : parts) {
            if (s.length() != 0) {
                if (s.equals("..")) {
                    if (stack.size() > 0) {
                        stack.pop();
                    }
                }
                else if (!s.equals(".")) {
                    stack.push(s);
                }
            }
        }
        if (stack.size() == 0)
            return "/";
        sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append("/");
            sb.append(stack.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }

}
