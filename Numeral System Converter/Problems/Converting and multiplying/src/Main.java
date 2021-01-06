import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (true) {

            String val = in.nextLine();

            if ("0".equals(val)) {
                break;
            }

            if (val.matches("[a-z]*")) {
                System.out.println("Invalid user input: " + val);
            }

            try {
                System.out.println(Integer.parseInt(val) * 10);
            } catch (NumberFormatException ignored) {}
        }
    }
}
