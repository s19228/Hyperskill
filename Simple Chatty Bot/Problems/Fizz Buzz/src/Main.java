import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int from = in.nextInt();
        int to = in.nextInt();

        for (; from <= to; from++) {
            if (from % 3 == 0 && from % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (from % 3 == 0) {
                System.out.println("Fizz");
            } else if (from % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(from);
            }
        }
    }
}