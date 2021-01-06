package InterfejsyTest;

public class Lampa implements Switchable{

    String stan;

    @Override
    public void wlacz() {
        System.out.println("Lampa została włączona");
    }

    @Override
    public void wylacz() {
        System.out.println("Lampa została wyłączona");
    }
}
