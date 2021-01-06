/**
 *
 *  @author Gryka Konrad S19228
 *
 */

package bezSynchronizacji;

public class MyBuffer implements Buffer {

    // Klasa UnsynchronizedBuffer, która przechowuje współdzieloną liczbę całkowitą
    // wykorzystywaną przez wątek producenta i wątek konsumenta

    private int buffer = -1; // Współdzielone przez wątki producenta i konsumenta

    @Override
    public int get() throws InterruptedException {
        System.out.println("Konsument pobrał z bufora: " + buffer);
        return buffer;
    }

    @Override
    public void put(int n) throws InterruptedException {
        System.out.println("Producent zapisał do bufora wartość: " + n);
        buffer = n;
    }
}
