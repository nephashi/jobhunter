package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class April18BaiduTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in);
        String input = sc.nextLine();
        ArrayList<ArrayList<Integer>> virusIndeies = new ArrayList<>();
        String virus = "virus";

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'v') {
                boolean isVirus = true;
                int j = 0;
                for (j = 0; j < virus.length() && i + j < input.length(); j++) {
                    if (!(input.charAt(i + j) == virus.charAt(j))) {
                        isVirus = false;
                        break;
                    }
                    if (i + j == input.length() - 1 && input.charAt(i + j) != 's') {
                        isVirus = false;
                    }
                }

                if (isVirus) {
                    ArrayList<Integer> tuple = new ArrayList<>();
                    tuple.add(i+ j - 5);
                    tuple.add(i+ j - 1);
                    virusIndeies.add(tuple);
                }
                i += j - 1;
            }
        }

        int substrCount = 0;
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 4; j < input.length(); j++) {
                for (int k = 0; k < virusIndeies.size(); k++) {
                    if (i <= virusIndeies.get(k).get(0) && j >= virusIndeies.get(k).get(1)) {
                        substrCount++;
                        //System.out.println(i + "," + j);
                        break;
                    }
                }
            }
        }

        System.out.println(substrCount);
    }
}

