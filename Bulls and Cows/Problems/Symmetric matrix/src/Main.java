import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[][] tab = new int[size][size];

        boolean isSymetric = true;

        for (int i = 1; i < tab.length - 1; i++) {
            if (tab[i][i] != tab[i-1][i+1] || tab[i][i] != tab[i+1][i-1]){
                isSymetric = false;
                break;
            }
        }


        if (isSymetric) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}