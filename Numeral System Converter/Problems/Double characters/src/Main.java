import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
        String[] tab = input.split("");

        for (String ch : tab) {
            System.out.print(ch + ch);
        }
    }
}