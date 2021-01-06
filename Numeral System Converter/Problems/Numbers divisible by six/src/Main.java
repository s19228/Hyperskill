import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int sum = 0;

        int[] tab = new int[in.nextInt()];

        for (int i = 0; i < tab.length; i++) {
            tab[i] = in.nextInt();
        }

        for (int j : tab) {
            if (j % 6 == 0) {
                sum += j;
            }
        }

        System.out.println(sum);


    }
}