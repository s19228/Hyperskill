import java.util.Scanner;

class Main {
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);

       String a = in.nextLine();
       String b = in.nextLine();

       String c = a.trim().replace(" ","");
       String d = b.trim().replace(" ","");

        //System.out.println(c);
        //System.out.println(d);

        System.out.println(c.equals(d));

    }
}