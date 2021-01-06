package UTP.w5_4_Strumienie_Rownolegle;

import javax.sound.midi.Patch;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        eval("Makarą");


        /*
        Strumienie sekwencyjne vs równoległe


        List<String> list = Arrays.asList("A", "B", "C", "D"); //, "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U", "W", "X", "Y", "Z");
        System.out.println("Liczba wątków: " + Runtime.getRuntime().availableProcessors());

        System.out.println("Strumień sekwencyjny");
        double start = System.currentTimeMillis();
        list.stream()
                .map(s -> eval(s))
                .forEach(System.out::println);
        System.out.printf("Czas w sek.: %.2fn\n", (System.currentTimeMillis() - start)/1000);

        System.out.println("Strumień równolegly");
        double start2 = System.currentTimeMillis();
        list.parallelStream()
                .map(s -> eval(s))
                .forEach(System.out::println);
        System.out.printf("Czas w sek.: %.2fn\n", (System.currentTimeMillis() - start2)/1000);

        // ale można np najpierw sekwencyjnie a później równolegle, albo na odwrót

        List<String> slowa = Arrays.asList("pies", "Ala", "kot", "Ala", "pies");
        Set<String> str = slowa.stream().collect(Collectors.toSet());

        str.parallelStream()
                .filter(e -> e.startsWith("k"))
                .map(String::length)
                .sequential()
                .forEach(System.out::println);

        System.out.println(str);
 */
        // metoda walk

        Predicate<Path> isFile = Files ::isRegularFile;
        Predicate<Path> isJava = p -> p.toString().endsWith("java");

        try {
            Files.walk(Paths.get("C:\\Users\\conra\\IdeaProjects"))
            .filter(isFile.and(isJava))
                    .map(Path::getFileName)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // metosa splitAsStream - np. do zsumowania liczb z pliku

        String cont = null;
        try {
            cont = Files.lines(Paths.get("liczby.txt"))
                    .collect(Collectors.joining(""));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Pattern p = Pattern.compile("\\D+");
        long sum = p.splitAsStream(cont)
                .filter(s -> !s.equals("")) // specyfika split
                .filter(s -> s.length() < 9) // nie za duże te liczby
                .mapToInt(Integer::parseInt)
                .sum();

        System.out.println("Suma liczb  z pliku " + Paths.get("liczby.txt").toAbsolutePath() + " " + sum);



    }

    static String eval(String s) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            return "Interrupted";
        }
        return "Result for: " + s + " is ready";
    }
}
