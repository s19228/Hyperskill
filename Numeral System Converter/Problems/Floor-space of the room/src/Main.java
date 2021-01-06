import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String choice = in.next();

        switch (choice) {
            case ("triangle"): {
                countTriangle(in);
            }
            case ("rectangle"): {
                System.out.println(in.nextDouble() * in.nextDouble());
                break;
            }
            case ("circle"):
                double r = in.nextDouble();
                System.out.println((3.14 * r * r));
                break;
            default:
                System.out.println("err");
                break;
        }
    }

    private static void countTriangle(Scanner in) {
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();
        double p = (a + b + c) / 2;
        double P = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        System.out.println(P);

    }
}