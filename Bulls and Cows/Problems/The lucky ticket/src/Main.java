import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int[] tab = new int[s.length()];

        for (int i = 0; i < tab.length; i++) {
            tab[i] = Character.getNumericValue(s.charAt(i));
        }

        if (tab[0] + tab[1] + tab[2] == tab[3] + tab[4] + tab[5]){
            System.out.println("Lucky");
        } else {
            System.out.println("Regular");
        }
    }
}