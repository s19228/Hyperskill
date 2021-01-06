import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tab = new int[4];

        for (int i = 0; i < tab.length; i++) {
            tab[i] = scanner.nextInt();
        }
        for (int value : tab) {
            System.out.print(value - 1 + " ");
        }
    }
}