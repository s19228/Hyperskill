package Udemy.Kloekcje_Listy_Mapy_Kolejki.Sortowanie_TreeSet;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        Set<Element> set = new TreeSet<>(
                (o1, o2) -> {
                    String opisO1 = o1.pobierzOpis();
                    String opisO2 = o2.pobierzOpis();

                    return opisO1.compareTo(opisO2);
                }
        );

        set.add(new Element(1245, "opis"));
        set.add(new Element(5, "aopis"));
        set.add(new Element(445,"zopis"));

        Iterator<Element> iter = set.iterator();
        while(iter.hasNext())
            System.out.println(iter.next().pobierzOpis());

        System.out.println("Wielkość zbioru: "+set.size());

        Set <Element> set2 = new TreeSet<>(
                (o1, o2) -> {
                    if (o1.getWartosc() == o2.getWartosc())
                        return 0;
                    else if (o1.getWartosc() > o2.getWartosc())
                        return 1;
                    else
                        return -1;
                }
        );
        set2.addAll(set);

        System.out.print(set2);



    }

}
