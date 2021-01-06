package Udemy.Kloekcje_Listy_Mapy_Kolejki.HashSet_TreeSet;

import javax.crypto.spec.PSource;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        long mili = 0;
        long totalMili = 0;

        //hascode (liczba całkowita) - to tzw kod mieszający
        System.out.println("abba".hashCode());

        Element a = new Element(5);
        Element b = new Element(5);

        System.out.println(a == b);
        System.out.println(a.equals(b));

        System.out.println(a.hashCode() + " " + b.hashCode());

        //interfejs implementowany m.in przez HashSet

        Set<String> set = new HashSet<>(512);

        // tree set to set (zbior uporzadkowany)
        set = new TreeSet<>();


        //HashSet<String> hset = new HashSet<>(12); - probowalem czy da sie tak stworzyc i sie da

        try {
            Scanner reader = new Scanner(new BufferedReader(new FileReader("informatyka.txt")));

            while (reader.hasNext()) {

                mili = System.currentTimeMillis();

                set.add(reader.next());

                totalMili += System.currentTimeMillis() - mili;
            }
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        Iterator<String> iter = set.iterator();

        while (iter.hasNext())
            System.out.println(iter.next()  );


        System.out.println("czas wykonania: " +totalMili);
        System.out.println("wielkosc zbioru: " + set.size());


    }


}
