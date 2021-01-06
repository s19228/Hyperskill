package UTP.w4_3_HashSet;

import java.text.Collator;
import java.util.*;

import static java.util.Collections.*;

public class Main {

    public static void main(String[] args) {

        Employee[] etab = {
                new Employee("Jan", "Malinowski", 1200),
                new Employee("Jan", "Kowalski", 1400),
                new Employee("Jan", "Kowalski", 1000)
        };

        // bez dubli w postaci Jana Kowalskiego
        Set<Employee> set = new HashSet<>();
        for (Employee e : etab) {
            set.add(e);
        }

        System.out.println(set);

        // bez dubli w postaci Jana Kowalskiego - w porządku w jamim zostali dodani
        Set<Employee> set2 = new LinkedHashSet<>();
        for (Employee e : etab)
            set2.add(e);

        System.out.println(set2);

        // TreeSet sluzy do uporzadkoawnia elementow zbioru
        Set<String> napisy = new TreeSet<>(Arrays.asList("x", "y", "a", "e", "i", "p", "t", "z"));
        Set<Integer> liczby = new TreeSet<>(Arrays.asList(12, 15, -5, -1, 0, 2, 5, 78));

        System.out.println(napisy + "\t" + liczby);

        // mozna posortowac sortem z Collections da te same wyniki
        List<Integer> listaLiczb = (Arrays.asList(12, 15, -5, -1, 0, 2, 5, 78));
        sort(listaLiczb);
        System.out.println(listaLiczb);

        List<Employee> eList = Arrays.asList(
                new Employee("Jan", "Malinowski", 1200),
                new Employee("Jan", "Kowalski", 1400),
                new Employee("Jan", "Kowalski", 1000));

        System.out.println("***");
        Collections.sort(eList);
        System.out.println(eList);

        // uporzadkujmy za pomoca comparatora po pensji

        Collections.sort(eList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o1.getSalary() - o2.getSalary());
            }
        });
        System.out.println(eList);

        //odwrocony porzadek
        Collections.sort(eList, Collections.reverseOrder());
        System.out.println("Odwrocony porzadek: " + eList);

        //Sortowanie polskich liter
        List<String> polskie = Arrays.asList("ą", "ę", "ó", "ć", "ś", "ż", "ź", "ł");
        Collections.sort(polskie);
        System.out.println("Posotrowane polskie: " + polskie);

        Collections.sort(polskie, Collator.getInstance(new Locale("pl")));
        System.out.println("Posotrowane polskie lepiej: " + polskie);

        // mozna to zapisac w jeszcze bardziej skroconej formie
        Collections.sort(eList, (e1, e2) -> (int) (e1.getSalary() - e2.getSalary()));


    }


}
