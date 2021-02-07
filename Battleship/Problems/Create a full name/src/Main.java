// Don't delete scanner import
import java.util.Scanner;

class Name {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String first = in.next();
        String second = in.next();

        System.out.println(createFullName(first, second));

    }

    //implement your method here
    public static String createFullName (String first, String second){
        return first + " " + second;
    }
}