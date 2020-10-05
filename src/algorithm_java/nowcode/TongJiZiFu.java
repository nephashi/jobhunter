package algorithm.nowcode;

import java.util.HashMap;
import java.util.Scanner;

public class TongJiZiFu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < line.length(); i++) {
            if (Character.isAlphabetic(line.charAt(i))) {
                map.putIfAbsent(line.charAt(i), 0);
                map.put(line.charAt(i), map.get(line.charAt(i)) + 1);
                if (map.get(line.charAt(i)) == 3) {
                    System.out.println(line.charAt(i));
                    return;
                }
            }
        }
    }

}
