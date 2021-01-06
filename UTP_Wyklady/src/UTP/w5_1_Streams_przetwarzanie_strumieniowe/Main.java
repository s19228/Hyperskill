package UTP.w5_1_Streams_przetwarzanie_strumieniowe;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) throws IOException {

        Path p = Paths.get("informatyka.txt");
        Stream<String> sf = Files.lines(p);
        List<Country> clist = sf.map(Country::new).collect(toList());

        //donaleźć kaj zaczynający sie na "B"

        Optional<String> first = clist.stream().map(Country::getName).filter(s -> s.startsWith("B")).findFirst();
        String nazwa = first.get();

        //Optional moze zgłosić błąd lepiej zapisać to w ten sposób:

        Optional<String> first2 = clist.stream().map(Country::getName).filter(e -> e.startsWith("X")).findFirst();
        String nazwa2 = first2.orElse("Nie znaleziono takiego kraju");

        clist.stream().forEach((Country c) -> {
            c.getPopDensity();
            switch (c.getContCode()) {
                case "AF":
                    c.setConr("Africa");
                    break;
                case "AN":
                    c.setConr("Antartica");
                    break;
                default:
                    System.out.println("Nie ma takiego kontynentu");
                    break;
            }
        });

        //ForEachOrdered - wyprowadzi dane o krajach w kolejności dodania do listy krajów
        clist.stream().forEachOrdered(System.out::println);

        //clist.stream().forEachOrdered(Consumer..);
        //clist.stream().forEach(Consumer..);
        // dla jednego i drugiego musi być consumer





    }

    //leniwość i skracanie "SHORT_CURCUIT"
    static String firstWithPrefix(Stream<Country> str, String p) {
        return str.map(Country::getName).filter(s -> s.startsWith(p)).findFirst().orElse("Nie ma takiego kraju" + p);
    }

}
