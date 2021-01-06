package UTP.w5_3_Generatory;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Stream.generate(Word::new)
                .filter(w -> w.size() >= 5)
                .limit(5)
                .forEach(System.out::println);

        // Liczby pseudolosowe lotto:

        String res = new Random()
                .ints(1, 50)
                .distinct()
                .limit(6)
                .mapToObj(String::valueOf)
                .sorted(Comparator.comparingInt(Integer::valueOf))
                .collect(Collectors.joining(", "));

        System.out.println(res);

        // Ciąg gemoetryczny o ilorazie 2

        List<Integer> l = Stream.iterate(1, n -> n *2).limit(31).collect(Collectors.toList());
        System.out.println(l);


    }

}
