import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        String[] s1 = s.split(" ");
        int i = Integer.parseInt(s1[1]);

        if (i > s1[0].length()) {
            System.out.println(s1[0]);
        } else {
            String s2 = s1[0].substring(i);
            String s3 = s1[0].substring(0, i);
            System.out.println(s2 + s3);
        }
    }
}