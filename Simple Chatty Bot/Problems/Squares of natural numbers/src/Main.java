import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();

        for (int i = 1; i <= Math.sqrt(a); i++) {
            System.out.println((int)Math.pow(i, 2));
        }
    }
}