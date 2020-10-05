package algorithm.nowcode;

import java.util.Scanner;

public class FenPingGuo {

    static int maxIndex(int[] array) {
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    static int minIndex(int[] array) {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                minIdx = i;
            }
        }
        return minIdx;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += array[i];
        if (sum % n != 0) {
            System.out.println(-1);
            return;
        }
        int mean = sum / n;

        int count = 0;
        while (true) {
            int maxIdx = maxIndex(array);
            int minIdx = minIndex(array);
            if (array[maxIdx] - mean == 1 && mean - array[minIdx] == 1) {
                System.out.println(-1);
                return;
            }
            if (array[maxIdx] == array[minIdx]) {
                System.out.println(count);
                return;
            }
            array[maxIdx] -= 2;
            array[minIdx] += 2;
            count++;
        }
    }

}
