import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        Path p = Paths.get(System.getProperty("user.home") + "\\AllCountries.tsv");
        Stream<String> sf = Files.lines(p);

        List<Country> clist = sf.map(Country :: new)
                .collect(Collectors.toList());
        sf.close();

        System.out.println(clist);

        Optional<String> first = clist.stream()
                .map(Country::getName)
                .filter(e -> e.startsWith("B"))
                .findFirst();

        String nazwa = first.get();
        System.out.println(nazwa);


    }
}
