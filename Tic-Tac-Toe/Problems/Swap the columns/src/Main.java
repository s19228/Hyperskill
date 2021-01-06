import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int sizeA = in.nextInt();
        int sizeB = in.nextInt();

        int[][] arr = new int[sizeA][sizeB];

        for (int i = 0; i < sizeA; i++) {
            for (int j = 0; j < sizeB; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        // printing 2D array
/*        for (int i = 0; i < sizeA; i++) {
            for (int j = 0; j < sizeB; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }*/

        int column1 = in.nextInt();
        int column2 = in.nextInt();

        // making temporary column (table)
        int[] tmpColumn = new int[sizeA];

        // filling temporary column (table)
        for (int i = 0; i < sizeA; i++) {
            tmpColumn[i] = arr[i][column1];
        }

/*        System.out.println("Temporary column:");
        System.out.println(Arrays.toString(tmpColumn));*/

        //  copying values from one colum to the second
        for (int i = 0; i < sizeA; i++) {
            arr[i][column1] = arr[i][column2];
        }

        // filling values from tmp array
        for (int i = 0; i < sizeA; i++) {
            arr[i][column2] = tmpColumn[i];
        }

        

        // printing 2D array
        for (int i = 0; i < sizeA; i++) {
            for (int j = 0; j < sizeB; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

}