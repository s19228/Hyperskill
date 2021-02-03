import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int[] tab = new int[a];

        for (int i = 0; i < tab.length; i++) {
            tab[i] = scanner.nextInt();
        }

        OptionalInt min = Arrays.stream(tab).min();
        int minimm = min.getAsInt();

        System.out.println(minimm);

    }
}