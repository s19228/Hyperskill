package UTP.w7_5_ZamykanieWieluWatkow;

import javax.swing.*;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Interruputible {

    Lock lock = new ReentrantLock();

    Runnable task1 = new Runnable() {
        public void run() {
            System.out.println("Task 1 begins");
            try {
                lock.tryLock(1000, TimeUnit.SECONDS);  // próba zamknięcia rygla (czeka na wolny rygiel lub 1000 sekund)
                System.out.println("Task 1 entered");
            } catch(InterruptedException exc) {
                System.out.println("Task 1 interrupted");
            }
            System.out.println("Task 1 stopped");
        }
    };

    Runnable task2 = new Runnable() {
        public void run() {
            System.out.println("Task 2 begins");
            for (int i=1; i <= 600; i++) {
                if (Thread.currentThread().isInterrupted()) break;
                // jakieś obliczenie
                if (Thread.currentThread().isInterrupted()) break;  // chcemy przerwać możliwie najszybciej
                try {                                               // sleep() jest przerywane pzrez interrupt()!
                    Thread.sleep(1000);
                } catch (InterruptedException exc) { break; }
            }
            System.out.println("Task 2 stopped");
        }
    };


    Runnable task3 = new Runnable() {
        Scanner scan = new Scanner(  // musimy miec InterruptibleChannel, aby móc przerwać czekanie na wejściu
                new FileInputStream(FileDescriptor.in).getChannel(), "Cp852");
        public void run() {
            System.out.println("Task 3 begins");
            System.out.print(">>");
            while (scan.hasNextLine()) {
                try {
                    String s = scan.nextLine();
                    System.out.print('\n'+s + "\n>>");
                } catch (Exception exc) {
                    // Uwaga: scanner nie zgłasza wyjątków, ale przerywa dzialanie
                    exc.printStackTrace();
                    break;
                }
            }
            System.out.println("Task 3 stopped - " + scan.ioException());  // jaki wyjątek go przerwał?
        }
    };

    Interruputible() {
        ExecutorService exec = Executors.newCachedThreadPool();

        // wątek zamyka rygiel
        exec.execute(() -> lock.lock());
        exec.execute(task1);
        exec.execute(task2);
        exec.execute(task3);
        JOptionPane.showMessageDialog(null, "Press Ok to stop all tasks");
        exec.shutdownNow();
    }

}
