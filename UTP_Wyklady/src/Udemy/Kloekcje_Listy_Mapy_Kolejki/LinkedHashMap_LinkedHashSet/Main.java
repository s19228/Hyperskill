package Udemy.Kloekcje_Listy_Mapy_Kolejki.LinkedHashMap_LinkedHashSet;


import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

/*
        Piesek p1 = new Piesek("max", "owczarek", 1);
        Piesek p2 = new Piesek("loco", "sanojec", 5);
        Piesek p3 = new Piesek("franco", "samojeb", 3);

        List<Piesek> listaPieselow = new ArrayList<>();
        listaPieselow.add(p1);
        listaPieselow.add(p2);
        listaPieselow.add(p3);

        System.out.println(listaPieselow);


        Set <Piesek> set = new HashSet();
        set.addAll(listaPieselow);

        set.stream().map(o -> o.imie.toUpperCase()).sorted().forEach(System.out:: println);
*/

        LinkedHashMap<Integer, String> mapa = new LinkedHashMap<>(); //HashMap

        Pracownik pracownicy[] = {
                new Pracownik("Jan"),
                new Pracownik("Andrzej"),
                new Pracownik("Maria"),
                new Pracownik("Zofia"),
                new Pracownik("Bogdan"),
                new Pracownik("Lucja"),
                new Pracownik("Konstytucja"),
                new Pracownik("Jaroslaw"),
                new Pracownik("Bożena"),
                new Pracownik("Aniela"),
                new Pracownik("Gabriela"),
                new Pracownik("Gustawa"),
                new Pracownik("Krzysztofa"),
                new Pracownik("Janusz"),
                new Pracownik("Wiesław"),
                new Pracownik("Jan"),
                new Pracownik("Andrzej"),
                new Pracownik("Maria"),
                new Pracownik("Zofia"),
                new Pracownik("Bogdan"),
                new Pracownik("Lucja"),
                new Pracownik("Konstytucja"),
                new Pracownik("Jaroslaw"),
                new Pracownik("Bożena"),
                new Pracownik("Aniela"),
                new Pracownik("Gabriela"),
                new Pracownik("Gustawa"),
                new Pracownik("Krzysztofa"),
                new Pracownik("Janusz"),
                new Pracownik("Wiesław")
        };

        for (Pracownik p : pracownicy)
            mapa.put(p.getID(), p.getImie());

        System.out.println(mapa);

        mapa.remove(3);
        mapa.put(4, "Edyta");
        mapa.put(3, "Mariola");

        System.out.println(mapa);

        //*** WIDOKI MAPY ***//

        for (Map.Entry<Integer, String> wpis : mapa.entrySet()) {
            System.out.println(wpis.getKey());
            System.out.println(wpis.getValue());
        }


        //*** SUB MAPY i SUB ZBIORY ***//

        //Map <Integer, Pracownik> submapa = mapa.subMap...

        Map <Integer, Pracownik> posortowanaMapa = new TreeMap<Integer, Pracownik>((Comparator<? super Integer>) mapa);
        //Map <Integer, Pracownik> submapa = posortowanaMapa.submap... kurwa dlaczego nie działasz?








    }

}
