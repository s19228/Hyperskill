import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] tab = new String[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String ch = scanner.next("[WBRGY]");
                tab[i][j] = ch;
            }
        }
        printArr(tab);
    }

    static void printArr(String[][] arr){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(arr[i][j]);
            }
            System.out.println();
        }
    }

}