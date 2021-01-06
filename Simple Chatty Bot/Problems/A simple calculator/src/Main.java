import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        long a = in.nextLong();
        char operator = in.next().charAt(0);
        long b = in.nextLong();

        if (b == 0) {
            System.out.println("Division by 0! ");
        } else {
            switch (operator) {
                case '+':
                    System.out.println(a + b);
                    break;
                case '-':
                    System.out.println(a - b);
                    break;
                case '*':
                    System.out.println(a * b);
                    break;
                case '/':
                    System.out.println(a / b);
                    break;
                default:
                    System.out.println("Unknown operator");
                    break;
            }
        }
    }
}