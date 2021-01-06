package UTP.w4_5_Inne_metody_Comparatora;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Employee> elist = Arrays.asList(
                new Employee("Jan", "Kowalski", 3500),
                new Employee("Jan", "Malinowski", 3500),
                new Employee("Jan", "Kowalski", 1400),
                new Employee("Admam", "Kowalski", 5700),
                new Employee("Admam", "Abacki", 5700)
        );

        // static comparing(func) - zwraca komparator porównujący obiekty wg wyników podanej funkcji
        elist.sort(Comparator.comparing(e -> e.getSalary()));
        System.out.println(elist);

        elist.sort(Comparator.comparing(Employee::getSalary));
        System.out.println(elist);

        //  domyślna thenComparin(Comparator) - łączy komparatory ten i podany jako argument, umożiwając porządkowanie wg kolejnych kryteriów
        elist.sort(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getLastName));
        System.out.println(elist);

        // thenComparnig(func) - j.w. ale drugie krytrium opiera się na wynikach zastosowania podanej funkcji wobec porównywanych elementów zestawu

        elist.sort(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getFirstName).thenComparing(Employee::getLastName));
        System.out.println(elist);





    }


}
