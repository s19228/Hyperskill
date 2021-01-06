import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();

        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }

        int howManyTriples = 0;

        for (int i = 0; i < array.length - 2; i++) {
            if (array[i] + 1 == array[i + 1] && array[i + 1] + 1 == array[i + 2]) {
                howManyTriples++;
            }
        }

        System.out.println(howManyTriples);

    }
}