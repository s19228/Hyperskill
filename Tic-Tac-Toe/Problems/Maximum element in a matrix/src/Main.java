import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int columns = in.nextInt();

        int[][] arr = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        int max = arr[0][0];
        int maxRow = 0;
        int maxColumn = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(arr[i][j] > max){
                    max = arr[i][j];
                    maxRow = i;
                    maxColumn = j;
                }
            }
        }

        System.out.print(maxRow + " " + maxColumn);

    }
}