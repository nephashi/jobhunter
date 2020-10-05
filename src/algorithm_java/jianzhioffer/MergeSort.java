package algorithm.jianzhioffer;

/**
 * 归并排序
 */
public class MergeSort {

    public void sort(int[] a) {
        coreMergeSort(a, 0, a.length - 1);
    }

    public void coreMergeSort(int[] a, int left, int right) {
        if(left >= right) return;
        int mid = (left + right) / 2;
        coreMergeSort(a, left, mid);
        coreMergeSort(a, mid + 1, right);
        merge(a, left, mid, right);
    }

    public void merge(int[] a, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if(a[i] < a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = a[i++];
        }
        while (j <= right) {
            tmp[k++] = a[j++];
        }
        for(i = 0; i < right - left + 1; i++) {
            a[left + i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        MergeSort m = new MergeSort();
        int[] a = {3,4,2,5,2,6,77,43,235};
        m.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
