import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        int counter = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'c' || s.charAt(i) == 'g' || s.charAt(i) == 'C' || s.charAt(i) == 'G') {
                counter++;
            }
        }

        double result = (double) counter / s.length() * 100;

        System.out.println(result);


    }
}