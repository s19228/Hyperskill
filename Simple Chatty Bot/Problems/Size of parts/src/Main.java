import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] tab = new int[in.nextInt()];

        for (int i = 0; i < tab.length; i++) {
            tab[i] = in.nextInt();
        }

        int sumOfzeros = 0;
        int sumOfones = 0;
        int sumOfminusOne = 0;

        for (int value : tab) {
            if (value == -1) {
                sumOfminusOne++;
            } else if (value == 0) {
                sumOfzeros++;
            } else {
                sumOfones++;
            }
        }
        System.out.println(sumOfzeros + " " + sumOfones + " " + sumOfminusOne);

    }
}