import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int num = in.nextInt();
        System.out.print(num + " ");

        while (num != 1) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num * 3 + 1;
            }
            System.out.print(num + " ");
        }
    }
}