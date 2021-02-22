import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[][] tab = new int[size][size];

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                tab[i][j] = in.nextInt();
            }
        }

        boolean isSymetric = true;


        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                if (tab[i][j] != tab[j][i]) {
                    isSymetric = false;
                    break;
                }
            }
        }

        if (isSymetric){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}



