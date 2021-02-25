import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        BigInteger a = in.nextBigInteger();
        BigInteger b = in.nextBigInteger();
        BigInteger c = in.nextBigInteger();
        BigInteger d = in.nextBigInteger();

        BigInteger res = a.negate().multiply(b).add(c).subtract(d);

        System.out.println(res);



    }
}