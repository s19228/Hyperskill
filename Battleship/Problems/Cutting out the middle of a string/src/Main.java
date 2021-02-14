import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        int c = s.length();

        if (c % 2 == 0) {
            String first = s.substring(0, c / 2);
            String firstMod = first.substring(0, first.length() -1);
            String second = s.substring(c / 2);
            String secMod = second.substring(1);
            System.out.println(firstMod + secMod);
        } else {
            String first = s.substring(0, c / 2);
            String second = s.substring(c / 2);
            String secMod = second.substring(1);
            System.out.println(first + secMod);
        }

    }
}