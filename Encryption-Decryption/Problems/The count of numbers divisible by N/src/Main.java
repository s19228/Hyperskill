import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int n = in.nextInt();

        in.close();

        int counter = b / n - a / n;

        if (a % n == 0) {
            counter++;
        }

        System.out.println(counter);


    }
}