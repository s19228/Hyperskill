import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();

        if (str.charAt(0) == 'j' || str.charAt(0) == ('J')) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
