import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // write your code here
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;
        int seed = 0;
        Random random;
        int seed_ = 0;

        for (int i = A; i <= B; i++) {

            random = new Random(i);

            for (int j = 0; j < N; j++) {

                int num = random.nextInt(K);

                if (maximum < num) {
                    maximum = num;
                    seed_ = i;
                }
            }

            if (minimum > maximum) {
                minimum = maximum;
                seed = seed_;
            }

        }

        System.out.println(seed);
        System.out.println(minimum);
    }
}