package algorithm.jianzhioffer;

/**
 * 快速排序
 */
public class QuickSort {

    public int partition(int[] a, int left, int right) throws Exception{
        if(a == null || left < 0 || right < left)
            throw new Exception("input error!");
        int index = (int)Math.round(Math.random() * (right - left)) + left;
        swap(a, index, right);
        int pSmall = left - 1;
        for(int i = left; i < right; i++) {
            if(a[i] < a[right]) {
                pSmall++;
                if(pSmall != i) {
                    swap(a, pSmall, i);
                }
            }
        }
        pSmall++;
        swap(a, pSmall, right);
        return pSmall;
    }

    public void quickSort(int[] a) {
        int len = a.length;
        try {
            coreQuickSort(a, 0, len - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void coreQuickSort(int[] a, int left, int right) throws Exception {
        if(left >= right) return;
        int p = partition(a, left, right);
        //也就是不等于left，如果等于的话数组已经有序
        if(p > left) {
            coreQuickSort(a, p + 1, right);
        }
        if(p < right) {
            coreQuickSort(a, left, p - 1);
        }
    }

    public void swap(int[] a, int s1, int s2) {
        int tmp = a[s1];
        a[s1] = a[s2];
        a[s2] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {3,4,2,5,2,6,77,43,235};
        QuickSort qs = new QuickSort();
        qs.quickSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
