/**
 *
 *  @author Gryka Konrad S19228
 *
 */

package ReentrantLockAndCondition;

import bezSynchronizacji.Buffer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RLBuffer implements Buffer {

    private final Lock lock = new ReentrantLock();

    private final Condition canRead = lock.newCondition();
    private final Condition canWrite = lock.newCondition();

    private int buffer = -1;
    private boolean isOccupied = false;

    @Override
    public int get() throws InterruptedException {
        int readValue;
        lock.lock();

        try {
            while (!isOccupied) {
                System.out.println("Konsument próbuje odczytu.");
                show("Bufor jest pusty. Konsument czeka");
                canRead.await();
            }
            isOccupied = false;
            readValue = buffer; // Pobierz wartość z bufora
            show("Konsument odczytuje " + readValue);
            canWrite.signalAll();
        } finally {
            lock.unlock();
        }
        return readValue;
    }

    @Override
    public void put(int n) throws InterruptedException {
        lock.lock();
        try {
            while (isOccupied) {
                System.out.println("Producent próbuje zapisu.");
                show("Bufor jest pełny. Producent czeka");
                canWrite.await();
            }
            buffer = n;
            isOccupied = true;
            show("Producent zapisuje " + buffer);
            canRead.signalAll();
        } finally {
            lock.unlock();
        }
    }

    private void show(String operation) {
        try {
            lock.lock();
            System.out.println(operation + ", czy bufor jest zajęty: " + isOccupied + ".");
        } finally {
            lock.unlock();
        }
    }
}
