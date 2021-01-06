package UTP.w3_4_CallAble;

import java.time.LocalDate;
import java.util.concurrent.*;
import java.util.function.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        String s = "Ala ma kota i psa";
        ExecutorService ex = Executors.newCachedThreadPool();

        Future<String> task = ex.submit(() -> {
            char[] src = s.toCharArray();
            char[] trg = new char[src.length];
            for (int i = src.length - 1, j = 0; i >= 0; i--, j++) {
                trg[j] = src[i];
                System.out.println(trg[j]);
                Thread.sleep(10);
            }
            return new String();
        });

        String res = task.get();
        System.out.println(res);


        //Gotowe interfejsy java.utill

        /*
            Predicate<T>
            abstrakcyjna metoda test - testuje warunki np. < 10 itp
         */

        Integer i = 12;
        Predicate<Integer> pre = (e -> e >= 10);
        boolean wynik = pre.test(i);
        System.out.println(wynik);

        /*
            Function <S,T>
            abstrakcyjna metoda T aply(S v) - transformuje wartości typu S na T (Funkcja z jednym arcumentem)
         */



        Function<Integer, String> func = (Object::toString);
        String intToString = func.apply(i);
        System.out.println(intToString);

        /*
            UnaryOperator<T>
            abstrakcyjna metoda T apply - sluzy do operowania na v ze zwrotem wyniku tego samego typu
         */

        UnaryOperator<Integer> unOp = (e -> e + 2);
        Integer i2 = unOp.apply(i);
        System.out.println(i2);

        /*
            Supplier <T>
            abstrakcyjna metoda T get() - dostarcza obiektów typu T
            odpowiada lambdzie bez argrumentu
         */

        Supplier<String> dzien = () -> String.valueOf(LocalDate.now());
        String pokaDzien = dzien.get();
        System.out.println(pokaDzien);

        /*
            Consumer <T>
            abs metoda void accept (T v) - wykonywanie operacji na przekazanym obiekcie bez zwracania wyniku!! omg!
         */

        Consumer<Integer> cons = (e -> System.out.println("costam"));

        cons.accept(i2);

        /*
            BiPredicate <U, V>
            abs metoda boolean test (U u, V v) - testowanie warunkow z dwoma argumentami i wynikiem boolean
            np (str, n -> str.length > n)
         */

        BiPredicate<String, Integer> biPre = ((str, n) -> str.length() > n);
        boolean czyDluzszenisz = biPre.test(pokaDzien, i2);
        System.out.println(czyDluzszenisz);

        if (czyDluzszenisz == false)
            System.out.println(pokaDzien + " nie ma wiecej niz " + i2 + " liter");
        else
            System.out.println(pokaDzien + " ma wiecej niz " + i2 + " liter");

        /*
            BiFunction<U, V, R>
            abs metoda R apply (U u, V v) - funkccja z dowma argumentami, ewentualnie roznych typow
            argumenty typu U V - wynik typu R
            np (xs, i) -> xs + i*2
         */
        /*
            BinaryOperator<T>
            abstrakcyjna metoda T apply - operator z dwoma argumentami tego samego typu i wynikiem tego samego typu
            np (s1, s2 - > s1 + s2)
         */
       /*
            BiConsumer <U, V>
            abs metoda void accept (U u, V v) - konsumer z dwoma argumentami
            (item, n) -> item.setPrice(n)...

        */

        // metoda show pokaże wysztko nie trzeba sout!!!!!!!!!!!!!!!!!!!!!!

        //show(pre.test())...

        System.out.println("Uwrorzenie show dla wszystich typow danych?");

        Predicate<Integer> pre2 = (e -> e >= 10);
        show(pre2.test(10));

        UnaryOperator<String> uop2 = st -> st + 10;
        show(uop2.apply("Katakumby "));


        System.exit(0);
    }

    static void show(Object o){
        System.out.println(o.toString());
    }


}
