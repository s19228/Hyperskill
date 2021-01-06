import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int index = 0;

        while (scanner.nextInt() != 0) {
            index++;
        }
        System.out.println(index);
    }
}