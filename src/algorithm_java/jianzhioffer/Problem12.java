package algorithm.jianzhioffer;

public class Problem12 {

    public static void print1ToMaxOfNDigit(int n) {
        if(n < 1) return;
        char[] number = new char[n];
        for(int i = 0; i < number.length; i++) {
            number[i] = '0';
        }
        while (increment(number)) {
            printNumber(number);
        }

    }

    public static void printNumber(char[] number) {
        boolean print = false;
        for(int i = 0; i < number.length; i++) {
            if(number[i] != '0' && print == false) print = true;
            if(print) {
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }

    public static boolean increment(char[] number) {
        int nTakeOver = 0;
        for(int i = number.length - 1; i >= 0; i--) {
            int d = number[i] - '0';
            if(i == number.length - 1) d++;
            d += nTakeOver;
            if(d >=10) {
                if(i == 0) {
                    return false;
                } else {
                    nTakeOver = 1;
                    number[i] = (char)('0' + d - 10);
                }
            } else {
                number[i] = (char)('0' + d);
                break;
            }
        }
        return true;
    }

    public static void print1ToMaxRecursively(int n) {
        char[] number = new char[n];
        printCore(number, n, 0);
    }

    public static void printCore(char[] number, int n, int index) {
        if(index == n) {
            boolean flag = false;
            for(int i = 0; i < n; i++) {
                if(number[i] != '0' && flag == false) flag = true;
                if(flag == true) {
                    System.out.print(number[i]);
                }
            }
            System.out.println();
            return;
        }
        for (int i = 0; i <= 9; i++) {
            number[index] = (char)('0' + i);
            printCore(number, n, index+1);
        }
    }

    public static void main(String[] args) {
        print1ToMaxOfNDigit(3);
    }
}
