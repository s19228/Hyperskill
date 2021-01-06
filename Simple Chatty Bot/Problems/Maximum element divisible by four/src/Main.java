import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int howmMany = in.nextInt();

        int[] tmp = new int[howmMany];

        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = in.nextInt();
        }

        int maxDiv = 0;

        for (int i = 0; i < tmp.length; i++) {
            if ((tmp[i] %4 == 0) && tmp[i] > maxDiv) {
                maxDiv = tmp[i];
            }
        }
        System.out.println(maxDiv);
    }
}