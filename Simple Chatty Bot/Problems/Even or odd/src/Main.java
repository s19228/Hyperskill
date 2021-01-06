import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int val = in.nextInt();
            if (val == 0) {
                break;
            }
            System.out.println(val % 2 == 0 ? "even" : "odd");
        }
    }
}