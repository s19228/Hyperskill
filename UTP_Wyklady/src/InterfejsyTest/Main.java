package InterfejsyTest;

public class Main {

    public static void main(String[] args) {

        System.out.println(System.getProperty("user.home"));

        Lampa lampa = new Lampa();

        Komputer komp = new Komputer();

        lampa.wlacz();
        lampa.wylacz();


        komp.wlacz();



    }


}
