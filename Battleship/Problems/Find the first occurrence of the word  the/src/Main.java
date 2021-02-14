import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        int intIndex = s.indexOf("The");

        if (intIndex == -1){
            intIndex = s.indexOf("the");
        }

        System.out.println(intIndex);


    }
}