package Udemy.Kloekcje_Listy_Mapy_Kolejki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Collection a;
        ArrayList b;
        Map c;

        ArrayList<String> d = new ArrayList();

        d.add("konrad");
        d.add(new String("gryka"));

        System.out.println(Arrays.asList(d));

        NaszaKlasa<Integer> nk1 = new NaszaKlasa<>();
        nk1.nadajWartosc(23);
        System.out.println(nk1.zwroc());

        NaszaKlasa<String> nk2 = new NaszaKlasa<>();
        nk2.nadajWartosc("Makumba");
        System.out.println(nk2.zwroc());

        d.add(nk2.toString());

        for (String s : d){
            System.out.println(s);
        }

    }


}
