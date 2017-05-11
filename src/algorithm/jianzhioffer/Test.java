package algorithm.jianzhioffer;


public class Test {

    public static void main(String[] args) {
        int[] a= {0,0,0,0,0,0,0};
        Test.change(a);
        System.out.println(a[5]);
    }

    public static void change(int[] a){
        a[5] = 1;
    }
}
