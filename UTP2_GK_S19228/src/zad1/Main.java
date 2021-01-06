/**
 * @author Gryka Konrad S19228
 */

package zad1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        /*<--
         *  definicja operacji / funkcji w postaci lambda-wyrażeń:
         *  - flines - zwraca listę wierszy z pliku tekstowego
         *  - join - łączy napisy z listy (zwraca napis połączonych ze sobą elementów listy napisów)
         *  - collectInts - zwraca listę liczb całkowitych zawartych w napisie
         *  - sum - zwraca sumę elmentów listy liczb całkowitych
         */

        Function<String, List<Integer>> collectInts = text -> {
            List<Integer> listOfInts = new ArrayList<>();
            for (String s : text.replaceAll("[^\\d ]", " ").trim().split(" ")) {
                if (s.length() > 0)
                    listOfInts.add(Integer.valueOf(s));
            }
            return listOfInts;
        };

        Function<List<Integer>, Integer> sum = ints -> (ints.stream().mapToInt(i -> i).sum());

        Function<List<String>, String> join = src -> String.join(" ", src);

        Function<String, List<String>> flines = (s -> {
            List<String> lines = new ArrayList<>();
            try (Stream<String> str = Files.lines(Paths.get(s))) {
                str.forEach(lines::add);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return lines;
        });

        String fname = System.getProperty("user.home") + "/LamComFile.txt";
        InputConverter<String> fileConv = new InputConverter<>(fname);

        List<String> lines = fileConv.convertBy(flines);
        String text = fileConv.convertBy(flines, join);
        List<Integer> ints = fileConv.convertBy(flines, join, collectInts);
        Integer sumints = fileConv.convertBy(flines, join, collectInts, sum);

        System.out.println(lines);
        System.out.println(text);
        System.out.println(ints);
        System.out.println(sumints);

        List<String> arglist = Arrays.asList();
        InputConverter<List<String>> slistConv = new InputConverter<>(arglist);
        sumints = slistConv.convertBy(join, collectInts, sum);
        System.out.println(sumints);

    }

}

/*
Dla następujących danych z pliku:

Cars:
- Fiat: 15, Ford: 20
- Opel: 8, Mitsubishi: 10

oraz  nastepujących argumentów wywołania metody main:

Warszawa 100 Kielce 200 Szczecin 300
program powinien wyprowadzić na konsolę:

[Cars:, - Fiat: 15, Ford: 20, - Opel: 8, Mitsubishi: 10]
Cars:- Fiat: 15, Ford: 20- Opel: 8, Mitsubishi: 10
[15, 20, 8, 10]
53
600

 */
