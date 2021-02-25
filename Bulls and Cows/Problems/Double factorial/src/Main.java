import java.math.BigInteger;

class DoubleFactorial {

    public static BigInteger calcDoubleFactorial(int n) {
        return n == 0 || n == 1 ? BigInteger.valueOf(1) : BigInteger.valueOf(n).multiply(calcDoubleFactorial(n - 2));
    }
}

