package algorithm.nowcode;

import java.util.Scanner;

public class XiPai {

    public static void shuffle(int[] cards) {
        int[] c = new int[cards.length];
        for (int i = 0; i < cards.length / 2; i++) {
            c[2 * i] = cards[i];
            c[2 * i + 1] = cards[cards.length / 2 + i];
        }
        for (int i = 0; i < cards.length; i++)
            cards[i] = c[i];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] cards = new int[2 * n];
            for (int j = 0; j < 2 * n; j++)
                cards[j] = sc.nextInt();
            for (int j = 0; j < k; j++)
                shuffle(cards);
            for (int j = 0; j < cards.length; j++) {
                System.out.print(cards[j]);
                if (j != cards.length - 1)
                    System.out.print(" ");
            }
        }
    }

}
