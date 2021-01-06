import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        for (var i = 1; i < 1001; i++) {
            if (getResult(a, b, c, d, i) == 0) {
                System.out.println(i);
            }
        }
    }

    public static int getResult(int a, int b, int c, int d, int x) {
        return a * x * x * x + b * x * x + c * x + d;
    }
}
