package UTP.w3_2_Lambda_Wyrazenia;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String[] st = {"A", "B", "C"};
        Integer[] integers = {1,2,3,4,5,6};

        new ScopeLambda().defineAndDoWork(st);
        System.out.println(Arrays.toString(st));

        Worker w = new Worker() {
            int i = 7;
            int k = 10;
            @Override
            public void work() {
                System.out.println(k);
                int i = 9;
                System.out.println(this.getClass());
            }
        };

        w.work();

        String[] s2 = new String[]{Arrays.toString(integers)};

        new ScopeLambda().defineAndDoWork(s2);
        System.out.println(Arrays.toString(s2));

        System.out.println("===============================================================");

        List<String> s = Arrays.asList("pies", "kot", "ryba");
        List<String> sn = Arrays.asList("111", "222");

        List out1 = MetRef.create(s, e -> e.toUpperCase());
        System.out.println(out1);
        // zapisy rownowazne
        List out11 = MetRef.create(s, String::toUpperCase);
        System.out.println(out11);

        String text = "pies i kot sa w domu, a ryba plywa";

        List out2 = MetRef.create(s, e -> text.indexOf(e));
        System.out.println(out2);
        // zapisy rownowazne
        List out22 = MetRef.create(s, text :: indexOf);
        System.out.println(out22);

        List out3 = MetRef.create(sn, e -> Integer.parseInt(e));
        System.out.println(out3);
        // zapisy rownowazne
        List out32 = MetRef.create(sn, Integer::parseInt);
        System.out.println(out32);

        List out4 = MetRef.create(s, e -> new Animal(e));
        System.out.println(out4);
        // zapisy rownowazne
        List out42 = MetRef.create(s, Animal::new);
        System.out.println(out42);

        System.out.println("===============================================================");

        List<String> word = Arrays.asList("alabama", "kociokwik");
        List<Integer> pos = Arrays.asList(1, 5);

        List out5 = MetRef.create(word, pos, (e1, e2) -> e1.substring(e2));
        System.out.println(out5);
        // zapisy rownowazne
        List out52 = MetRef.create(word, pos, String::substring);
        System.out.println(out52);







    }

}
