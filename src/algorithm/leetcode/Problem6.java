package algorithm.leetcode;

public class Problem6 {
    public static String convert(String s, int numRows) {
        if(numRows == 1) return s;
        if(numRows > s.length()) return s;
        int groupNum = numRows * 2 - 2;
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < s.length(); i += groupNum) {
            sb.append(s.charAt(i));
        }
        for(int i = 1; i < numRows - 1; i++) {
            int p = i;
            while(true) {
                if(p >= s.length()) break;
                sb.append(s.charAt(p));
                p += (numRows - i - 1) * 2;
                if(p >= s.length()) break;
                sb.append(s.charAt(p));
                p += i * 2;
            }
        }
        for(int i = numRows - 1; i < s.length(); i+= groupNum) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
