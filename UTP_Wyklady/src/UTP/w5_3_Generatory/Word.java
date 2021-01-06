package UTP.w5_3_Generatory;

import java.util.Random;

public class Word {

    static Random rand = new Random();
    private String word = "";

    public Word() {
        int count = rand.nextInt(10) + 1;
        while (count --> 0){
            int r1 = rand.nextInt('z' - 'a' + 1);
            word += (char) ('a' + r1);
        }
    }

/*
    (count --> 0) to tak jak poniżejx

    public Word() {
        int count = rand.nextInt(10) + 1;
        while (count > 0){
            int r1 = rand.nextInt('z' - 'a' + 1);
            word += (char) ('a' + r1);
            count--;
        }
    }
*/

    int size(){
        return word.length();
    }

    @Override
    public String toString() {
        return word;
    }
}
