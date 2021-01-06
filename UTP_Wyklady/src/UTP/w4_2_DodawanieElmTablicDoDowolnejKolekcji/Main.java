package UTP.w4_2_DodawanieElmTablicDoDowolnejKolekcji;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Integer[] a1 = {1, 4, 7};
        Integer[] a2 = {11, 14, 7};

        Set<Integer> set = new HashSet<>();
        fillCollectionFromArrays(set, a1, a2);

        System.out.println(set);

        String[] stab = {"A", "B", "C", "A"};
        Set<String> set2 = new HashSet<>();
        Collections.addAll(set2, stab);
        System.out.println(set2);

        Collections.addAll(set2,"Z", "X", "Y");
        System.out.println(set2);

        set2.add("ppp");
        System.out.println(set2);

        Person [] p  = {
                    new Person("Jan", "As", 20, 1),
                    new Person("Tom", "Bas", 20, 1),
                    new Person("Tom", "Bas", 30, 2),
                    new Person("Tom", "Bas", 30, 3),
        };

        List<Person> list = new ArrayList<>();
        Collections.addAll(list, p);

        System.out.println(list);
        list.remove(p[p.length-1]);
        System.out.println(list);

    }


    public static <T> void fillCollectionFromArrays(Collection<T> c, T[]... arrays) {
        for (T[] arr : arrays) {
            for (T elt : arr)
                c.add(elt);
        }

    }

}
