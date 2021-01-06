 /**
 * @author Gryka Konrad S19228
 */

package zad3;

 import java.io.*;
 import java.util.Arrays;
 import java.util.Collections;
 import java.util.List;
 import java.util.Map;
 import java.util.stream.IntStream;

 import static java.util.stream.Collectors.groupingBy;
 import static java.util.stream.Collectors.toMap;

 public class Main {

    public static void main(String[] args) {

        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(new File("words.txt"))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            e.getMessage();
            System.out.println("There is no such file");
        }

        assert in != null;
        Map<String, List<String>> anagrams = in
                .lines()
                .sorted()
                .distinct()
                .collect(groupingBy(s -> {
                    return sort(s);
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

        for (Map.Entry<String, List<String>> entry : Collections.unmodifiableSet(map.entrySet())) {
            List<String> v = entry.getValue();
            System.out.print(v.get(0));
            IntStream.range(1, v.size())
                    .mapToObj(i -> v.get(i) + " ")
                    .forEachOrdered(System.out::print);
            System.out.println();
        }
    }

    public static String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
