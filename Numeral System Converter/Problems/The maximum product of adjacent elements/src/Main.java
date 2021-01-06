import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int tabLength = in.nextInt();

        int [] tab = new int[tabLength];

        for (int i = 0; i < tabLength; i++) {
            tab[i] = in.nextInt();
        }

        int maximum = 0;

        for (int i = 0; i < tabLength - 1 ; i++) {
            if (tab[i] * tab[i+1] > maximum){
                maximum = tab[i] * tab[i+1];
            }
        }

        System.out.println(maximum);


    }
}