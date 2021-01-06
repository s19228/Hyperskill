import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        int previous;
        int elements = 1;
        int ascendingCount = 1;
        int descendingCount = 1;

        while (num != 0) {
            previous = num;
            num = scanner.nextInt();

            if (num == 0) {
                break;
            }

            elements++;

            if (num >= previous) {
                ascendingCount++;
            } else {
                descendingCount++;
            }
        }

        if (ascendingCount == elements || descendingCount == elements) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}