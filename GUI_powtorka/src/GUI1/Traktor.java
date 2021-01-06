package GUI1;

public class Traktor implements Swithable {
    @Override
    public void turnOn() {
        System.out.println("Traktor został włączony");
    }

    @Override
    public void turnOff() {
        System.out.println("Traktor został wyłączony");
    }


    public static void wlaczTraktora(Swithable device){
        device.turnOn();
        System.out.println("Maszynu trajkocze");
        device.turnOff();
    }


}
