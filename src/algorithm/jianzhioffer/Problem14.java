package algorithm.jianzhioffer;

public class Problem14 {

    public static void reOrderOddEven(int[] data) {
        int i = 0, j = data.length - 1;
        while (i < j) {
            while (i < j && (data[i] & 0x1) != 0) {
                i++;
            }
            while (i < j && (data[j] & 0x1) == 0) {
                j--;
            }
            swap(data, i, j);
        }
    }

    public static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void main(String[] args) {
        int[] data = {1,2,3,4,5,6,7,8,9};
        reOrderOddEven(data);
        for(int i : data) {
            System.out.println(i);
        }
    }
}
