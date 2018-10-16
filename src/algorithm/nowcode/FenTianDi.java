package algorithm.nowcode;

import java.util.Scanner;

// 能A这题的人我真的服气
public class FenTianDi {

    public static int getArea(int[][] sum, int x1, int y1, int x2, int y2) {
        return sum[x2][y2] - sum[x2][y1] - sum[x1][y2] + sum[x1][y1];
    }

    public static boolean isValid(int[][] sum, int mid, int n, int m) {
        for (int i = 1; i < m - 2; i++) {
            for (int j = i + 1; j < m - 1; j++) {
                for (int k = j + 1; k < m; k++) {
                    int pre = 0, count = 0;
                    for (int l = 1; l <= n; l++) {
                        int area1 = getArea(sum, pre, 0, l, i);
                        int area2 = getArea(sum, pre, i, l, j);
                        int area3 = getArea(sum, pre, j, l, k);
                        int area4 = getArea(sum, pre, k, l, m);
                        if (area1 >= mid && area2 >= mid && area3 >= mid && area4 >= mid) {
                            count++;
                            pre = l;
                        }
                    }
                    if (count >= 4)
                        return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] matrix = new int[n][m];
        int[][] sum = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = line.charAt(j) - '0';
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0)
                    sum[i][j] = 0;
                else
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1]
                            -sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int low = 0, high = sum[n][m], ans = 0, mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (isValid(sum, mid, n, m)) {
                low = mid + 1;
                ans = mid;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(ans);


    }
}
