import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        long sum = 0;
        int size = b - a + 1;

        int[] tab = new int[size];

        for (int i = 0; i < size; i++) {
            if (i == 0) {
                tab[i] = a;
            }
            tab[i] = a++;
        }

        for (int i = 0; i < size - 1; i++) {
            if (size == 2) {
                sum = tab[0];
                break;
            }
            if (size == 3) {
                sum = tab[0] * tab[1];
                break;
            }
            if (i == 0) {
                sum = tab[i] * tab[i + 1];
                i = 2;
            }
            sum = sum * tab[i];
        }

        System.out.println(sum);
    }
}