/**
 * @author Gryka Konrad S19228
 */

package ArrayBlockingQueue;

import bezSynchronizacji.Buffer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QBuffer implements Buffer {

    private final BlockingQueue<Integer> buffer;

    public QBuffer() {
        buffer = new ArrayBlockingQueue<>(1);
    }

    @Override
    public int get() throws InterruptedException {
        int getVal = buffer.take();
        System.out.println("Konsument pobrał: " + getVal + " ilość elementów w buforze: " + buffer.size());
        return getVal;
    }

    @Override
    public void put(int n) throws InterruptedException {
        buffer.put(n);
        System.out.println("Producent zapisał wartość: " + n + " do bufora. Zajęte komórki w buforze: " + buffer.size());
    }
}
