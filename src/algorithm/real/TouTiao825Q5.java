package algorithm.real;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Constrain {
    public String l;
    public String r;
    public int num;

    public Constrain(String l, String r, int n) {
        this.l = l;
        this.r = r;
        this.num = n;
    }
}

class Query {
    public String l;
    public String r;

    public Query(String l, String r) {
        this.l = l;
        this.r = r;
    }
}

public class TouTiao825Q5 {

    static boolean found = false;

    public static void search(HashMap<String, List<Constrain>> relations,
                              HashMap<Constrain, Boolean> used,
                              String curSrcVariable, String targetVariable,
                              List<Constrain> curPath,
                              List<Constrain> rst) {
        List<Constrain> l = relations.get(curSrcVariable);
        for (int i = 0; i < l.size(); i++) {
            if (used.containsKey(l.get(i)) && used.get(l.get(i)) == true)
                continue;
            curPath.add(l.get(i));
            used.put(l.get(i), true);
            if (l.get(i).r.equals(targetVariable)) {
                rst.addAll(curPath);
                found = true;
            }
            if (found)
                return;
            String nextSrc = curSrcVariable.equals(l.get(i).l) ? l.get(i).r : l.get(i).l;
            search(relations, used, nextSrc, targetVariable, curPath, rst);
            if (found)
                return;
            used.put(l.get(i), false);
            curPath.remove(l.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String str = sc.nextLine();
        List<Constrain> constrain = new ArrayList<>();
        List<Query> queries = new ArrayList<>();
        HashMap<String, Boolean> variables =  new HashMap();

        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            Constrain nn = new Constrain(line[0], line[4], Integer.valueOf(line[2]));
            constrain.add(nn);
            variables.put(line[0], true);
            variables.put(line[4], true);
        }

        for (int i = 0; i < m; i++) {
            String[] line = sc.nextLine().split(" ");
            queries.add(new Query(line[0], line[2]));
        }

        HashMap<String, List<Constrain>> relations = new HashMap<>();
        for (String s : variables.keySet()) {
            relations.put(s, new ArrayList<>());
        }

        for (int i = 0; i < constrain.size(); i++) {
            relations.get(constrain.get(i).l).add(constrain.get(i));
            relations.get(constrain.get(i).r).add(constrain.get(i));
        }

        for (int i = 0; i < queries.size(); i++) {
            List<Constrain> cons = new ArrayList<>();
            search(relations, new HashMap<>(), queries.get(i).l, queries.get(i).r,
                    new ArrayList<>(),
                    cons);

            if (cons.size() == 0)
                System.out.println("cannot_answer");
            else {
                int aaans = 0;
                for (int j = cons.size() - 1; j >= 0; j-=3) {
                    if (j >= 2) {
                        aaans += (cons.get(j).num - cons.get(j - 1).num + cons.get(j - 2).num);
                    } else if (j == 1)
                        aaans += (cons.get(j).num - cons.get(j - 1).num);
                }

                System.out.println(aaans * -1);
            }


        }



    }

}