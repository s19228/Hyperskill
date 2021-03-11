import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String text = in.nextLine();

        char[] tab = text.toCharArray();

        boolean flag = true;

        for (int i = 0; i < tab.length - 1; i++) {
            if ((int) (tab[i] + 1) != (int) (tab[i + 1])) {
                flag = false;
                break;
            }
        }

        System.out.println(flag);



    }
}