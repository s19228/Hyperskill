import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();
        double p = (a + b + c) / 2;
        double S = Math.sqrt(p*(p-a)*(p-b)*(p-c));

        System.out.println(S);
    }
}