/**
 * @author Gryka Konrad S19228
 */

package zad1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class Anagrams {

    public HashMap<String, List<String>> listWithAnagrams = new HashMap<>();
    public List<String> wordsToFind = new ArrayList<>();

    public static String sortCharacters(String in) {
        char[] out = in.toCharArray();
        Arrays.sort(out);
        return new String(out);
    }

    public Anagrams(String in) {
        Stream<String> stream = null;
        try {
            stream = Files.lines(Paths.get(in));
        } catch (IOException e) {
            e.printStackTrace();
            e.getMessage();
        }
        assert stream != null;
        stream.forEach(s -> {
            wordsToFind.addAll(Arrays.asList(s.split("\\s+")));
        });

        for (String s : wordsToFind) {
            String myNewString = sortCharacters(s);
            if (listWithAnagrams.containsKey(myNewString)) {
                listWithAnagrams.get(myNewString).add(s);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(s);
                listWithAnagrams.put(myNewString, newList);
            }
        }
    }

    String getAnagramsFor(String in) {
        String key = sortCharacters(in);
        String anagramsFlat = "";
        if (listWithAnagrams.containsKey(key)) {
            anagramsFlat = listWithAnagrams.get(key)
                    .stream()
                    .filter(a -> !a.equals(in))
                    .collect(Collectors.joining(", "));
        }
        return in + ": [" + anagramsFlat + "]";
    }

    public Iterable<? extends List<String>> getSortedByAnQty() {
        return listWithAnagrams.entrySet().stream()
                .sorted((o1, o2) -> {
                    int o1s = o1.getValue().size();
                    int o2s = o2.getValue().size();
                    return Integer.compare(o2s, o1s);
                })
                .collect(toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new
                )).values();
    }
}