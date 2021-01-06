import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int distance = 0;
        int days = 1;

        while (distance < h) {
            distance += a;
            if (distance < h) {
                distance -= b;
                days++;
            }
        }
        System.out.println(days);
    }
}