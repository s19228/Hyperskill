package GUI1;

public class Lamp implements Swithable {

    public Lamp(String status) {
        this.status = status;
    }

    public Lamp() {
        this.status = "off";
    }

    String status;
    String[] lampStatus = {"on", "off"};

    @Override
    public void turnOn() {
        if (status == "on") {
            System.out.println("Lampa jest już włączona!");
        } else {
            System.out.println("Lampa została włączona");
            status = "on";
        }
    }

    @Override
    public void turnOff() {
        if (status == "off") {
            System.out.println("Lampa jest już wyłączona głuptasie!");
        } else {
            System.out.println("Lampa została wyłączona");
            status = "off";
        }
    }


    public static void runDevice(Swithable device){
        device.turnOn();
        System.out.println("Device is runninig");
        device.turnOff();;
    }

}