import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String tmp = in.next();
        String tmp2 = tmp.replace('a', 'b');
        System.out.println(tmp2);
    }
}