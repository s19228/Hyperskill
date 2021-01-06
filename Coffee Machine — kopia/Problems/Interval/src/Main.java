import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double val = in.nextDouble();

        if (val <= -15){
            System.out.println("False");
        } else if (val > -15 && val <= 12) {
            System.out.println("True");
        } else if (val > 14 && val < 17){
            System.out.println("True");
        } else if (val >= 19){
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }
}