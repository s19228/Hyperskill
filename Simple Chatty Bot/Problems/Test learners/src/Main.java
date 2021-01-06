import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int lang = in.nextInt();

        switch (lang) {
            case 1:
                System.out.println("Yes!");
                break;
            case 2:
            case 3:
            case 4:
                System.out.println("No!");
                break;
            default:
                System.out.println("Unknown number");
                break;
        }
    }
}