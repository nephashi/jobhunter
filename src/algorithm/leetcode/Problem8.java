package algorithm.leetcode;

public class Problem8 {
    public static int myAtoi(String str) {
        if (str.length() == 0) return 0;
        int index = 0;
        while (str.charAt(index) == ' ' && index < str.length()) {
            index++;
        }
        int sign = 1;
        if (str.charAt(index) == '-' || str.charAt(index) == '+') {
            sign = str.charAt(index) == '-' ? -1 : 1;
            index++;
        }
        int value = 0;
        for (; index < str.length(); index++) {
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;
            if(Integer.MAX_VALUE / 10 < value || (Integer.MAX_VALUE / 10 == value && Integer.MAX_VALUE % 10 < digit))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            value = value * 10 + (str.charAt(index) - '0');
        }
        return sign * value;
    }

    public static void main(String[] args) {
        String str ="     +004500";
        System.out.println(myAtoi(str));
    }
}
