import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int[] tab = new int[in.nextInt()];

        for (int i = 0; i < tab.length; i++) {
            tab[i] = in.nextInt();
        }

        int num = in.nextInt();

        boolean isInTab = false;

        for (int j : tab) {
            if (num == j) {
                isInTab = true;
                break;
            }
        }

        System.out.println(isInTab);

    }
}