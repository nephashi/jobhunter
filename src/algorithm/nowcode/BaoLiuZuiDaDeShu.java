package algorithm.nowcode;

import java.util.Scanner;
import java.util.Stack;

public class BaoLiuZuiDaDeShu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int m = Integer.valueOf(sc.nextLine());
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < line[0].length(); i++) {
            if (i > 0) {
                while (!stack.isEmpty() && line[0].charAt(i) > stack.peek() && m > 0) {
                    stack.pop();
                    m--;
                }
            }
            stack.push(line[0].charAt(i));
        }
        while (m > 0) {
            stack.pop();
            m--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());
        System.out.println(sb.reverse().toString());
    }

}
