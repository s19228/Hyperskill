import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int X1 = in.nextInt();
        int Y1 = in.nextInt();
        int Z1 = in.nextInt();
        int X2 = in.nextInt();
        int Y2 = in.nextInt();
        int Z2 = in.nextInt();

        int[] xDimSort = new int[3];
        int[] yDimSort = new int[3];

        sortArray(X1, Y1, Z1, xDimSort);
        sortArray(X2, Y2, Z2, yDimSort);

        if (xDimSort[0] < yDimSort[0] && xDimSort[1] < yDimSort[1] && xDimSort[2] < yDimSort[2]){
            System.out.println("Box 1 < Box 2");
        } else if (xDimSort[0] >= yDimSort[0] && xDimSort[1] >= yDimSort[1] && xDimSort[2] >= yDimSort[2]){
            System.out.println("Box 1 > Box 2");
        } else {
            System.out.println("Incompatible");
        }
    }

    private static void sortArray(int X1, int Y1, int Z1, int[] xDimSort) {
        if ((X1 <= Y1) && (X1 <= Z1)){
            xDimSort[0] = X1;
            if (Y1 <= Z1){
                xDimSort[1] = Y1;
                xDimSort[2] = Z1;
            } else {
                xDimSort[1] = Z1;
                xDimSort[2] = Y1;
            }
        }else if ((Y1 <= X1) && (Y1 <= Z1)){
            xDimSort[0] = Y1;
            if (X1 <= Z1){
                xDimSort[1] = X1;
                xDimSort[2] = Z1;
            } else {
                xDimSort[1] = Z1;
                xDimSort[2] = X1;
            }
        }else if ((Z1 < X1) && (Z1 < Y1)){
            xDimSort[0] = Z1;
            if (X1 < Y1){
                xDimSort[1] = X1;
                xDimSort[2] = Y1;
            } else {
                xDimSort[1] = Y1;
                xDimSort[2] = X1;
            }
        }
    }
}