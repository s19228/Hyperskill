package Udemy.Kloekcje_Listy_Mapy_Kolejki.LinkedList_czyli_ListaPowiazana;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> listaPowiazana = new LinkedList<>();

        listaPowiazana.add("lala1");
        listaPowiazana.add("lala2");
        listaPowiazana.add("lala3");
        listaPowiazana.add("lala4");

        pokazLinkedListe(listaPowiazana);

        wypiszElementyListy(listaPowiazana);

        Iterator<String> iter = listaPowiazana.iterator();
        iter.next();
        iter.remove();

        wypiszElementyListy(listaPowiazana);

        //lepszy iterator z wieksza iloscią metod
        //to jest interfejs!! stąd implementacja jak niżej

        ListIterator<String> iter2 = listaPowiazana.listIterator(listaPowiazana.size());

        while (iter2.hasPrevious())
            System.out.println(iter2.previous());

        while (iter2.hasNext())
            iter2.set("lalala");

        wypiszElementyListy(listaPowiazana);

    }

    public static void wypiszElementyListy (LinkedList<?> lista){

        System.out.println("********************************");
        Iterator iteratorListy = lista.iterator();
        while (iteratorListy.hasNext())
            System.out.println(iteratorListy.next());
        System.out.println("********************************");
        System.out.println();

    }

    public static void pokazLinkedListe(LinkedList<? extends Object> list){
        System.out.println("---------------------------------------");
        for ( Object x : list)
            System.out.println(x);
        System.out.println("---------------------------------------");
        System.out.println();
    }


}
