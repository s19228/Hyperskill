import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long input = scanner.nextLong();
        for (int i = 0; i < 20; i++) {
            if (factorial(i) > input) {
                System.out.println(i);
                break;
            }
        }
    }

    public static long factorial(int number) {
        long result = 1;
        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }
        return result;
    }
}
