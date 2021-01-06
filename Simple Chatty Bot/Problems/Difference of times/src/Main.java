import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt() * 60 * 60;
        int b = scanner.nextInt() * 60;
        int c = scanner.nextInt();
        int d = scanner.nextInt() * 60 * 60;
        int e = scanner.nextInt() * 60;
        int f = scanner.nextInt();

        System.out.println(d + e + f - (a + b + c));

    }
}