package UTP.w7_4_Interrupt;

public class Task implements Runnable {

    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (byte i=1; i <= 128 ; i++) {
            if (Thread.currentThread().isInterrupted()) return;
            System.out.println(name + " " + i);
            Thread.yield();
        }
    }
}
