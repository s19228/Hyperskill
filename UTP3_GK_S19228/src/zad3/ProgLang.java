package zad3;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.nio.file.Files;

public class ProgLang {

    private final Map<String, List<String>> mapOfLanguages = new HashMap<>();
    private final Map<String, List<String>> mapOfProgramers = new HashMap<>();

    public ProgLang(String s) {
        try {
            Files.readAllLines(Paths.get(s)).stream().map(line -> {
                return line.split("\t");
            }).forEach(in -> {
                String langOfProg = in[0];
                List<String> namesOfPrgrammers = new ArrayList<>(Arrays.asList(in).subList(1, in.length));
                mapOfLanguages.put(langOfProg, namesOfPrgrammers);
                namesOfPrgrammers.forEach(name -> {
                    if (!getMapOfProgramers().containsKey(name)) {
                        List<String> languages = new ArrayList<>();
                        languages.add(langOfProg);
                        getMapOfProgramers().put(name, languages);
                    } else {
                        getMapOfProgramers().get(name).add(langOfProg);
                    }
                });
            });
        } catch (IOException e) {
            e.printStackTrace();
            e.getMessage();
            System.out.println("Something goes wrong...");
        }
    }

    private Map<String, List<String>> getMapOfProgramers() {
        return mapOfProgramers;
    }

    public Map<String, List<String>> getLangsMap() {
        return mapOfLanguages;
    }

    public Map<String, List<String>> getProgsMap() {
        return getMapOfProgramers();
    }

    public Map<String, List<String>> getLangsMapSortedByNumOfProgs() {
        return sortByNumber(mapOfLanguages);
    }

    private Map<String, List<String>> sortByNumber(Map<String, List<String>> enyMap) {
        return sort(enyMap, (e1, e2) -> {
            int i = Integer.compare(e1.getValue().size(), e2.getValue().size()) * -1;
            if (i == 0) {
                return e1.getKey().compareToIgnoreCase(e2.getKey());
            } else return i;
        });
    }

    public static <T, K> Map<T, List<K>> sort(Map<T, List<K>> map, Comparator<Map.Entry<T, List<K>>> comparator) {
        LinkedHashMap<T, List<K>> sortedMap = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted(comparator)
                .forEach(entry -> sortedMap.put(entry.getKey(), entry.getValue()));
        return sortedMap;
    }

    public Map<String, List<String>> getProgsMapSortedByNumOfLangs() {
        return sortByNumber(getMapOfProgramers());
    }

    public Map<String, List<String>> getProgsMapForNumOfLangsGreaterThan(int i) {
        return map(getMapOfProgramers(), e -> e.getValue().size() > i);
    }

    public Map <String, List<String>> map
            (Map<String, List<String>> map, Predicate<Map.Entry<String, List<String>>> predicate) {

        return map.entrySet().stream()
                .filter(predicate)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (o1, o2) -> o1, LinkedHashMap::new));
    }
}
