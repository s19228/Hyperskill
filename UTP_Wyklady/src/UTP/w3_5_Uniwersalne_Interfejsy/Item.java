package UTP.w3_5_Uniwersalne_Interfejsy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class Item <T>{

    List<T> list;

    public Item(){
        ItemGenerator itg = ItemGenerator.INSTANCE;
    }


    /*
    W kolekcji trg wyszukuje wszystkie elementy spelniajace warunek okreslony prze predykat p i zwraca liste tych elementow
    */

    List<T> findAll(Collection<T> src, Predicate<T> p) {
        List<T> trg = new ArrayList<>();
        for (T e : src)
            if (p.test(e)) trg.add(e);
        return trg;

    }
}
