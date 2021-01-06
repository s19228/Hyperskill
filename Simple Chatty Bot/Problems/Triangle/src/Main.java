import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        if (c * c == a * a + b * b) {
            System.out.println("YES");
        } else if (b * b == a * a + c * c) {
            System.out.println("YES");
        } else if (a * a == b * b + c * c) {
            System.out.println("YES");
        }
        else if (a == b && b == c) {
        System.out.println("YES");
        }
        else System.out.println("NO");
    }
}