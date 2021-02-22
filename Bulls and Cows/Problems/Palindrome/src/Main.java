import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int h = s.length();

        int kk = 0;
        int k = (h - 1);
        for (int i = 0; i < h; i++) {

            if (s.charAt(i) != s.charAt(k)) {
                kk = 1;
                break;
            }
            k--;
        }
        System.out.println(kk == 1 ? "no" : "yes");
    }
}