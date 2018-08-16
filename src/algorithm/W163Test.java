package algorithm;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class W163Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.valueOf(sc.nextLine());
        List<Integer> clock = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            String[] splits = line.split(" ");
            clock.add(Integer.valueOf(splits[0]) * 60 + Integer.valueOf(splits[1]));
        }
        int way = Integer.valueOf(sc.nextLine());
        String[] splits = sc.nextLine().split(" ");
        int school = Integer.valueOf(splits[0]) * 60 + Integer.valueOf(splits[1]);

        int latest = Integer.MIN_VALUE;
        for (int i = 0; i < clock.size(); i++) {
            if (clock.get(i) + way <= school && clock.get(i) > latest)
                latest = clock.get(i);
        }
        String ans = "" + latest / 60 + " " + latest % 60;
        System.out.println(ans);
    }
}
