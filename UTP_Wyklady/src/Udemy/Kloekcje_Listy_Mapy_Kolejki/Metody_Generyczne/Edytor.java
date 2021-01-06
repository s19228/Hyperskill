package Udemy.Kloekcje_Listy_Mapy_Kolejki.Metody_Generyczne;

import java.util.Collection;
import java.util.List;

public class Edytor {

    public static void wypisz(List<? extends Figura> lista) {
        for (Figura x : lista)
            System.out.println(x.pobierzNazwe());

        // lista.add(new Kolo()) tego nie można dodać mozna dodać null
        lista.add(null);

        System.out.println("*********************************");

        for (Figura x : lista) {
            if (x == null) {
                System.out.println("null");
                break;
            }
            System.out.println(x.pobierzNazwe());
        }
    }

    public static <T extends Figura> void wypisz2(List<T> lista) {
        for (T x : lista)
            System.out.println(x.pobierzNazwe());

        lista.add((T) new Kolo());
        lista.add((T) new Kwadrat());


        System.out.println("*********************************");

        for (T x : lista) {
            if (x == null) {
                System.out.println("null");
                break;
            }
            System.out.println(x.pobierzNazwe());
        }
    }

    public static <T> void  przepiszTabliceDoKolekcji(T[] tab, Collection<T> c) {
        for(T o : tab){
            c.add(o);
        }
    }


    public static void przepiszTabliceDoKolekcji(Figura[] figury, Collection<Number> cn) {
    }
}
