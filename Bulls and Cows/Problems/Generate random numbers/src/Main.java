import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        Random random = new Random(a + b);
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int next = random.nextInt(b - a + 1) + a;
            sum += next;
        }

        System.out.println(sum);


    }
}