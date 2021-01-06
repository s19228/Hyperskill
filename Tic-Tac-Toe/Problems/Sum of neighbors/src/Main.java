import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String tmp = "";
        StringBuilder equal = new StringBuilder();
        int row = -1;

        while (!(tmp.equals("end"))) {
            equal.append(tmp).append(" ");
            tmp = scanner.nextLine();
            row++;
        }

        scanner = new Scanner(equal.toString());
        int counter = 0;

        while (scanner.hasNextInt()) {
            scanner.nextInt();
            counter++;
        }

        int column = counter / row;
        int[][] tmpArr = new int[row][column];
        scanner = new Scanner(equal.toString());

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                tmpArr[i][j] = scanner.nextInt();
            }
        }

        int[][] newArr = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int left = j - 1;
                int up = i - 1;
                int right = j + 1;
                int down = i + 1;
                if (i == 0) {
                    up = row - 1;
                }
                if (i == row - 1) {
                    down = 0;
                }
                if (j == 0) {
                    left = column - 1;
                }
                if (j == column - 1) {
                    right = 0;
                }
                newArr[i][j] = tmpArr[up][j] + tmpArr[down][j] + tmpArr[i][left] + tmpArr[i][right];
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(newArr[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}