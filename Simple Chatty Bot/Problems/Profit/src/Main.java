import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double m = in.nextDouble();
        double p = in.nextDouble() / 100;
        double k = in.nextDouble();

        int years = 0;

        while (m < k) {
            m += m * p;
            years++;
        }

        System.out.println(years);

    }
}
