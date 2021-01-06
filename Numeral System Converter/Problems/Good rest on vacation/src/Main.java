import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dur = scanner.nextInt();
        int food = scanner.nextInt();
        int flight = scanner.nextInt();
        int hotel = scanner.nextInt();

        System.out.println((food * dur) + (flight * 2) + (hotel * (dur - 1)));

    }
}