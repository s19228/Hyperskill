import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final double grav = 9.8;
        double p = scanner.nextDouble();
        double h = scanner.nextDouble();

        System.out.println(p * h * grav);
    }
}