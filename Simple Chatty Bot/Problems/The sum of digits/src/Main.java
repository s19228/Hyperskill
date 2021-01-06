import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int a = num / 100;
        int b = (num - a * 100) / 10;
        int c = (num - a * 100) - b * 10;
        System.out.println(c + b + a);
    }
}