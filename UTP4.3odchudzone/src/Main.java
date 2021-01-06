import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File("f"))));
        Map<String, List<String>> anagrams = in
                .lines()
                .sorted()
                .distinct()
                .collect(groupingBy(s -> {
                    return s(s);
                }));

        final int[] index = {0};

        anagrams.forEach((k, v) -> {
            if (index[0] >= v.size()) {
                return;
            }
            index[0] = v.size();
        });

        Map<String, List<String>> map = anagrams.entrySet()
                .stream()
                .filter(v -> index[0] == v.getValue().size()
                )
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));

        for (Map.Entry<String, List<String>> m : Collections.unmodifiableSet(map.entrySet())) {
            List<String> v = m.getValue();
            System.out.print(v.get(0));
            IntStream.range(1, v.size())
                    .mapToObj(i -> v.get(i)+ " ")
                    .forEachOrdered(System.out::print);
            System.out.println();
        }
    }

    public static String s(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}
