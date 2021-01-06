import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int howMany = in.nextInt();

        int [] tab = new int[howMany];

        int max = 0;

        while (in.hasNextLine()){
            for (int i = 0; i < howMany; i++) {
                tab[i] = in.nextInt();
                //System.out.print(tab[i] + ", ");
            }

            for (int i = 0; i < howMany; i++) {
                if (tab[i] %4 == 0 && tab[i] > max){
                     max = tab[i];
                }
            }break;

        }
        System.out.println(max);




    }
}