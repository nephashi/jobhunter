package algorithm.nowcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Node {
    public int x;
    public int y;
    public int p;
    public Node prev;

    public Node(int x, int y, int p, Node prev) {
        this.x = x;
        this.y = y;
        this.p = p;
        this.prev = prev;
    }
}

public class DiXiaMiGong {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();

        int[][] matrix = new int[n][m];
        boolean[][] arrived = new boolean[n][m];
        int[][] direction = {
                {-1, 0, 3},
                {1, 0, 0},
                {0, -1, 1},
                {0, 1, 1}
        };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, p, null));
        arrived[0][0] = true;
        Node node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.x == 0 && node.y == m - 1)
                break;
            for (int i = 0; i < direction.length; i++) {
                int nx = node.x + direction[i][0];
                int ny = node.y + direction[i][1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || matrix[nx][ny] == 0 || arrived[nx][ny] == true)
                    continue;
                queue.offer(new Node(nx, ny, node.p - direction[i][2], node));
                arrived[nx][ny] = true;
            }
        }

        if (node.p < 0) {
            System.out.println("Can not escape!");
        } else {
            Stack<Node> stack = new Stack<>();
            while (node != null) {
                stack.push(node);
                node = node.prev;
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                Node nd = stack.pop();
                sb.append("[" + nd.x + "," + nd.y + "]");
                if (!stack.isEmpty())
                    sb.append(",");
            }
            System.out.println(sb.toString());
        }


    }

}
