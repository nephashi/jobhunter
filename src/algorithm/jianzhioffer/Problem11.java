package algorithm.jianzhioffer;

public class Problem11 {

    public static double power(double base, int exponent) throws Exception {
        if(base == 0 && exponent <= 0) {
            throw new Exception("Invalid input!");
        }
        if(exponent < 0) {
            if(base == 0) return 0;
            else {
                return 1.0 / absPower(base, -exponent);
            }
        }
        return absPower(base, exponent);
    }

    public static double absPower(double base, int exponent) throws Exception{
        if(exponent ==0) return 1.0;
        if(exponent <0 ) {
            throw new Exception("no!");
        }
        double rst = 1.0;
        for(int i = 0; i < exponent; i++) {
            rst *= base;
        }
        return rst;
    }
    public static double recursiveAbsPower(double base, int exponent) throws Exception {
        if(exponent < 0) throw new Exception("no!");
        if(exponent ==0) return 1;
        if(exponent ==1) return base;
        double result = recursiveAbsPower(base, exponent >> 1);
        result *= result;
        if((exponent & 1) != 0) {
            result *= base;
        }
        return result;
    }
}
