package GUI3;

import GUI3.ValueWrapper.LocalProvider;

import java.util.Arrays;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {


        String testString = "Ala ma chcice";
        Box box = new Box();
        box.setObject(testString);
        String newString = (String) box.getObject();
        System.out.println(newString);


        String testString2 = "Ala ma chcice";
        Box box2 = new Box();
        box.setObject(testString);

        //Integer testInteger = (Integer)box.getObject();
        Integer testInteger = 123;

        UpgradedBox upgBox = new UpgradedBox<Integer>();
        upgBox.setObject(testString);

        System.out.println(testInteger);

        UpgradedBox<String> box3 = new UpgradedBox<>();
        box2.setObject(testString);

        //String newString = box2.getObject();
        //Integer testInteger2 = box2.getObject();

        System.out.println(Utils.areEqual(box, box2));

        String[] subjectNames = {"Matematyka", "Informatyka", "Fizyka", "Chemia", "WF"};

        Student[] list = new Student[5];

        {
            list[0] = new Student("Johny", "Powalony", subjectNames.length);
            list[1] = new Student("Kajka", "Dupodajka", subjectNames.length);
            list[2] = new Student("Anka", "Nimfomanka", subjectNames.length);
            list[3] = new Student("Klara", "Obciagara", subjectNames.length);
            list[4] = new Student("Mieszko", "Koleszko", subjectNames.length);
        }

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < subjectNames.length; j++) {
                int grade = (int) (5 * Math.random() + 2);
                list[i].addSubject(new SchoolSubject(subjectNames[j], grade), j);
            }
        }

        Arrays.sort(list);

        System.out.println(Arrays.toString(list));

        ValueWrapper vw = new ValueWrapper();

        ValueWrapper.StaticProvider vsp = new ValueWrapper.StaticProvider();
        System.out.println(vsp.getStaticValue());

        ValueWrapper.LocalProvider vlp = vw.new LocalProvider();

        System.out.println(vlp.getLocalValue());
        System.out.println(vlp.getStaticValue());


        LocalProvider lp2 = vw.new LocalProvider();

        // ponownie wypiszmy listę naszych studentów razem ze średnią ocen, studenci zostali posortowani zgodnie z porządkiem narzuconym przez obiekt klasy Comparator
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i] + " " + list[i].getSubjectsAverage());
        }
        System.out.println("------------------------------------------------------------------");

        System.out.println(Arrays.toString(list));

        System.out.println("------------------------------------------------------------------");

        // wypisanie pojedyńczego studenta za pomocą obiektu klasy Iterator

        Iterator<SchoolSubject> iteratorStudent = list[0].iterator();
        System.out.println(iteratorStudent.toString());

        while (iteratorStudent.hasNext()) {
            // tak długo jak zostały jakieś przedmioty, wypiszmy je na konsoli
            // metoda next zwraca kolejny przedmiot (przed jej wywołaniem należy jednak sprawdzić metodą hasNext czy zostały jeszcze jakieś przedmioty)
            System.out.println(iteratorStudent.next());
        }
        System.out.println("------------------------------------------------------------------");

        // implementacja interfejsu Iterable umożliwia również wykorzystanie pętli foreach, działającej analogicznie
        for (SchoolSubject subject : list[0]) {
            System.out.println(subject);
        }
        System.out.println("------------------------------------------------------------------");

        Parent parent = new Parent();
        // nasz parent będzie obserwować pierwszego studenta
        list[0].addObserver(parent);

        // następnie ustawiajmy oceny z kolejnych przedmiotów na 2.0 dla pierwszego studenta
        // gdy średnia spadnie poniżej 3.0 rodzice automatycznie otrzymają odpowiednie powiadomienie
        // podobny mechanizm będzie wykorzystywany przy projektowaniu GUI np. odpowiednia klasa będzie automatycznie powiadamiana o kliknięciu przycisku
        for (int j = 0; j < subjectNames.length; j++) {
            list[0].addSubject(new SchoolSubject(subjectNames[j], 2), j);
        }

        int[] tab = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        IntTester.printValidInts(tab, new IntTester() {
            @Override
            public boolean isValid(int x) {
                return x % 2 == 0;
            }
        });

        IntTester.printValidInts(tab, x -> x % 3 == 0);

        IntTester.printValidInts(tab, (x) -> {
            return x % 5 == 0;
        });

        IntTester.printValidInts(tab, new IntTester() {
            @Override
            public boolean isValid(int x) {
                return x % 1 == 0;
            }
        });

        IntTester.printValidInts(tab, x -> x % 4 == 0);


    }
}
