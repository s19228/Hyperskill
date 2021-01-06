package UTP.w7_2_Egzekutory;

public class Task implements Runnable {

    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i  = 1; i<= 4; i++){
            System.out.println(name + " " + i);
            Thread.yield();  // static void yield() Wątek wywołujący metodę zrzeka się czasu procesora
        }
    }
}
