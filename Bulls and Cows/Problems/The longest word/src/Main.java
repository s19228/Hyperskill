import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] words = s.split(" ");

        int length = words[0].length();
        int pos = 0;

        for (int i = 1; i < words.length; i++) {
            if(words[i].length() > length){
                length = words[i].length();
                pos = i;
            }
        }
        System.out.println(words[pos]);

    }
}