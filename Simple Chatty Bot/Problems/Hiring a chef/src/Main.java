//put imports you need here

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String age = scanner.nextLine();
        String secondary = scanner.nextLine();
        String number = scanner.nextLine();
        String dish = scanner.nextLine();

        System.out.println("The form for " + name + " is completed. We will contact you if we need a chef that cooks " + dish + " dishes.");

    }
}