package algorithm.jianzhioffer;

/**
 * 动态规划实现斐波那契数列
 */
public class Fibonacci {

    public int fibonacci(int n) throws Exception{
        if(n < 0) throw new Exception("input error!");
        if(n == 0) return 0;
        if(n == 1) return 1;
        int FibMinusTwo = 0;
        int FibMinusOne = 1;
        int FibN = 0;
        for(int i = 2; i <= n; i++) {
            FibN = FibMinusOne + FibMinusTwo;
            FibMinusTwo = FibMinusOne;
            FibMinusOne = FibN;
        }
        return FibN;
    }

    public static void main(String[] args) {
        Fibonacci f =new Fibonacci();
        try {
            System.out.println(f.fibonacci(5));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
