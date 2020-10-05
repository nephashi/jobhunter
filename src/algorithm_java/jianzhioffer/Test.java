package algorithm.jianzhioffer;


import java.util.function.Function;

public class Test {

    public static void main(String[] args) {


        System.out.println(1/3.0);
    }

    public void service(Function<String, String> str){
        str.apply("hello");
    }

    public static void change(int[] a){
        a[5] = 1;
    }
}
