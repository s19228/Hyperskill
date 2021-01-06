import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.close();
        char [][] matrix = new char[num][num];

        fillingArr(matrix);
        print(matrix);

    }

    public static void fillingArr(char[][] matrix) {
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix.length ; j++) {
                matrix[i][j] = '.';
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][matrix.length/2] = '*';
        }

        for (int i = 0; i < matrix.length; i++) {
            matrix[matrix.length/2][i] = '*';
        }

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = '*';
        }

        int j = matrix.length-1;
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][j] = '*';
            j--;
        }
    }

    public static void print(char[][] matrix) {
        for (char[] chars : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
    }
}