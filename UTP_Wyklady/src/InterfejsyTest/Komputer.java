package InterfejsyTest;

public class Komputer implements Switchable {

    String stan;

    @Override
    public void wlacz() {
        System.out.println("Komputer został włączony");
    }

    @Override
    public void wylacz() {
        System.out.println("Komputer został wyłączony");
    }
}
