package bullscows;

import java.util.ArrayList;
import java.util.List;

public class Generator {

    List<Integer> digits = new ArrayList<>();
    String[] s = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

    void fill() {
        digits.add(1);
        digits.add(2);
        digits.add(3);
        digits.add(4);
        digits.add(5);
        digits.add(6);
        digits.add(7);
        digits.add(8);

        System.out.println(digits);


    }


}
