import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();
        int from = in.nextInt();
        int to = in.nextInt();

        for (int i = from; i <= to; i++) {
            System.out.print(word.charAt(i));
        }
    }
}