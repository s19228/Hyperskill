import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        BigInteger input = new BigInteger(in.next());

        int num = 0;

        for (int i = 0; i < 100; i++) {
            BigInteger fac = factorial(BigInteger.valueOf(i));
            if (fac.compareTo(input) >= 0) {
                num = i;
                break;
            }
        }

        System.out.println(num);

    }

    public static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        } else {
            return new BigInteger(String.valueOf(n.multiply(factorial(n.subtract(BigInteger.ONE)))));
        }
    }
}