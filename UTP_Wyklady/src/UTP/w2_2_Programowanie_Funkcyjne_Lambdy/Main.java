package UTP.w2_2_Programowanie_Funkcyjne_Lambdy;

import UTP.w2_1_Progamowanie_Funkcyjne.Filter;
import UTP.w2_1_Progamowanie_Funkcyjne.TestClass;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Integer> num = Arrays.asList(1, 3, 5, 10, 9, 12, 7);
        List<String> txt = Arrays.asList("ala", "ma", "kotka", "ola", "ma", "pieska");

        List<Employee> emp = Arrays.asList(
                new Employee("Kowal", "Jan", 34, 3400.00),
                new Employee("As", "Ala", 27, 4100.00),
                new Employee("Kot", "Zofia", 33, 3700.00),
                new Employee("Puchacz", "Jan", 41, 3600.00)
        );

        System.out.println(
                TestClass.create(num, n -> n % 2 == 0, n -> n * 100));

        System.out.println(
                TestClass.create(txt, n -> n.length() > 2, n -> n.toUpperCase())
        );

        System.out.println(
                TestClass.create(txt, s -> s.startsWith("m"), s -> s.toUpperCase() + " " + s.length())
        );

        List<Employee> doPodwyzki = TestClass.create(emp, e -> e.getSalary() < 3650, e -> e);
        //trzeciego parametru nie wykorzystujemy - zostawiamy w niezmienionej postaci
        System.out.println("Podwyzki powinni uzyskac: ");
        System.out.println(doPodwyzki);

        //metoda create jest tak napisana ze nie musi zwracac tego samego typu co Lista źródłowa

        List<Double> sal = TestClass.create(emp, e -> true, e -> e.getSalary());
        System.out.println(sal);

        //***********************************************************************************************
        /*
            REFERENCJE DO METOD:

            Zapis e -> e.getSalary()  jest równoważny Emploee::getSalary
        */
        //***********************************************************************************************

        List<Double> sal2 = TestClass.create(emp, e -> true, Employee::getSalary);
        System.out.println(sal2);

        change(emp, e -> e.getSalary() < 3650.00, e -> e.setSalary(e.getSalary() + 4000));

        for (Employee e : emp)
            System.out.println(e + " " + e.getSalary());

        List<Integer> src = Arrays.asList(5, 72, 10, 11, 9);
        List<Integer> target = src.stream().
                filter(n -> n < 10).
                map(n -> n * n).
                collect(Collectors.toList());

        for (Integer x : target)
            System.out.print(x);

        System.out.println();

         num = Arrays.asList(1,3,5,10,9,12,7);
         List<Integer> out = num.stream().
                 map(n -> n*n).
                 filter(n -> n>80).
                 collect(Collectors.toList());

         for (Integer x : out)
            System.out.print(x + " ");

        System.out.println();

        List<String> snum = Arrays.asList("7", "20", "160", "777", "822");
        snum = snum.stream().filter(s -> s.length() ==3).
                map(s -> Integer.parseInt(s)).
                filter(n -> n%2 ==0).
                map(n -> String.valueOf(n)).
                collect(Collectors.toList());

        for (String s : snum)
            System.out.print(s +" ");

        // uczycir metody forEach dla Listy

       emp.stream().
               filter(e -> e.getAge() > 30 && e.getSalary() <4000).
               forEach( employee -> employee.setSalary(employee.getSalary()*1.50));

       // i wyslietlenie za pomoca for each

        emp.stream().forEach( e -> System.out.printf("%s %.0f\n", e,  e.getSalary()));


        // metoda reduce

//        part = init
//        dla_kazdego_elementu_strumienia {
//            part = func.apply(part, next)
//        }
//        return part


        Double sumOfSalarys = emp.stream().
                map( Employee::getSalary).
                reduce(0.0,(part, next) -> part + next);

        System.out.println(sumOfSalarys);


    }

    public static <S> void change(List<S> src, Filter<S> filter, Modifier<S> mod) {
        for (S elm : src) {
            if (filter.test(elm)) {
                mod.modify(elm);
            }
        }
    }


}
