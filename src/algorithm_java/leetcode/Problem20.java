package algorithm.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Problem20 {

    private static int search(char target, char[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target)
                return i;
        }
        return -1;
    }

    public static boolean isValid(String s) {

        char[] bracket = {'(', '{', '['};
        char[] antiBracket = {')', '}', ']'};

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (search(s.charAt(i), bracket) != -1) {
                stack.push(s.charAt(i));
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                char chr = stack.pop();
                int idx = search(chr, bracket);
                if (s.charAt(i) != antiBracket[idx])
                    return false;
            }
        }
        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }

    }


    public static void main(String[] args) {
        String s = "{}{}[()]";
        boolean b = isValid(s);
        System.out.println();
    }
}
