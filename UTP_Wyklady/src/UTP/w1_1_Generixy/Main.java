package UTP.w1_1_Generixy;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Para<String, String> p1 = new Para<>("Jan", "Kowalski");
        System.out.println(p1);

        Para<String, Data> p2 = new Para<>("Jan Kowalski", new Data("2020-03-19"));
        System.out.println(p2);

        Para<String, Integer> p3 = new Para<>("Ala srala", 12);
        System.out.println(p3);

        TestClass t1 = new TestClass("Nazwa", 13, false);

        Para<Integer, TestClass> p4 = new Para<>(123, t1);
        Para<Integer, TestClass> p5 = new Para<>(121, new TestClass("Andrzej", 1230, true));

        System.out.println(p5);

        //List<String> lista = new ArrayList<>();
        //metoda(lista);

        metoda(new ArrayList<>());

        System.out.println(p3.getFirst() + " " + p3.getLast());

        System.out.println(p5.getLast());

        p3.setFirst(p3.getFirst() + "bala");
        p3.setLast(p3.getLast()*2);
        System.out.println(p3);

    }

    static void metoda (List<String> list){
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);
    }


}
