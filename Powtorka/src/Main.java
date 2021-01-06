import javax.rmi.CORBA.Util;

public class Main {

    public static void main(String[] args) {

        //jak zrobic klase anomimowa

        Osoba o = new Osoba() {
            @Override
            public void opisz() {
                System.out.println("Nadpisanie metody z klasy bazowej");
            }
        };
        o.opisz();

        Osoba os = new Osoba() {
            @Override
            public void opisz() {
                super.opisz();
            }
        };

        os.opisz();

        Osoba oso = new Osoba() {
            @Override
            public void drugaMetoda() {
                super.drugaMetoda();
            }
        };
        System.out.println("*****");
        oso.opisz();
        oso.drugaMetoda();

        MojInterfejs ms = () -> {
            System.out.println("Z klasy anonimowej");
        };

        ms.poka();

        String testString = "Ala ma kota";
        String testString2 = "Ala ma kota!";


        UppgradedBox<String> box = new UppgradedBox<>();

        box.setObject(testString);

        String nseString = box.getObject();
        System.out.println(nseString);

        //Integer testInteger = box.getObject();


        boolean czyTakiesame = Utils.areEqual(testString, testString2);
        System.out.println(czyTakiesame);

        Integer i1 = new Integer(5);
        Integer i2 = new Integer(6);

        boolean czyTakiesameInty = Utils.areEqual(i1,i2);
        System.out.println(czyTakiesameInty);





    }
}
