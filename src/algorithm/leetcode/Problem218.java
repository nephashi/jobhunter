package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Node {
    public int id, x, y;
    String type;
    public Node(int id, int x, int y, String type) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.type = type;
    }
}

public class Problem218 {

    // false: a > b
    public static boolean comp(Node a, Node b) {
        if (a.x != b.x)
            return a.x < b.x;
        else if (a.type.equals("LEFT") && b.type.equals("LEFT")) {
            return a.y > b.y;
        }
        else if (a.type.equals("RIGHT") && b.type.equals("RIGHT")) {
            return a.y < b.y;
        }
        else
            return a.type == "LEFT";
    }

    public static int insertByOrder(List<Node> lst, Node n) {
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i).y < n.y) {
                lst.add(i, n);
                return i;
            }
        }
        lst.add(n);
        return lst.size() - 1;
    }

    public static Node deleteById(List<Node> lst, int id) {
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i).id == id && (i == lst.size() - 1 || lst.get(i + 1).id != id)) {
                return lst.remove(i);
            }
        }
        return null;
    }


    public static List<int[]> getSkyline(int[][] buildings) {
        List<Node> heights = new ArrayList<>();
        List<int[]> ans = new ArrayList<>();
        List<Node> curBuildings = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
            heights.add(new Node(i, buildings[i][0],
                    buildings[i][2], "LEFT"));
            heights.add(new Node(i, buildings[i][1],
                    buildings[i][2], "RIGHT"));
        }
        heights.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return comp(o1, o2) == true ? -1 : 1;
            }
        });
        for (int i = 0; i < heights.size(); i++) {
            if (heights.get(i).type.equals("LEFT")) {
                int insertIdx = insertByOrder(curBuildings, heights.get(i));
                if (insertIdx == 0) {
                    ans.add(new int[]{heights.get(i).x, heights.get(i).y});
                }
            } else if (heights.get(i).type.equals("RIGHT")) {
                Node deleted = deleteById(curBuildings, heights.get(i).id);
                if (curBuildings.size() == 0 || deleted.y > curBuildings.get(0).y) {
                    ans.add(new int[]{heights.get(i).x, curBuildings.size() == 0 ? 0 : curBuildings.get(0).y});
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] buildings = new int[][] {
                {2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}
        };
        getSkyline(buildings);
    }

}
