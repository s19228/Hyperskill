import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        if (n * m < k) {
            System.out.println("NO");
        } else if (k % m == 0 || k % n == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


    }
}