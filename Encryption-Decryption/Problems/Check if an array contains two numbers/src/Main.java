import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        boolean areNeighbours = false;
        int length = in.nextInt();
        int[] tab = new int[length];

        for (int i = 0; i < tab.length; i++) {
            tab[i] = in.nextInt();
        }

        int[] twoNumbersTab = new int[2];

        for (int i = 0; i < twoNumbersTab.length; i++) {
            twoNumbersTab[i] = in.nextInt();
        }

        for (int i = 0; i < tab.length - 1; i++) {
            if ((tab[i] == twoNumbersTab[0] && tab[i + 1] == twoNumbersTab[1]) || (tab[i] == twoNumbersTab[1] && tab[i + 1] == twoNumbersTab[0])) {
                areNeighbours = true;
                break;
            }
        }

        System.out.println(areNeighbours);


    }
}