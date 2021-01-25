import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String choice = in.next();

        switch (choice) {
            case ("triangle"): {
                double a = in.nextDouble();
                double b = in.nextDouble();
                double c = in.nextDouble();
                double p = ((a + b + c) / 2.0);
                System.out.println((Math.sqrt(p * (p - a) * (p - b) * (p - c))));
                break;
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
}