import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int squirrel = scanner.nextInt();
        int nuts = scanner.nextInt();

        System.out.println(nuts % squirrel);

    }
}