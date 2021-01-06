package GUI4;

import GUI3.AnimalComparator;
import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.util.*;

public class Main {

    public static void main(String[] args) {

/*        int[] tab = {1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        IntTester.printValidInts(tab, new IntTester() {
            @Override
            public boolean isValid(int x) {
                return x % 2 == 0;
            }
        });

        IntTester.printValidInts(tab, x -> x % 3 == 0);

        int[] arr = new int[25];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100) + 1;
        }

        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
        //System.out.println(Arrays.toString(arr));

        System.out.println("**************************");

        IntTester.printValidInts(arr, new IntTester() {
            @Override
            public boolean isValid(int x) {
                return x % 3 == 0 && x % 4 != 0;
            }
        });

        IntTester.printValidInts(arr, x -> x > 50);

        // w bardziej złożonych przypadkach wyrażenie lambda może po lewej stronie strzałki mieć argumenty wzięte w nawiasy ()
        // po prawej stronie natomiast znajdzie się normalne ciało metody w nawiasach {}
        IntTester.printValidInts(tab, (x) -> {
            for (int i = 2; i <= Math.sqrt(x); i++) {
                // jeżeli znalezliśmy dzielnik liczby, zwrócmy fałsz (bo liczba nie jest pierwsza)
                if (x % i == 0)
                    return false;
            }
            // jeżeli nie znalezliśmy dzielnika, zwrócmy prawdę (bo liczba musi być pierwsza)
            return true;
        });
        System.out.println("-----------------------------------");


        printValidInts(arr, (x, y) -> x+y > 100);

    }

    // interfejsy mogą mieć wypełnione kodem metody statyczne tylko
    static void printValidInts(int[] tab, IntPairTester tester) {
        for (int i =0; i<tab.length - 1; i++){
            if (tester.isValid(tab[i], tab[i+1]))
                System.out.print("[" + tab[i] + "; " + tab[i + 1] + "] ");
    }
        System.out.println();

*/

    Animal [] animals = new Animal[5];
    Animal slon = new Animal("Slon", 3500, 3);
    Animal zyrafa = new Animal("Zyrafa", 1500, 7);
    Animal lef = new Animal("Lef", 2000, 1);
    Animal jez = new Animal("Jez", 1, 0);
    Animal kon = new Animal("Kon", 1750, 2);
    animals[0] = slon;
    animals[1] = zyrafa;
    animals[2] = lef;
    animals[3] = jez;
    animals[4] = kon;


    System.out.println(Arrays.toString(animals));

    Arrays.sort(animals, new Comparator<Animal>() {
        @Override
        public int compare(Animal o1, Animal o2) {
            return Double.compare(o1.getWeight(), o2.getWeight());
        }
    });

    System.out.println(Arrays.toString(animals));

    // to samo co wyzej zapisane w mega ktotkiej i dziwnej formie??
    Arrays.sort(animals, Comparator.comparingInt(Animal::getHeight));

    System.out.println(Arrays.toString(animals));



        List<Integer> listOfInts = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            listOfInts.add((int)(Math.random()*100));
        }

        for (Integer x : listOfInts){
            System.out.print(x + ", ");
        }
        System.out.println();

        listOfInts.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        //listOfInts.sort((o1, o2) -> o1.compareTo(o2));
        //listOfInts.sort(Integer::compareTo);

        showMyList(listOfInts);

        System.out.println("***************************************");

        for ( Animal x : animals){
            System.out.print(x + ", ");
        }

        System.out.println();

        List<Animal> list = new ArrayList<>();
        list.add(new Animal("Elephant", 2500, 500));
        list.add(new Animal("Lion", 1.5, 150));
        list.add(new Animal("Sheep", 55, 50));
        list.add(new Animal("Cat", 0.5, 12));
        list.add(new Animal("Tiger", 1.5, 160));

        Iterator<Animal> iterator = list.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next() + " ");
        }
        System.out.println();

        list.sort(new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                if(Integer.compare(o1.getHeight(),o2.getHeight()) != 0)
                    return Integer.compare(o1.getHeight(),o2.getHeight());
                else if (Double.compare(o1.getWeight(),o2.getWeight()) != 0)
                    return Double.compare(o1.getWeight(), o2.getWeight());
                else
                    return o1.getName().compareTo(o2.getName());
            }
        });

//        list.sort((o1, o2) -> {
//            if(o1.getHeight() != o2.getHeight())
//                return Integer.compare(o1.getHeight(),o2.getHeight());
//            else if (Double.compare(o1.getWeight(),o2.getWeight()) != 0)
//                return Double.compare(o1.getWeight(), o2.getWeight());
//            else
//                return o1.getName().compareTo(o2.getName());
//        });

        showMyList(list);

        Collections.shuffle(list);


        showMyList(list);

        Collections.max(list, new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                return Double.compare(o1.getWeight(), o2.getWeight());
            }
        });

        // to samo co powyzej tylko z soutem
        System.out.println(Collections.max(list, Comparator.comparingDouble(Animal::getWeight)));

        System.out.println("*****************************************************");

        listOfInts.stream().forEach(i -> System.out.print(i + " "));
        System.out.println();

        listOfInts.stream().filter(i -> i%2 == 0).forEach(i -> System.out.print(i + " "));
        System.out.println();

        System.out.println(listOfInts.stream().filter(i -> i%2 == 0).count());


        for (Animal x : list){
            System.out.println(x + " ");
        }
        System.out.println(" ");


        list.stream().filter(i -> i.getWeight() >= 50).forEach( i -> System.out.println(i + " "));


        System.out.println(list.stream().filter(i -> i.getHeight() > 100).count());

        // strumień utworzony z elementów kolekcji może być również zamieniony na strumień elementów typu Integer lub Double
        // w tym celu konieczne jest użycie metody mapToInt lub mapToDouble z przekazaniem sposobu mapowania obiektu klasy na Integer lub Double
        // następnie możliwe jest np. zsumowanie wszystkich wartości Integer lub Double
        double animalWeightSum = list.stream().mapToDouble(x -> x.getWeight()).sum();
        System.out.println("Suma wag wszystkich kurwow to:" + animalWeightSum);





    }

    public static void showMyList(List list){
        for (Object x : list){
            System.out.print(x + ", ");
        }
        System.out.println();
    }

}

