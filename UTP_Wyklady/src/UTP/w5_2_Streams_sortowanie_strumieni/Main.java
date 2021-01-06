package UTP.w5_2_Streams_sortowanie_strumieni;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Path p = Paths.get("informatyka.txt");
        Stream<String> sf = Files.lines(p);
        List<Country> clist = sf.map(Country::new).collect(toList());

        //donaleźć 5 najmniejszych panstw na swiecie

        Comparator<Country> byArea = Comparator.comparing(Country::getArea);

        clist.stream()
                .filter(c -> c.getArea() != null)
                .filter(c -> c.getArea() > 0.0001)
                .sorted(byArea).limit(5)
                .forEach(c -> System.out.println(c.getName() + ", "));

        // Metody min i max które zwracają element strumienia w postaci OPTIONAL

        Country biegu = clist.stream()
                .filter(c -> c.getArea() != null && c.getCont().equals("Europe")).max(byArea).orElse(null);
        System.out.println(biegu);

        Country minBiegu = clist.stream()
                .filter(c -> c.getArea() != null && c.getCont().equals("Asia")).min(byArea).orElse(null);
        System.out.println(minBiegu);

        //Redukcja

        /*
        Metoda reduce (init, oper) działa w następujący sposób:

        inicjalnie ustawia wynik na podaną wartosć init:
        wynik = init

        poczym sortuje dany operator dla wszystkich elementów strumienia (elt), za każdym razem zmieniając wartość zmiennej wynik:
        wynik = op.apply(wynik, elt)
         */

        //Zsumować ludność krajów Europy:

        double popEU = clist.stream()
                .filter(c -> c.getCont().equals("Europe"))
                .map(Country::getPopul)
                .reduce(0.0, (n1, n2) -> n1 + n2);
        System.out.println("Liczebność europy wynosi: " + popEU);

        /*to samo można uzyskać inaczej, ale sumowanie moze być zrównoleglone jeżeli użyjemy paralleStream

        popEU = 0;

        for (kraj : krrajeEuropy)
            popEU += kraj.getPopul();
        */

        popEU = clist.parallelStream()
                .filter(c -> c.getCont().equals("Europe"))
                .map(Country::getPopul)
                .reduce(0.0, (n1, n2) -> n1 + n2);
        System.out.println("Liczebność europy wynosi: " + popEU);

        //Redukcje na strimieniach licbowych

        //łatwe sumowanie
        popEU = clist.stream()
                .filter(c -> c.getContCode().equals("EU"))
                .mapToDouble(Country::getPopul)
                .sum();
        System.out.println("Liczebność Europy wynosi: " + popEU);

        //średnia

        double avg = 0.0;
        avg = clist.stream()
                .filter(c -> c.getContCode().equals("EU"))
                .mapToDouble(Country::getPopul)
                .average()
                .orElse(0);
        System.out.println("Liczebność Europy, średnio na kraj wynosi: " + popEU);

        //Collect i kolektor
        //Inna metoda redukcji - collect(..) służy do akumuloania elementów strumieni do zmodyfikowanych kontenerów takich jak kolekcje, mapy, bufory znakowe

        /*
        Collectors dostarcza wielu gotowych kollektorów
        toList();
        toSet()
        toCollection(Supplier s) - tworzy dowolną kolekcję s jest lambdą do tworzenia nowej kolekcji (col :: new)
         */


        List<String> words = Arrays.asList("pies", "Ala", "kot", "Ala", "pies");

        Set<String> wset = words.stream().collect(Collectors.toSet());
        System.out.println(wset);

        wset.stream().collect(Collectors.toCollection(TreeSet::new));
        System.out.println(wset);

        //KOlektory budujące mapy - groupingBy();

        Map<String, List<Country>> contMap;

        contMap = clist.stream()
                .collect(groupingBy(Country::getContCode));


        contMap.forEach((cont, cclist) -> System.out.println(cont + " " + cclist.size()));

        //Metoda Collectors.grupingBy ma jako argument funkcjię zwracającą klucz w mapie, wynikający z przetworzenia kolejnego elementu strumienia
        //(w tym przypadku tym kluczem będzie wynik funkcji get contCode, czyli kod kontynentu)
        //Elementy strumienia mające ten sam klucz (tu: kod kontynentu) zostaną dodane do listy pod tym kluczem.

        /*
        Metoda Collectors.toMap() jej arg są dwie funkcje , piperwsza przekształca element strumienia w klucz mapy
        druga w wartość pod tym kluczem
         */

        Map<String, Double> popMap = clist.stream()
                .collect(toMap(Country::getIso2, Country::getPopul));

        /*
        Strunienie w strumieniach
         */
        Map<String, Double> nsumPop = clist.stream()
                .filter(c -> c.getNeighbours() != null)
                .collect(toMap(
                        c -> c.getName(),
                        c -> c.getNeighbours()
                                .stream()
                                .filter(nc -> popMap.get(nc) != null)
                                .mapToDouble(popMap::get).sum()
                ));


    }

}
