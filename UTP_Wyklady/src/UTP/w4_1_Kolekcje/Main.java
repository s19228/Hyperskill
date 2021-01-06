package UTP.w4_1_Kolekcje;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

    /*
        Na kolekacjach dzialamy za pomoca interfejsow!

         static void show (List<?> list){
        for (Object o : list)
            System.out.println(o);
        }

        a nie tak!:
        static void show (ArrayList<String> list{
        for (String s : list)
            System.out.print(s);
        }
     */

        List<Integer> listka = new ArrayList<>();
        listka.add(3);
        listka.add(5);

        System.out.println(Arrays.asList(listka));

        show(listka);
        System.out.println("----------------");

        List<Integer> listka2 = new LinkedList<>();
        listka2.add(2);
        listka2.add(4);

        show(listka2);

        // Chcac podawac dane w locie piszemy tak:

        List<Integer> lista3 = Arrays.asList(1, 2, 3, 4, 5, 6);
        //List<Person> list4 = Arrays.asList(new Person ("Jan"), new Person ("Ala")); - nie mam pojecia dlaczego u mnienie dziala
        show(lista3);


        List<String> list = new ArrayList<>();

        // dodawanie obiektow do listy na 2 sposoby

        //1
        Object[] tab1 = list.toArray();
        for (int i = 0; i < tab1.length; i++) {
            int len = ((String) tab1[i]).length();
            System.out.print(len);
        }

        //2
        String[] tab2 = (String[]) list.toArray(new String[0]);
        for (int i = 0; i < tab2.length; i++) {
            int len = tab2[i].length() * 2;
            System.out.println(len);
        }

    }

    static void show(List<?> list) {
        for (Object o : list)
            System.out.print(o + " ");
        System.out.println();
    }
}
