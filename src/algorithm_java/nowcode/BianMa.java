package algorithm.nowcode;

import java.util.Scanner;

public class BianMa {

    // 例如baca = ((25*25*25 + 25*25 + 25 + 1) * 1) + (1) + ((25 + 1) * 2 + 1) + 1
    public static void main(String[] args) {
        long a[] = new long[]{
                25 * 25 * 25 + 25 * 25 + 25 + 1,
                25 * 25 + 25 + 1,
                25 + 1,
                1
        };
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        long ans = 0;
        for (int i = 0; i < str.length(); i++) {
            ans += a[i] * (str.charAt(i) - 'a');
            // 第一位不能为空，但后面的可以为空
            // 例如ba前面有个b空，但a前面没有空
            if (i != 0)
                ans++;
        }
        System.out.println(ans);

    }

}
