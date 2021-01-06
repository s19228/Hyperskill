import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.next();

        String[] tab = s.split("-");

        System.out.println(tab[1] + "/" + tab[2] + "/" + tab[0]);

    }
}