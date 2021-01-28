import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int in = scanner.nextInt();

        int[][] arr = makeSpiral(in);

        for (int i = 0; i < in; i++) {
            for (int j = 0; j < in; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] makeSpiral(int n) {

        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= n * n; i++) {
            numbers.add(i);
        }

        int[][] tab = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tab[i][j] = 0;
            }
        }

        int row = 0;
        int column = 0;

        while (!numbers.isEmpty()) {

            while (column < n && tab[row][column] == 0) {
                tab[row][column] = numbers.remove(0);
                column++;
            }

            column--;
            row++;

            while (row < n && tab[row][column] == 0) {
                tab[row][column] = numbers.remove(0);
                row++;
            }

            row--;
            column--;

            while (column >= 0 && tab[row][column] == 0) {
                tab[row][column] = numbers.remove(0);
                column--;
            }

            column++;
            row--;

            while (row >= 0 && tab[row][column] == 0) {
                tab[row][column] = numbers.remove(0);
                row--;
            }

            row++;
            column++;
        }
        return tab;
    }
}