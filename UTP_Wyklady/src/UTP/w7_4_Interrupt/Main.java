package UTP.w7_4_Interrupt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(2);
        for (int i=1; i<=4; i++) {
            exec.execute(new Task("Task " + i));
        }
        Thread.yield();
        exec.shutdown();

        try {
            exec.execute(new Task("Task after shutdown"));
        } catch (RejectedExecutionException  exc) {
            exc.printStackTrace();
        }
        try {
            exec.awaitTermination(5, TimeUnit.SECONDS);
        } catch(InterruptedException exc) { exc.printStackTrace(); }
        System.out.println("Terminated: " + exec.isTerminated());

    }


}
