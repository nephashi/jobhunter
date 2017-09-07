package algorithm.jianzhioffer;

/**
 * 旋转数组的最小数字
 */
public class Problem8 {

    /**
     * 寻找增序数组的旋转中的最小数字
     * 2017/6/19
     * @param a
     * @return
     * @throws Exception
     */
    int searchMin2(int[] a) throws Exception {
        if(a == null) throw new Exception("null!");
        int left = 0, right = a.length, mid = left;
        while (a[left] >= a[right]) {
            if(right == left + 1) break;
            mid = (left + right) / 2;
            if(a[left] == a[right] && a[left] == a[mid]) {
                int min = a[left];
                while (left <= right) {
                    if(a[left] < min)
                        min = a[left];
                    left++;
                }
                return min;
            }
            if(a[mid] >= a[left]) {
                left = mid;
            } else if(a[mid] <= a[right]) {
                right = mid;
            }
        }
        return a[mid];
    }

    int searchMin(int[] a) throws Exception{
        if(a == null) throw new Exception("input error!");
        int len = a.length;
        int left = 0, right = len - 1, mid = 0;
        while (true) {
            if(a[left] < a[right]) return left;
            if(right - left ==1) {
                break;
            }
            mid = (left + right) / 2;
            if(a[left] == a[mid] && a[right] == a[mid]) {
                int min = a[left];
                int minIndex = 0;
                for(int i = left; i <= right; i++) {
                    if(a[i] <= min){
                        min = a[i];
                        minIndex = i;
                    }
                }
                return minIndex;
            }
            if(a[left] >= a[mid]) {
                right = mid;
            } else if(a[right] <= a[mid]){
                left = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] a = {1,0,1,1,1};
        Problem8 p = new Problem8();
        try {
            System.out.println(p.searchMin(a));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
