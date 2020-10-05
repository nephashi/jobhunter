package algorithm.leetcode;

public class Problem9 {
    public static boolean isPalindrome(int x) {
        if(x<0) return false;
        if(x%10 == 0 && x != 0) return  false;
        int tmp = 0;
        while(tmp < x) {
            int digit = x % 10;
            x /= 10;
            tmp = tmp * 10 + digit;
        }
        return x == tmp || x == tmp / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
