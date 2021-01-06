import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        while (scanner.hasNextInt())
            sum += scanner.nextInt();
        System.out.println(sum / 2 + sum % 2);

    }
}