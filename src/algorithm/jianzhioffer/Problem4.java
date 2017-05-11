package algorithm.jianzhioffer;

/**
 * 把空格替换成字符串
 */
public class Problem4 {

    void replace(char[] string, int length) {
        if(string == null) return;
        int count = 0;
        for(char c : string) {
            if(c == ' ') {
                count++;
            }
        }
        if(string.length < length + 2 * count) {
            System.out.println("overflow!");
            return ;
        }
        int oldIndex = length - 1, newIndex = length + 2 * count - 1;
        while (oldIndex >= 0) {
            if (string[oldIndex] != ' ') {
                string[newIndex--] = string[oldIndex--];
            } else {
                string[newIndex--] = '0';
                string[newIndex--] = '2';
                string[newIndex--] = '%';
                oldIndex--;
            }
        }
    }

    public static void main(String[] args) {
        Problem4 s = new Problem4();
        char[] string = new char[10000];
        String tmp = "I love angelababy huang gun cu!  ";
        for (int i = 0; i < tmp.length(); i++) {
            string[i] = tmp.charAt(i);
        }
        s.replace(string, tmp.length());
        for(char c : string) System.out.print(c);
    }
}
