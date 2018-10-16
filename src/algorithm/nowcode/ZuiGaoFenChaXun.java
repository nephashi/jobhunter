package algorithm.nowcode;

import java.util.HashMap;
import java.util.Scanner;

public class ZuiGaoFenChaXun {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<Integer, Student> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(i + 1, new Student(i + 1, sc.nextInt()));
        sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String[] line = sc.nextLine().split(" ");
            if (line[0].equals("Q")) {
                int start = Integer.valueOf(line[1]);
                int end = Integer.valueOf(line[2]);
                if (start > end) {
                    int tmp = start;
                    start = end;
                    end = tmp;
                }
                int max = 0;
                for (int j = start; j <= end; j++) {
                    if (map.get(j).grade > max)
                        max = map.get(j).grade;
                }
                sb.append(max + "\n");
            }
            if (line[0].equals("U")) {
                map.get(Integer.valueOf(line[1])).grade = Integer.valueOf(line[2]);
            }
        }
        System.out.println(sb.toString());
    }

}

class Student {
    public int id;
    public int grade;
    Student(int id, int grade) {
        this.id = id;
        this.grade = grade;
    }
}
