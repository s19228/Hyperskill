import java.util.Scanner;

public class Main {

    public static int getNumberOfMaxParam(int a, int b, int c) {
        int[] tab = {a, b, c};
        int max = tab[0];
        int pos = 0;

        for (int i = 1; i < tab.length; i++) {
            if (tab[i] > max) {
                max = tab[i];
                pos = i;
            }
        }

        return pos + 1;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final int a = scanner.nextInt();
        final int b = scanner.nextInt();
        final int c = scanner.nextInt();

        System.out.println(getNumberOfMaxParam(a, b, c));
    }
}