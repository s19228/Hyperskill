import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String tmp = in.nextLine();

        if (tmp.charAt(0) == tmp.charAt(3) && tmp.charAt(1) == tmp.charAt(2)) {
            System.out.println(1);
        } else if (tmp.charAt(0) == 0 && tmp.charAt(1) == tmp.charAt(3)) {
            System.out.println(1);
        } else if (tmp.charAt(0) == 0 && tmp.charAt(1) == 0 && tmp.charAt(2) == tmp.charAt(3)) {
            System.out.println(1);
        } else if (tmp.charAt(0) == 0 && tmp.charAt(1) == 0 && tmp.charAt(2) == 0) {
            System.out.println(1);
        } else {
            System.out.println(37);
        }
    }
}